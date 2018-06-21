import React from 'react'
import { Redirect } from 'react-router'
import { BaseForm } from 'am-base'
import { ErrorHelper } from 'am-helpers'
import { Usuario } from 'am-models'
import {
  AmButton,
  AmImage,
  AmInputText,
  AmLoader
} from 'am-components'
import {
  UsuarioService,
  ToastrService
} from 'am-services'

export class UsuarioForm extends BaseForm {
  constructor(props) {
    super(props, {
      pageTitle: 'Usuários',
      formTitle: 'Cadastrar novo usuário',
      formActions: () => (
        <div className="form__actions">
          <AmButton variants="button--primary" disabled={!this.isFormValid()} onClick={() => this.saveAction()}>{ AmImage.ICONS.Save }Salvar</AmButton>
        </div>
      )
    })

    this.state = {
      id: null,
      nome: '',
      cpf: '',
      dataNascimento: '',
      fireRedirect: false
    }

    this.usuarioService = new UsuarioService()
  }

  componentWillMount() {
    this.setEditForm()
  }

  setEditForm() {
    const usuario = this.props.location.usuario
    
    if(usuario) {
      this.formTitle = 'Editar Usuário'

      this.setState(this.props.location.usuario)
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
    return this.state.nome && this.state.cpf && this.state.dataNascimento
  }

  saveAction() {
    if (this.isFormValid()) {
      let usuario = new Usuario(this.state)

      super.setIsLoading(true)

      this.usuarioService.save(usuario)
        .then(() => {
          super.setIsLoading(false)
          ToastrService.success('Feito!', 'Usuário salvo com sucesso!')
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
              label="Nome"
              required
              placeholder="Informe o nome do usuário"
              value={this.state.nome}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)}/>

            <AmInputText
              id="cpf"
              label="CPF"
              placeholder="Informe o CNPJ do usuário"
              required
              value={this.state.cpf}
              disabled={this.state.id}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>

          {
            !this.state.id && (
              <div className="form-group">
                <AmInputText
                  required
                  id="dataNascimento"
                  label="Data de Nascimento"
                  required
                  type="date"
                  placeholder="Informe a data de nascimento do usuário"
                  value={this.state.dataNascimento}
                  onChange={(id, value, valid) => this.onInputChange(id, value, valid)}/>
              </div>
            )
          }
        </fieldset>
        {
          this.state.fireRedirect && <Redirect to="/usuario" />
        }
      </form>
    )
  }
}
