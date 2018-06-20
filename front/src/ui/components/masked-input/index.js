import React, { Component } from 'react'
import MaskedInput, {conformToMask} from 'react-text-mask'
import TYPES from './types'

export class AmMaskedInput extends Component {
  constructor(props) {
    super(props)

    this.state = {
      type: TYPES[props.type],
      value: props.value,
      mask: TYPES[props.type].mask
    }
  }

  componentWillMount() {
    const mask = this.state.value.length > 14 ? TYPES['cnpj'].mask : TYPES['cpf-cnpj'].mask
    this.setState({mask})
  }

  onInputChangeCallback(event, newMask = false) {
    if(newMask) {
      this.setState({ mask: newMask })
    }

    const maskedValue  = conformToMask(
      event.target.value,
      newMask,
      {guide: false}
    )

    event.target.value = maskedValue.conformedValue
    
    this.props.onChange(event)
  }

  onInputChange(event) {
    this.state.type.onInputChange(event, this.onInputChangeCallback.bind(this))
  }

  // Workaround function to fix bug with 'react-text-mask'
  // Bug is that you --CAN NOT-- delete special characters!
  onKeyUp(event) {
    if( event.keyCode === 8 ) {
      if( event.target.value.length < 1 ){
        return
      }

  // Remove special characters from input field when backspace is triggered
      var inputField = event.target.value
      var regexToFilterNumbers = /\d+/g
      if (! inputField[inputField.length - 1].match(regexToFilterNumbers)) {
        event.target.value = inputField.slice(0, -1)
      }
    }
  }

  render() {
    return (
        <MaskedInput
          mask={ this.state.mask }
          required={ this.props.required }
          id={ this.props.id }
          placeholder={ this.props.placeholder }
          value={ this.props.value }
          guide={ this.props.guide || false }
          onChange={ e => this.onInputChange(e) }
          onKeyUp={ e => this.onKeyUp(e) } />
    )
  }
}
