import { BaseModel } from '../_base'

export class User extends BaseModel {

    constructor(properties) {
        super()

        this.nome = ''
        this.pontos = 0

        super.bind(properties)
    }
}
