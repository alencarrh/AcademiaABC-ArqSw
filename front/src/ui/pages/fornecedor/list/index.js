import React from 'react'
import { BaseList } from 'am-base'
import { Link } from 'react-router-dom'
import { ErrorHelper } from 'am-helpers'
import {
  FornecedorService,
  ToastrService
} from 'am-services'
import {
  AmImage,
  AmButton,
  AmConfirmBalloon,
  AmTag
} from 'am-components'

export class FornecedorList extends BaseList {
  constructor() {
    super({
      pageTitle: 'Fornecedores',
      listTitle: 'Lista de Fornecedores',
      totalCol: 3,
      searchAction: filterText => this.onSearchTextChanged(filterText),
      thead: () => this.onThead(),
      tbody: (object, key) => this.onTbody(object, key),
      tfoot: () => this.onTfoot(),
      listActions: () => this.onActions()
    })

    this.state = {
      fornecedores: [],
      fornecedoresFiltrados: []
    }

    this.fornecedorService = new FornecedorService()
  }

  /*
    Lifecycle
  */

  componentWillMount() {
    this.getFornecedores()
  }

  /*
    Data methods
  */

  getFornecedores() {
    super.setIsLoading(true)

    this.fornecedorService.get()
      .then(objects => {
        this.setState({
          fornecedores: objects,
          fornecedoresFiltrados: objects
        })

        super.setObjects(objects)
      })
      .catch((err) => {
        ErrorHelper.handleError(err)
      })
  }

  onClickDelete(fornecedor) {
    if(fornecedor.isDeleting) {
      this.onCancelDelete()
      return
    }

    this.state.fornecedores.map(item => item.isDeleting = fornecedor.id === item.id)

    super.setObjects(this.state.fornecedores)
  }

  onCancelDelete() {
    this.state.fornecedores.map(item => item.isDeleting = false)

    super.setObjects(this.state.fornecedores)
  }

  onConfirmDelete(id) {
    super.setIsLoading(true)

    this.fornecedorService.delete(id)
      .then(() => {
        ToastrService.success('Feito!', 'O fornecedor foi deletado com sucesso!')
        var removeIndex = this.state.fornecedores.map(item => item.id).indexOf(id)
        this.state.fornecedores.splice(removeIndex, 1)

        super.setObjects(this.state.fornecedores)
      })
      .catch(err => {
        ErrorHelper.handleError(err)
      })
  }

  onSearchTextChanged(filterText) {
    const filtered = this.state.fornecedores.filter((fornecedor) => {
      const lower = filterText.toLowerCase()

      return fornecedor.nome.toLowerCase().includes(lower)
    })

    this.setState({
      fornecedoresFiltrados: filtered
    })

    super.setObjects(filtered)
  }

  onThead() {
    return(
      <tr>
        <th>Nome</th>
        <th>CNPJ</th>
        <th className="list__content__table-action">Ações</th>
      </tr>
    )
  }

  onTbody(fornecedor, key) {
    const link = {
      pathname: "/fornecedor/edit",
      fornecedor
    }

    return(
      <tr key={ key }>
        <td>{ fornecedor.nome }</td>
        <td>{ fornecedor.cnpj }</td>
        <td className="list__content__table-action">
          <Link to={link}>
            <AmButton variants="button--icon-table">{AmImage.ICONS.Edit}</AmButton>
          </Link>

          <span className="button button--icon-table" onClick={() => this.onClickDelete(fornecedor)}>
            { AmImage.ICONS.Delete }

            {
              fornecedor.isDeleting && <AmConfirmBalloon onConfirm={() => this.onConfirmDelete(fornecedor.id)} onCancel={() => this.onCancelDelete()} />
            }
          </span>
        </td>
      </tr>
    )
  }

  onTfoot() {
    return (
      <tr>
        <td colSpan="3">Mostrando {this.state.fornecedoresFiltrados.length} de {this.state.fornecedores.length } registros</td>
      </tr>
    )
  }

  onActions() {
    return(
      <div className="list__actions-buttons">
        <Link to='/fornecedor/new'><AmButton variants="button--primary">{ AmImage.ICONS.Add } Novo Fornecedor</AmButton></Link>
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
