const PREFIX = 'askme'

const buildKey = key => `${PREFIX}.${key}`

const buildData = data => {
  if(typeof data === "object") {
    data = JSON.stringify(data)
  }

  return data
}

const deserializer = data => {
  try {
    return JSON.parse(data)
  } catch(e) {
    return data
  }
}

export class LocalStorageService {
    static setItem(key, data) {
      key = buildKey(key)
      data = buildData(data)

      localStorage.setItem(key, data)
    }

    static getItem(key) {
      key = buildKey(key)

      return deserializer(localStorage.getItem(key))
    }
}
