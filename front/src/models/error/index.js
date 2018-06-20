import { BaseModel } from '../_base'

export class ErrorModel extends BaseModel {
    constructor(properties) {
        super()

        this.message = 'Ocorreu um erro inesperado. Por favor, tente mais tarde!'
        this.error = new Error()
        this.isErrorModel = true

        super.bind(properties)
    }
}
