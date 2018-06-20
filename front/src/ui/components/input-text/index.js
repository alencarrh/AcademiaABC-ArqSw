import React, { Component } from 'react'

const emailRegularExpression = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

export class AmInputText extends Component {
  constructor(props) {
    super(props)

    this.state = {
      valid: true,
      value: props.value,
      message: ''
    }

    this.validate()
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.value !== this.state.value) {
      this.setState({
        value: nextProps.value || ''
      }, this.propagateChange)
    }
  }

  validate() {
    if (!this.props.id) {
      throw new Error("Property $id can't be null")
    }

    if (!this.props.onChange) {
      throw new Error("You must set $onChange action")
    }
  }

  propagateChange() {
    this.props.onChange(this.props.id, this.state.value, this.state.valid)
  }

  onInputChange(event) {
    this.setState({
      value: event.target.value,
      valid: this.validateInput(event),
      message: ''
    }, () => {
      if (this.props.onChange) {
        this.props.onChange(this.props.id, this.state.value, this.state.valid)
      }
    })
  }

  validateInput(event) {
    const input = event.target.value
    if(this.props.required && this.props.type !== 'email') {
      return !(input === '')
    }
    else if (this.props.required && this.props.type === 'email') {
      return !(input === '') && emailRegularExpression.test(event.target.value)
    }
    else if (this.props.type === 'email'){
      return  input.length > 0 ? emailRegularExpression.test(event.target.value) : true
    }
    return true
  }

  validateRequired(event) {
    event.persist()
    const message = this.props.type === 'email' ? 'Email inválido' : 'Campo obrigatório'

    this.setState({
      message: this.state.valid ? '' : message
    }, () => {
      if (this.props.onBlur) {
        this.props.onBlur(event, this.state.valid)
      }
    })
  }

  render() {
    return (
      <div className="input-group">
        <span className="message">{this.state.message}</span>
        <input
          required={this.props.required}
          type="text"
          id={this.props.id}
          placeholder={this.props.placeholder}
          value={this.state.value}
          onChange={e => this.onInputChange(e)}
          onBlur={e => this.validateRequired(e)}  />
        <label htmlFor={this.props.id}>{this.props.label}</label>
      </div>
    )
  }
}
