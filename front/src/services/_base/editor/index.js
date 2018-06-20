import { HttpService } from '../'

export class EditorService {

  constructor(baseUrl) {
    this.httpService = new HttpService()
    this.baseUrl = baseUrl
  }

  get() {
    return this.httpService.getUnauthorized(`arquivo/${this.baseUrl}.html`)
      .then((response) => response.data)
  }

  update(content) {
    return this.httpService.put(this.baseUrl, `pagina/${this.baseUrl}`)
  }

}
