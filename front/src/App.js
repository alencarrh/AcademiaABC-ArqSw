import React, { Component } from 'react'
import './app.css'
import {
  AmHeader,
  AmSidenav,
  AmMain,
  AmToastr,
} from 'am-components'

export default class App extends Component {
  render() {
    return (
      <div className="container">
        <AmToastr />

        <AmSidenav />

        <div className="content-wrapper">
          <AmHeader />

          <AmMain className="content" />
        </div>
      </div>
    )
  }
}
