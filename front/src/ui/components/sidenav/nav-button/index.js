import React, { Component } from 'react'
import { Route, Link } from 'react-router-dom'

export class NavButton extends Component {
  render() {
    return (
      <Route path={this.props.to} exact={this.props.activeOnlyWhenExact} children={({ match }) => (
        <li className={`sidebar__main-menu__item ${match ? 'sidebar__main-menu__item--active' : ''}`}>
          <Link to={this.props.to}>
            {this.props.icon}

            <span className="sidebar__main-menu__item__link">{this.props.label}</span>
          </Link>
        </li>
      )}/>
    )
  }
}
