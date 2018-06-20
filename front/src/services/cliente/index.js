import { BaseService } from '../_base'
import { Cliente, Layout} from 'am-models'

export class ClienteService extends BaseService {
  constructor() {
    super('cliente')
  }

  get() {
    return super.get()
      .then(response => response.data.map(item => this.parseClient(item)))
  }

  parseClient(cliente) {
    return new Cliente({
      id: cliente.id,
      nome: cliente.nome,
      cnpj: cliente.cnpj,
      dominioCustomizado: cliente.dominioCustomizado,
      layout: new Layout(cliente.layout),
      temCampanhas: cliente.temCampanhas
    })
  }
}
