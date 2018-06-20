import React, { Component } from 'react'
import { AmButton, AmImage } from 'am-components'
import './styles.css'

export class AmHeader extends Component {
  render() {
    return (
      <header className="header">
				<div className="header__actions">
      		<AmButton variants="button--icon button--icon--primary" notification="4">
      			{ AmImage.ICONS.Notification }
      		</AmButton>

      		<AmButton variants="button--icon button--icon--primary" notification="9">
      			{ AmImage.ICONS.Message }
      		</AmButton>

      		<AmButton variants="button--icon button--icon--primary">
      			{ AmImage.ICONS.Settings }
      		</AmButton>
      	</div>
      </header>
    )
  }
}
