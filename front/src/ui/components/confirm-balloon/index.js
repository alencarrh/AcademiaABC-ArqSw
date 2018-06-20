import React, { Component } from 'react'
import './styles.css'

export class AmConfirmBalloon extends Component {
  constructor() {
    super()

    this.onConfirm = this.onConfirm.bind(this)
    this.onCancel = this.onCancel.bind(this)
  }

  componentDidMount() {
    setTimeout(() => { // this fix an issue that call the event function instantly
                       // TODO: check a fancy way to fix that
      window.addEventListener('click', this.onCancel)
    }, 0)
  }

  componentWillUnmount() {
    window.removeEventListener('click', this.onCancel)
  }

  onConfirm(event) {
    this.props.onConfirm()

    event.stopPropagation()
  }

  onCancel(event) {
    this.props.onCancel()

    if(event) {
      event.stopPropagation()
    }
  }

  render() {
    return (
      <div className="balloon">
        <div className="balloon__button balloon__button--confirm" onClick={this.onConfirm}>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 17.837 17.837">
            <path d="M16.145 2.571a.7.7 0 0 0-.99 0L6.92 10.804l-4.241-4.27a.698.698 0 0 0-.989 0L.204 8.019a.703.703 0 0 0 0 .99l6.217 6.258a.704.704 0 0 0 .99 0L17.63 5.047a.7.7 0 0 0 0-.994l-1.485-1.482z"/>
          </svg>
        </div>

        <div className="balloon__button balloon__button--cancel" onClick={this.onCancel}>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 21.9 21.9">
            <path d="M14.1 11.3c-.2-.2-.2-.5 0-.7l7.5-7.5c.2-.2.3-.5.3-.7s-.1-.5-.3-.7L20.2.3c-.2-.2-.5-.3-.7-.3-.3 0-.5.1-.7.3l-7.5 7.5c-.2.2-.5.2-.7 0L3.1.3C2.9.1 2.6 0 2.4 0s-.5.1-.7.3L.3 1.7c-.2.2-.3.5-.3.7s.1.5.3.7l7.5 7.5c.2.2.2.5 0 .7L.3 18.8c-.2.2-.3.5-.3.7s.1.5.3.7l1.4 1.4c.2.2.5.3.7.3s.5-.1.7-.3l7.5-7.5c.2-.2.5-.2.7 0l7.5 7.5c.2.2.5.3.7.3s.5-.1.7-.3l1.4-1.4c.2-.2.3-.5.3-.7s-.1-.5-.3-.7l-7.5-7.5z"/>
          </svg>
        </div>
      </div>
    )
  }
}
