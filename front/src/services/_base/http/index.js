import * as axios from 'axios'

const httpClient = axios.create({
  headers: {
    'Content-Type': 'application/json'
  }
})

export class HttpService {

  get(url, setting) {
    const resolvedUrl = new UrlRequestResolver(url, setting).resolve()
    return new RequestPromiseResolver(httpClient.get(resolvedUrl)).resolve()
  }

  delete(url, setting) {
    const resolvedUrl = new UrlRequestResolver(url, setting).resolve()
    return new RequestPromiseResolver(httpClient.delete(resolvedUrl)).resolve()
  }

  post(url, data, setting) {
    const resolvedUrl = new UrlRequestResolver(url, setting).resolve()
    return new RequestPromiseResolver(httpClient.post(resolvedUrl, data)).resolve()
  }

  put(url, data, setting) {
    const resolvedUrl = new UrlRequestResolver(url, setting).resolve()
    return new RequestPromiseResolver(httpClient.put(resolvedUrl, data)).resolve()
  }
}

class RequestPromiseResolver {
  constructor(requestPromise) {
    this.requestPromise = requestPromise
  }

  resolve() {
    return new Promise((resolve, reject) => {
      this.requestPromise
        .then(response => {
          resolve(response)
        })
        .catch(error => {
          reject(error)
        })
    })
  }
}

class UrlRequestResolver {
  constructor(url, settings = {}) {
    this.apiUrl = process.env.API_URL
    this.url = url
    this.useRawUrl = settings.useRawUrl
  }

  resolve() {
    if (this.useRawUrl) {
      return this.url
    }
    return `${this.apiUrl}${this.url}`
  }
}
