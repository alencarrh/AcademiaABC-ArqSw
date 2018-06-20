import React, { Component } from 'react'
import './styles.css'

const maxLength = 7

export class AmColorPicker extends Component {

  onInputChange(event) {
    if(this.props.onInputChange){
      this.props.onInputChange(event)
    }
  }

  render() {
    return(
      <div className="input-group">

        <div required className="color-picker">
          <input required maxLength={maxLength} className="color-picker__input" type="text" id={this.props.id} placeholder={this.props.placeholder} value={this.props.value} onChange={e => this.onInputChange(e)}/>
          <input required className="color-picker__picker" type="color" id={this.props.id} value={this.props.value} onChange={e => this.onInputChange(e)}/>
        </div>

        <label htmlFor="client-name">{this.props.title}</label>
      </div>
    )
  }
}


AmColorPicker.defaultProps = {
  title: 'Título',
  placeholder: 'Placeholder',
  value: '',
  id: ''
}
