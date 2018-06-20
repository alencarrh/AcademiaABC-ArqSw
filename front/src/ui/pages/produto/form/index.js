import React from 'react'
import { Redirect } from 'react-router'
import { BaseForm } from 'am-base'
import { ErrorHelper } from 'am-helpers'
import { Campanha } from 'am-models'
import {
  AmButton,
  AmImage,
  AmInputText,
  AmLoader
} from 'am-components'
import {
  ProdutoService,
  ClienteService,
  ToastrService
} from 'am-services'

export class ProdutoForm extends BaseForm {
  constructor(props) {
    super(props, {
      pageTitle: 'Campanhas',
      formTitle: 'Cadastrar nova campanha',
      formActions: () => (
        <div className="form__actions">
          { this.renderPublishButton() }
          <AmButton variants="button--primary" disabled={!this.isFormValid()} onClick={() => this.saveAction()}>{ AmImage.ICONS.Save }Salvar</AmButton>
        </div>
      )
    })

    this.state = {
      id: null,
      clienteId: '',
      nome: '',
      titulo: '',
      tituloPagina: '',
      codGoogleAnalytics: '',
      dominioCampanha: '',
      remetentePadrao: '',
      emailPadrao: '',
      clientes: [],
      adminName: '',
      adminEmail: '',
      administradores: [],
      fireRedirect: false,
      validFields: {
        clienteId: false,
        nome: false,
        titulo: false,
        dominioCampanha: false
      }
    }

    this.produtoService = new ProdutoService()
    this.clienteService = new ClienteService()

    this.clienteService.get()
      .then(clientes => {
        this.setState({ clientes }, this.setEditForm)
      })
      .catch((err) => {
        ErrorHelper.handleError(err)
      })
  }

  setEditForm() {
    const campanha = this.props.location.campanha

    if (campanha) {
      this.formTitle = 'Editar Campanha'
      let validFields = this.state.validFields
      validFields['clienteId'] = (campanha.clienteId !== '')
      campanha['validFields'] = validFields

      this.setState(this.props.location.campanha)
    }
  }

  isEdit() {
    return this.state.id !== null
  }

  onEventChange(event, valid) {
    let validation = this.state.validFields
    let model = {}

    model[event.target.id] = event.target.value
    validation[event.target.id] = valid
    model.validFields = validation

    this.setState(model)
  }

  onInputChange(id, value, valid = true) {
    let validation = this.state.validFields
    let model = {}

    model[id] = value
    validation[id] = valid
    model.validFields = validation

    this.setState(model)
  }

  addAdministrator() {
    let admins = this.state.administradores
    let name = this.state.adminName
    let email = this.state.adminEmail

    if (!name || !email) {
      ToastrService.info('Atenção!', 'Informe nome e e-mail do administrador')
      return;
    }

    admins.push({
      nome: name,
      email: email
    })

    this.setState({
      administradores: admins,
      adminName: '',
      adminEmail: ''
    })
  }

  removeAdministrator(key) {
    this.state.administradores.splice(key, 1)

    this.setState({
      administradores: this.state.administradores
    })
  }

  isFormValid() {
    let validFields = this.state.validFields
    let isValid = true

    Object.keys(validFields).map(function (key) {
      return isValid = isValid ? validFields[key] : isValid
    })

    return isValid
  }

  saveAction() {
    if (this.isFormValid()) {
      let campanha = new Campanha(this.state)

      super.setIsLoading(true)

      this.campanhaService.save(campanha)
        .then(() => {
          super.setIsLoading(false)
          ToastrService.success('Feito!', 'Campanha salva com sucesso!')
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
          <legend>Cliente</legend>

          <div className="form-group">
            <div className="input-group">
              <select required id="clienteId" value={this.state.clienteId} onChange={(e) => this.onEventChange(e, e.target.value !== '')}>
                <option value="" disabled selected>Escolha um cliente</option>

                {
                  this.state.clientes.map((obj, key) => {
                    return <option key={key} value={obj.id}>{obj.nome}</option>
                  })
                }
              </select>
              <label htmlFor="clienteId">Nome do Cliente</label>
            </div>
          </div>
        </fieldset>

        <fieldset className="fieldset">
          <legend>Dados Básicos</legend>

          <div className="form-group">
            <AmInputText
              required
              id="nome"
              label="Nome da Campanha"
              placeholder="Informe o nome da campanha"
              value={this.state.nome}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)}/>

            <AmInputText
              id="tituloPagina"
              label="Título da Página"
              placeholder="Informe o título da página"
              value={this.state.tituloPagina}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>

          <div className="form-group">
            <AmInputText
              required
              id="titulo"
              label="Título da Campanha"
              placeholder="Informe o título da campanha"
              value={this.state.titulo}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />

            <AmInputText
              id="codGoogleAnalytics"
              label="Código Google Analytics"
              placeholder="Informe o código do Google Analytics"
              value={this.state.codGoogleAnalytics}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>
        </fieldset>

        <fieldset className="fieldset">
          <legend>Domínios</legend>

          <div className="form-group">
            <AmInputText
              required
              id="dominioCampanha"
              label="Domínio da Campanha"
              placeholder="Informe o domínio da campanha"
              value={this.state.dominioCampanha}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>

        </fieldset>

        <fieldset className="fieldset">
          <legend>E-mail</legend>

          <div className="form-group">
            <AmInputText
              id="remetentePadrao"
              label="Nome do Remetente Padrão"
              placeholder="Informe o nome do remetente padrão"
              value={this.state.remetentePadrao}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />

            <AmInputText
              id="emailPadrao"
              type="email"
              label="E-mail Padrão da Campanha"
              placeholder="Informe o email padrão da campanha"
              value={this.state.emailPadrao}
              onChange={(id, value, valid) => this.onInputChange(id, value, valid)} />
          </div>
        </fieldset>

        <fieldset className="fieldset">
          <legend>E-mail Administradores</legend>

          <div className="form-group">
              <AmInputText
                required
                label="Nome do Administrador"
                type="text"
                id="adminName"
                placeholder="Informe o nome do administrador"
                value={this.state.adminName}
                onChange={(id, value, valid) => this.onInputChange(id, value, valid)}  />

                <AmInputText
                  required
                  type="email"
                  id="adminEmail"
                  label="E-mail do Administrador"
                  placeholder="Informe o e-mail do administrador"
                  value={this.state.adminEmail}
                  onChange={(id, value, valid) => this.onInputChange(id, value, valid)}  />
                <div className="form__links">
                  <a className="secundary-link" onClick={() => this.addAdministrator()}>Adicionar</a>
                </div>
              </div>

          <ul>
            {
              this.state.administradores.map((obj, key) => {
                return (
                  <li key={ key }>
                    { obj.nome } <small>({ obj.email })</small> - <a className="secundary-link" onClick={ (e) => this.removeAdministrator(key) }>Remover</a>
                  </li>
                )
              })
            }
          </ul>
        </fieldset>
        {
          this.state.fireRedirect && <Redirect to="/campanha" />
        }
      </form>
    )
  }
}
