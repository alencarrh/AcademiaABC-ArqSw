import { BaseModel } from '../_base'
import { Layout } from 'am-models'

export class Cliente extends BaseModel {

    constructor(properties) {
        super()

        this.id = ''
        this.nome = ''
        this.cnpj = ''
        this.dominioCustomizado = ''
        this.layout = new Layout()
        this.temCampanhas = false

        super.bind(properties)
    }

    isValid() {
        return (this.nome.length > 0) &&
               (this.cnpj.length === 14 || this.cnpj.length === 18) &&
               (this.dominioCustomizado.length > 0)
    }

}
