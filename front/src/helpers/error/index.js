import { ToastrService } from 'am-services'

export class ErrorHelper {
  static handleError(error) {
    if(error.message && error.message.toLowerCase() === 'network error') {
      ToastrService.error('Ops...', 'Tivemos um erro de conexão, tente novamente mais tarde.')
    } else if(error.request.response) {
      let messages = JSON.parse(error.request.response)
      const objectKeys =  Object.getOwnPropertyNames(messages)
      objectKeys.forEach(prop =>
        ToastrService.error('Ops...', Object.getOwnPropertyDescriptor(messages, prop).value))
    } else {
      ToastrService.error('Ops...', 'Um erro inesperado aconteceu, tente novamente mais tarde.')
    }
  }
}
