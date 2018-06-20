import React, { Component } from 'react'
import { Switch, Route, Redirect } from 'react-router-dom'
import './styles.css'
import { AmRouter } from 'am-services'

export class AmMain extends Component {
  render() {
    return (
      <section className={this.props.className}>
        <Switch>
          {
            AmRouter.ROUTES.map((route, key) =>
              <Route key={key} exact={route.exact} path={route.path} component={route.component} />
            )
          }

          <Redirect from="/" to="/produtos" />

        </Switch>
      </section>
    )
  }
}
