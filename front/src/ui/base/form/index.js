import React, { Component } from 'react'
import './styles.css'
import {
  AmButton,
  AmImage,
  AmLoader
} from 'am-components'

export class BaseForm extends Component {
  constructor(props,{pageTitle, formTitle, formActions, defaultSaveAction}) {
    super(props)

    this.pageTitle = pageTitle
    this.formTitle = formTitle
    this.formActions = formActions
    this.defaultSaveAction = defaultSaveAction

    this.validate()

    this.state = {
      isLoading: false
    }
  }

  validate() {
    if(!this.pageTitle ||  !this.formTitle) {
      throw new Error("The properties $pageTitle and $formTitle can't be null")
    }

    if(!this.formActions && !this.defaultSaveAction) {
      throw new Error("You must set $formActions or $defaultSaveAction action")
    }
  }

  // Actions
  setIsLoading(isLoading) {
    this.setState({ isLoading: isLoading })
  }

  saveButtonAction() {
    if(this.defaultSaveAction) {
      this.defaultSaveAction()
    }
  }

  // Renders

  renderTemplate(template) {
    if(this.state.isLoading) {
      return <AmLoader />
    }

    return template
  }

  renderActions() {
    if(this.state.isLoading) {
      return
    }

    if(this.formActions) {
      return this.formActions()
    }

    return (
      <div className="form__actions">
        <AmButton variants="button--primary" onClick={() => this.saveButtonAction()}>{ AmImage.ICONS.Save } Salvar</AmButton>
      </div>
    )
  }

  render(template) {
    return (
      <div className="content__inner">
        <h1>{ this.pageTitle }</h1>

        <div className="content__inner__section">
          <div className="content__inner__section__header">
            <h2>{ this.formTitle }</h2>
          </div>

          <div className="content__inner__section__body">
            <div className="form">
              { this.renderTemplate(template) }

              { this.renderActions() }
            </div>
           
          </div>
        </div>
      </div>
    )
  }
}
