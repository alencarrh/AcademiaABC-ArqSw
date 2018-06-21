import React from 'react'
import { Redirect } from 'react-router'
import { BaseForm } from 'am-base'
import { ErrorHelper } from 'am-helpers'
import { Fornecedor } from 'am-models'
import {
  AmButton,
  AmImage,
  AmInputText,
  AmLoader
} from 'am-components'
import {
  FornecedorService,
  ToastrService
} from 'am-services'

export class FornecedorForm extends BaseForm {
  constructor(props) {
    super(props, {
      pageTitle: 'Fornecedores',
      formTitle: 'Cadastrar novo fornecedor',
      formActions: () => (
        <div className="form__actions">
          <AmButton variants="button--primary" disabled={!this.isFormValid()} onClick={() => this.saveAction()}>{ AmImage.ICONS.Save }Salvar</AmButton>
        </div>
      )
    })

    this.state = {
      id: null,
      nome: '',
      cnpj: '',
      fireRedirect: false,
      validFields: {
        nome: false,
        cnpj: false
      }
    }

    this.fornecedorService = new FornecedorService()
  }

  componentWillMount() {
    this.setEditForm()
  }

  setEditForm() {
    const fornecedor = this.props.location.fornecedor

    if(fornecedor) {
      this.formTitle = 'Editar Fornecedor'
      let validFields = this.state.validFields
      fornecedor['validFields'] = validFields

      this.setState(this.props.location.fornecedor)
    }
  }

  isEdit() {
    return this.state.id !== null
  }

  onInputChange(id, value, valid = true) {
    let validation = this.state.validFields
    let model = {}

    model[id] = value
    validation[id] = valid
    model.validFields = validation

    this.setState(model)
  }

  isFormValid() {
    return this.state.nome && this.state.cnpj
  }

  saveAction() {
    if (this.isFormValid()) {
      let fornecedor = new Fornecedor(this.state)

      super.setIsLoading(true)

      this.fornecedorService.save(fornecedor)
        .then(() => {
          super.setIsLoading(false)
          ToastrService.success('Feito!', 'Fornecedor salvo com sucesso!')
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
          <legend>Dados Básicos</legend>

          <div className="form-group">
            <AmInputText
              required
              id="nome"
              label="Nome do Fornecedor"
              required
              placeholder="Informe o nome do fornecedor"
              value={this.state.nome}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)}/>

            <AmInputText
              id="cnpj"
              label="CNPJ do Fornecedor"
              placeholder="Informe o CNPJ do fornecedor"
              required
              value={this.state.cnpj}
              disabled={this.state.id}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>
        </fieldset>
        {
          this.state.fireRedirect && <Redirect to="/fornecedor" />
        }
      </form>
    )
  }
}
