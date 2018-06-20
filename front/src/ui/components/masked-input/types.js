const CPF_MASK = [/[0-9]/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/,'-', /\d/, /\d/]
const CPF_CNPJ_MASK = [/[0-9]/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/,'-', /\d/, /\d/, /\d/]
const CNPJ_MASK = [/[0-9]/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '/', /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/]

const PHONE_MASK = ['(', /[0-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/, /\d/]
const CELLPHONE_MASK = ['(', /[0-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]

const TYPES = {
  'cpf-cnpj': {
    onInputChange: (event, callback) => {
      const NEW_MASK = event.target.value.length > 14 ? CNPJ_MASK : CPF_CNPJ_MASK
      callback(event, NEW_MASK)
    },
    mask: CPF_CNPJ_MASK
  },
  'cpf': {
    onInputChange: (event, callback) => callback(event),
    mask: CPF_MASK
  },
  'cnpj': {
    onInputChange: (event, callback) => callback(event),
    mask: CNPJ_MASK
  },
  'phone': {
    onInputChange: (event, callback) => {
      const NEW_MASK = event.target.value.length > 14 ? CELLPHONE_MASK : PHONE_MASK
      callback(event, NEW_MASK)
    },
    mask: PHONE_MASK
  }

}

export default TYPES
