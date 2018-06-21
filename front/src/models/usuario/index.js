import { BaseModel } from '../_base'

export class Usuario extends BaseModel {

    constructor(properties) {
        super()

        this.id = ''
        this.nome = ''
        this.cpf = ''
        this.dataNascimento = ''

        super.bind(properties)
    }

    isValid() {
        return (this.nome.length > 0) &&
               (this.cnpj.length === 14 || this.cnpj.length === 18)
    }

}
