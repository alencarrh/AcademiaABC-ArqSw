import React, { Component } from 'react'

export class AmActiveTag extends Component {
  render() {
    return (
      <span className={`tag ${this.props.isActive ? 'tag--primary' : 'tag--danger'}`}>
        {this.props.isActive ? this.props.activeLabel : this.props.deactiveLabel}
      </span>
    )
  }
}

AmActiveTag.defaultProps = {
  isActive: true,
  activeLabel: 'Ativa',
  deactiveLabel: 'Inativa'
}
