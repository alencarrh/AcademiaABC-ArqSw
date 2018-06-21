import React from 'react'
import { Redirect } from 'react-router'
import { BaseForm } from 'am-base'
import { ErrorHelper } from 'am-helpers'
import { Produto } from 'am-models'
import {
  AmButton,
  AmImage,
  AmInputText,
  AmLoader
} from 'am-components'
import {
  ProdutoService,
  FornecedorService,
  ToastrService
} from 'am-services'

export class ProdutoForm extends BaseForm {
  constructor(props) {
    super(props, {
      pageTitle: 'Campanhas',
      formTitle: 'Cadastrar nova campanha',
      formActions: () => (
        <div className="form__actions">
          <AmButton variants="button--primary" disabled={!this.isFormValid()} onClick={() => this.saveAction()}>{ AmImage.ICONS.Save }Salvar</AmButton>
        </div>
      )
    })

    this.state = {
      id: null,
      nome: '',
      descricao: '',
      preco: '',
      qtdEstoque: '',
      tipo: '',
      idFornecedor: null,
      fornecedores: [],
      fireRedirect: false
    }

    this.produtoService = new ProdutoService()
    this.fornecedorService = new FornecedorService()
  }

  componentWillMount() {
    this.getFornecedores()
  }

  getFornecedores() {
    this.fornecedorService.get()
      .then(result => {
        this.setState({
          fornecedores: result
        })

        this.setEditForm()
      })
  }

  setEditForm() {
    const produto = this.props.location.produto

    if (produto) {
      this.formTitle = 'Editar Produto'
      produto.idFornecedor = produto.fornecedor.id
      this.setState(this.props.location.produto)
    }
  }

  isEdit() {
    return this.state.id !== null
  }


  onInputChange(id, value, valid = true) {
    let model = {}

    model[id] = value

    this.setState(model)
  }

  isFormValid() {
    return (
      this.state.nome &&
      this.state.descricao && 
      this.state.preco &&
      this.state.qtdEstoque && 
      this.state.tipo &&
      this.state.idFornecedor
    )
  }

  saveAction() {
    if (this.isFormValid()) {
      let produto = new Produto(this.state)

      super.setIsLoading(true)

      this.produtoService.save(produto)
        .then(() => {
          super.setIsLoading(false)
          ToastrService.success('Feito!', 'Produto salvo com sucesso!')
          this.setState({ fireRedirect: true })
        })
        .catch(err => {
          super.setIsLoading(false)
          ErrorHelper.handleError(err)
        })
    }
  }

  render() {
    return super.render(
      <form>
        <fieldset className="fieldset">
          <legend>Fornecedor</legend>

          <div className="form-group">
            <div className="input-group">
              <select required id="idFornecedor" value={this.state.idFornecedor} onChange={(e) => this.onInputChange(e.target.id, e.target.value)}>
                <option value="" disabled selected>Escolha um fornecedor</option>

                {
                  this.state.fornecedores.map((obj, key) => {
                    return <option key={key} value={obj.id}>{obj.nome}</option>
                  })
                }
              </select>
              <label htmlFor="idFornecedor">Nome do Fornecedor</label>
            </div>
          </div>
        </fieldset>

        <fieldset className="fieldset">
          <legend>Dados Básicos</legend>

          <div className="form-group">
            <AmInputText
              required
              id="nome"
              label="Nome"
              placeholder="Informe o nome do produto"
              value={this.state.nome}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)}/>

            <AmInputText
              id="descricao"
              label="Descrição"
              placeholder="Informe a descrição do produto"
              value={this.state.descricao}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>

          <div className="form-group">
            <AmInputText
              required
              id="preco"
              label="Preço"
              placeholder="Informe o preço do produto"
              value={this.state.preco}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />

            <AmInputText
              id="qtdEstoque"
              label="Quantidade em Estoque"
              placeholder="Informe a quantidade em estoque"
              value={this.state.qtdEstoque}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>

          <div className="form-group">
            <AmInputText
              required
              id="tipo"
              label="Tipo"
              placeholder="Informe o tipo do produto"
              value={this.state.tipo}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>
        </fieldset>

        {
          this.state.fireRedirect && <Redirect to="/produto" />
        }
      </form>
    )
  }
}
