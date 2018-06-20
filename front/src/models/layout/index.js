import { BaseModel } from '../_base'

const colorSize = 7

export class Layout extends BaseModel {

    constructor(properties) {
        super()

        this.backgroundColor = ''
        this.boxBackground = ''
        this.campaignTitleColor = ''
        this.dangerColor = ''
        this.defaultTextColor = ''
        this.primaryColor = ''
        this.secondaryColor = ''

        super.bind(properties)
    }


    isValid() {
      return this.backgroundColor.length === colorSize &&
      this.boxBackground.length === colorSize &&
      this.campaignTitleColor.length === colorSize &&
      this.dangerColor.length === colorSize &&
      this.defaultTextColor.length === colorSize &&
      this.primaryColor.length === colorSize &&
      this.secondaryColor.length === colorSize
    }

}
