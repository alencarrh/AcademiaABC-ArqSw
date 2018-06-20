import { BaseModel } from '../_base'

export class Campanha extends BaseModel {

    constructor(properties) {
        super()

        this.id = ''
        this.nome = ''
        this.clienteId = ''
        this.titulo = ''
        this.tituloPagina = ''
        this.codGoogleAnalytics = ''
        this.dominioCampanha = ''
        this.remetentePadrao = ''
        this.emailPadrao = ''
        this.administradores = ''
        this.status = ''

        super.bind(properties)
    }

}
