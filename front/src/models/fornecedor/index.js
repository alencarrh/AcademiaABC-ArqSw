import { BaseModel } from '../_base'
import { Layout } from 'am-models'

export class Fornecedor extends BaseModel {

    constructor(properties) {
        super()

        this.id = ''
        this.nome = ''
        this.cnpj = ''

        super.bind(properties)
    }

    isValid() {
        return (this.nome.length > 0) &&
               (this.cnpj.length === 14 || this.cnpj.length === 18)
    }

}
