import { HttpService } from '../'

export class BaseService {
  constructor(baseUrl) {
    this.httpService = new HttpService()
    this.baseUrl = baseUrl
  }

  get(query) {
    return this.httpService.get(this.baseUrl, query)
      .then(result => result.data)
  }

  getById(id) {
    return this.httpService.get(`${this.baseUrl}/${id}`)
      .then(result => result.data)
  }

  rawGet(url, query) {
    return this.httpService.get(url, query)
      .then(result => result.data)
  }

  save(object) {
    const saveAction = object.id ?
      this.httpService.put(this.baseUrl, object) :
      this.httpService.post(this.baseUrl, object)

    return saveAction
      .then(result => result.data)
  }

  delete(id) {
    return this.httpService.delete(`${this.baseUrl}/${id}`)
  }

  put(url, object) {
    return this.httpService.put(url, object)
      .then(result => result.data)
  }
}
