import React, { Component } from 'react'
import './styles.css'
import { NavButton } from './nav-button'
import { AmImage } from 'am-components'
import {
  AmRouter,
} from 'am-services'

export class AmSidenav extends Component {
  render() {
    return (
      <nav className="sidebar">
      	<div className="sidebar__user-info">
      		<div className="sidebar__user-info__avatar" style={{backgroundImage: 'url(https://i.imgur.com/Pe249ww.png)'}}></div>
      		Olá, Bambam
      	</div>

      	<ul className="sidebar__main-menu">
          {
            AmRouter.ROUTES.filter(route => !route.hideOnMenu).map((route, key) =>
              <NavButton key={key} to={route.path} activeOnlyWhenExact={route.exact} label={route.name} icon={AmImage.ICONS[route.icon]}/>
            )
          }
      	</ul>

      	<div className="sidebar__footer">
      		<picture className="sidebar__footer__logo">
      			{ AmImage.Logo }
      		</picture>

      		Copyright © 2018 Academia ABC. <br />
      		Todos os Direitos Reservados.
      	</div>
      </nav>

    )
  }
}
