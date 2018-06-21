import React from 'react'
import { BaseList } from 'am-base'
import { Link } from 'react-router-dom'
import { ErrorHelper } from 'am-helpers'
import {
  UsuarioService,
  ToastrService
} from 'am-services'
import {
  AmImage,
  AmButton,
  AmConfirmBalloon,
} from 'am-components'

export class UsuarioList extends BaseList {
  constructor() {
    super({
      pageTitle: 'Usuários',
      listTitle: 'Lista de Usuários',
      totalCol: 4,
      searchAction: filterText => this.onSearchTextChanged(filterText),
      thead: () => this.onThead(),
      tbody: (object, key) => this.onTbody(object, key),
      tfoot: () => this.onTfoot(),
      listActions: () => this.onActions()
    })

    this.state = {
      usuarios: [],
      usuariosFiltrados: []
    }

    this.usuarioService = new UsuarioService()
  }

  /*
    Data methods
  */

  componentWillMount() {
    this.getUsuarios()
  }

  /*
    Data methods
  */

  getUsuarios() {
    super.setIsLoading(true)

    this.usuarioService.get()
      .then(objects => {
        this.setState({
          usuarios: objects,
          usuariosFiltrados: objects
        })

        super.setObjects(objects)
      })
      .catch((err) => {
        ErrorHelper.handleError(err)
      })
  }

  onClickDelete(usuario) {
    if(usuario.isDeleting) {
      this.onCancelDelete()
      return
    }

    this.state.usuarios.map(item => item.isDeleting = usuario.id === item.id)

    super.setObjects(this.state.usuarios)
  }

  onCancelDelete() {
    this.state.usuarios.map(item => item.isDeleting = false)

    super.setObjects(this.state.usuarios)
  }

  onConfirmDelete(id) {
    super.setIsLoading(true)

    this.usuarioService.delete(id)
      .then(() => {
        ToastrService.success('Feito!', 'O usuário foi deletado com sucesso!')

        var removeIndex = this.state.usuarios.map(item => item.id).indexOf(id)
        this.state.usuarios.splice(removeIndex, 1)
        
        super.setObjects(this.state.usuarios)
      })
      .catch(err => {
        ErrorHelper.handleError(err)
      })
  }

  onSearchTextChanged(filterText) {
    const filtered = this.state.usuarios.filter((usuario) => {
      const lower = filterText.toLowerCase()

      return usuario.nome.toLowerCase().includes(lower)
    })

    this.setState({
      usuariosFiltrados: filtered
    })

    super.setObjects(filtered)
  }

  onThead() {
    return(
      <tr>
        <th>Nome</th>
        <th>CPF</th>
        <th>Data de Nascimento</th>
        <th className="list__content__table-action">Ações</th>
      </tr>
    )
  }

  onTbody(usuario, key) {
    const link = {
      pathname: "/usuario/edit",
      usuario
    }

    return(
      <tr key={ key }>
        <td>{ usuario.nome }</td>
        <td>{ usuario.cpf }</td>
        <td>{ usuario.dataNascimento.reverse().join('/') }</td>
        <td className="list__content__table-action">
          <Link to={link}>
            <AmButton variants="button--icon-table">{AmImage.ICONS.Edit}</AmButton>
          </Link>
        </td>
      </tr>
    )
  }

  onTfoot() {
    return (
      <tr>
        <td colSpan="4">Mostrando {this.state.usuariosFiltrados.length} de {this.state.usuarios.length } registros</td>
      </tr>
    )
  }

  onActions() {
    return(
      <div className="list__actions-buttons">
        <Link to='/usuario/new'><AmButton variants="button--primary">{ AmImage.ICONS.Add } Novo usuário</AmButton></Link>
      </div>
    )
  }

  /**
   * Renders
   */

  render() {
    return super.render()
  }
}
