import React from 'react'
import { BaseList } from 'am-base'
import { Link } from 'react-router-dom'
import { ErrorHelper } from 'am-helpers'
import {
  ProdutoService,
  ToastrService
} from 'am-services'
import {
  AmImage,
  AmButton,
  AmConfirmBalloon,
} from 'am-components'

export class ProdutoList extends BaseList {
  constructor() {
    super({
      pageTitle: 'Produtos',
      listTitle: 'Lista de Produtos',
      totalCol: 7,
      searchAction: filterText => this.onSearchTextChanged(filterText),
      thead: () => this.onThead(),
      tbody: (object, key) => this.onTbody(object, key),
      tfoot: () => this.onTfoot(),
      listActions: () => this.onActions()
    })

    this.state = {
      produtos: [],
      produtosFiltrados: []
    }

    this.produtoService = new ProdutoService()
  }

  /*
    Lifecycle
  */

  componentWillMount() {
    this.getProdutos()
  }

  /*
    Data methods
  */

  getProdutos() {
    super.setIsLoading(true)

    this.produtoService.get()
      .then(objects => {
        this.setState({
          produtos: objects,
          produtosFiltrados: objects
        })

        super.setObjects(objects)
      })
      .catch((err) => {
        ErrorHelper.handleError(err)
      })
  }

  onClickDelete(produto) {
    if(produto.isDeleting) {
      this.onCancelDelete()
      return
    }

    this.state.produtos.map(item => item.isDeleting = produto.id === item.id)

    super.setObjects(this.state.produtos)
  }

  onCancelDelete() {
    this.state.produtos.map(item => item.isDeleting = false)

    super.setObjects(this.state.produtos)
  }

  onConfirmDelete(id) {
    super.setIsLoading(true)

    this.produtoService.delete(id)
      .then(() => {
        ToastrService.success('Feito!', 'O produto foi deletado com sucesso!')
        var removeIndex = this.state.produtos.map(item => item.id).indexOf(id)
        this.state.produtos.splice(removeIndex, 1)

        super.setObjects(this.state.produtos)
      })
      .catch(err => {
        ErrorHelper.handleError(err)
      })
  }

  onSearchTextChanged(filterText) {
    const filtered = this.state.produtos.filter((produto) => {
      const lower = filterText.toLowerCase()

      return produto.nome.toLowerCase().includes(lower)
    })

    this.setState({
      produtosFiltrados: filtered
    })

    super.setObjects(filtered)
  }

  onThead() {
    return(
      <tr>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Preço</th>
        <th>Qtd. Estoque</th>
        <th>Tipo</th>
        <th>Fornecedor</th>
        <th className="list__content__table-action">Ações</th>
      </tr>
    )
  }

  onTbody(produto, key) {
    const link = {
      pathname: "/produto/edit",
      produto
    }

    return(
      <tr key={ key }>
        <td>{ produto.nome }</td>
        <td>{ produto.descricao }</td>
        <td>{ produto.preco }</td>
        <td>{ produto.qtdEstoque }</td>
        <td>{ produto.tipo }</td>
        <td>{ produto.fornecedor.nome }</td>
        <td className="list__content__table-action">
          <Link to={link}>
            <AmButton variants="button--icon-table">{AmImage.ICONS.Edit}</AmButton>
          </Link>

          <span className="button button--icon-table" onClick={() => this.onClickDelete(produto)}>
            { AmImage.ICONS.Delete }

            {
              produto.isDeleting && <AmConfirmBalloon onConfirm={() => this.onConfirmDelete(produto.id)} onCancel={() => this.onCancelDelete()} />
            }
          </span>
        </td>
      </tr>
    )
  }

  onTfoot() {
    return (
      <tr>
        <td colSpan="7">Mostrando {this.state.produtosFiltrados.length} de {this.state.produtos.length } registros</td>
      </tr>
    )
  }

  onActions() {
    return(
      <div className="list__actions-buttons">
        <Link to='/produto/new'><AmButton variants="button--primary">{ AmImage.ICONS.Add } Novo Produto</AmButton></Link>
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
