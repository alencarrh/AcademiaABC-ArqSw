import React, { Component } from 'react'
import './styles.css'
import {
  AmLoader
} from 'am-components'

export class BaseList extends Component {

  constructor({pageTitle, listTitle, searchPlaceholder, listActions, searchAction, thead, tbody, tfoot, totalCol}) {
    super()

    this.pageTitle = pageTitle
    this.listTitle = listTitle
    this.totalCol = totalCol
    this.searchPlaceholder = searchPlaceholder
    this.searchAction = searchAction
    this.listActions = listActions
    this.thead = thead
    this.tbody = tbody
    this.tfoot = tfoot

    this.state = {
      objects: [],
      isLoading: false
    }
  }

  setObjects(itens) {
    this.setIsLoading(false)
    this.setState({ objects: itens })
  }

  setIsLoading(isLoading) {
    this.setState({ isLoading: isLoading })
  }

  // Actions

  renderActions() {
    if(this.listActions) {
      return this.listActions()
    }
  }

  searchChanged(event) {
    if(this.searchAction) {
      this.searchAction(event.target.value)
    }
  }

  // Renders

  renderSearchBar() {
    if(this.searchAction) {
      return(
        <input className="input-search" type="search" placeholder={this.searchPlaceholder ? this.searchPlaceholder : "Pesquisar..."} onChange={e => this.searchChanged(e)}/>
      )
    }
  }

  renderTable() {
    return(
      <table>
        <thead>
          { this.renderThead() }
        </thead>

        <tbody>
          { this.renderTbody() }
        </tbody>

        <tfoot>
          { this.renderTfoot() }
        </tfoot>
      </table>
    )
  }

  renderThead() {
    if(!this.thead) {
      return null
    }

    return this.thead()
  }

  renderTbody() {
    if (this.state.isLoading) {
      return (
        <tr>
          <td colSpan="4"><AmLoader /></td>
        </tr>
      )
    }
    if(!this.tbody || (!this.state.objects || this.state.objects.length === 0)) {
      return(
        <tr>
          <td colSpan={this.totalCol}>
            <div className="flex justify-center">
              <span className="warning-box">Ops.. Nenhum resultado encontrado.</span>
            </div>
          </td>
        </tr>
      )
    }

    return this.state.objects.map((object, key) => (
      this.tbody(object, key)
    ))
  }

  renderTfoot() {
    if(!this.tfoot) {
      return null
    }

    return this.tfoot()
  }

  render(template = null) {
    return (
      <div className="content__inner">
        <h1>{ this.pageTitle }</h1>

        <div className="content__inner__section">
          <div className="content__inner__section__header">
            <h2>{ this.listTitle }</h2>
          </div>

          <div className="content__inner__section__body">
            <div className="list">
              <div className="list__actions">
                { this.renderSearchBar() }
                { this.renderActions() }
              </div>

              <div className="list__content">
                { template !== null ? template : this.renderTable() }
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
