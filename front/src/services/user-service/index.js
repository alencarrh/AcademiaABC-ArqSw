import { User } from 'am-models'
import {
  HttpService,
} from '../_base'

let instance = null

export class UserService {
  constructor(user) {
    this.httpService = new HttpService()

    this.loggedUser = null
  }

  static getInstance() {
    if (!instance) {
      instance = new UserService()
    }

    return instance
  }

  setLoggedUser(user) {
    return this.getPontos()
            .then(result => {
              this.loggedUser = new User({
                nome: user.name,
                pontos: result
              })
            })
  }

  getLoggedUser() {
    return this.loggedUser
  }

  saveParticipation({ terms, segmentationId }) {
    return this.httpService.post('participante', { termos: terms, idGrupo: segmentationId })
      .then(result => result.data)
  }

  getUserAuthorized() {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve({ autorizado: true })
      }, 1000)
    })
  }

  getUserBound() {
    return this.httpService.get('participante/vinculado')
      .then(result => result.data)
  }

  getPontos() {
    return new Promise((resolve, reject) => {
      resolve(0)
    })
  }

}
