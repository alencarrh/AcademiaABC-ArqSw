import EventEmitter from 'sm-event-emitter'
import { AmImage } from 'am-components'

export class ToastrService {
    static TOASTR_TYPES = {
      SUCCESS: 'success',
      ERROR: 'error',
      WARNING: 'warning',
      INFO: 'info'
    }

    static success(title, message, time = 3000) {
      EventEmitter.emit("TOASTR_CREATED", {
        type: this.TOASTR_TYPES.SUCCESS,
        icon: AmImage.ICONS.Checked,
        title,
        message,
        time
      })
    }

    static error(title, message, time= 3000) {
      EventEmitter.emit("TOASTR_CREATED", {
        type: this.TOASTR_TYPES.ERROR,
        icon: AmImage.ICONS.Error,
        title,
        message,
        time
      })
    }

    static warning(title, message, time = 3000) {
      EventEmitter.emit("TOASTR_CREATED", {
        type: this.TOASTR_TYPES.WARNING,
        icon: AmImage.ICONS.Warning,
        title,
        message,
        time
      })
    }

    static info(title, message, time = 3000) {
      EventEmitter.emit("TOASTR_CREATED", {
        type: this.TOASTR_TYPES.INFO,
        icon: AmImage.ICONS.Question,
        title,
        message,
        time
      })
    }
}
