import { BaseModel } from '../_base'

export class Produto extends BaseModel {

    constructor(properties) {
        super()

        this.id = ''
        this.descricao = ''
        this.nome = ''
        this.preco = ''
        this.qtdEstoque = ''
        this.tipo = ''
        this.idFornecedor = ''

        super.bind(properties)
    }

    isValid() {
        return (this.nome.length > 0) &&
               (this.cnpj.length === 14 || this.cnpj.length === 18)
    }

}
