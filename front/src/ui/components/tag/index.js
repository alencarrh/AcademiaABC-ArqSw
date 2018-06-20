import React, { Component } from 'react'
import './styles.css'

const TYPES = {
  PRIMARY: 'tag--primary',
  DANGER: 'tag--danger'
}

export class AmTag extends Component {
  render() {
    return (
      <span className={`tag ${TYPES[this.props.type]}`}>
        { this.props.children }
      </span>
    )
  }
}
