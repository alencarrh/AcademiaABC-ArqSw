import React, { Component } from 'react'
import './styles.css'

export class AmButton extends Component {
  render() {
    return (
      <button onClick={this.props.onClick}
              disabled={this.props.disabled}
              className={`button ${this.props.variants}`}
              data-notification={this.props.notification}>
        <span className="button__inner">
          {this.props.children}
        </span>
      </button>
    )
  }
}
