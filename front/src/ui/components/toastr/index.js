import React, { Component } from 'react'
import EventEmitter from 'sm-event-emitter'
import './styles.css'
import { CSSTransition, TransitionGroup } from 'react-transition-group'

export class AmToastr extends Component {
  constructor() {
    super()

    this.state = {
      visible : true,
      notifications: []
    }
  }

  componentDidMount() {
    EventEmitter.on('TOASTR_CREATED', data => {
      this.state.notifications.push(data);
      this.setState({ notifications: this.state.notifications })

      setTimeout(() => {
        this.removeNotification(data)
      }, data.time)
    })
  }

  removeNotification(notification) {
    const index = this.state.notifications.indexOf(notification)

    if(index >= 0) {
      this.state.notifications.splice(index, 1)
      this.setState({ notifications: this.state.notifications })
    }
  }

  renderNotifications() {
    return this.state.notifications.map((notification, key) => {
      return (
        <CSSTransition
          key={ key }
          classNames="fade" >
          <div onClick={ () => this.removeNotification(notification) } key={key} className={`toastr toastr--${ notification.type }`}>

            <div className="toastr__status">
              <div className="toastr__status__icon">
                { notification.icon }
              </div>
            </div>

            <div className="toastr__content">
              <h3> { notification.title } </h3>
              <span> { notification.message } </span>
            </div>

          </div>
        </CSSTransition>
      )
    })
  }

  render() {
    return (
      <div> 
      { this.state.notifications.length > 0 && (
        <div className="toastr-wrapper">
          <TransitionGroup>
            { this.renderNotifications() }
          </TransitionGroup>
        </div>
      )}
      </div>
    )
  }
}
