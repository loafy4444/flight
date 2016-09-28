var bcrypt = require('bcryptjs')

export default class AuthService {
  /* @ngInject */
  constructor ($http, $state, $log, apiUrl, appService) {
    this.$http = $http
    this.$state = $state
    this.$log = $log
    this.apiUrl = apiUrl
    this.appService = appService
  }

  register (customer) {
    this.$log.debug('AuthSrvc Registration Function.')
    bcrypt.genSalt(10, (err, salt) => {
      bcrypt.hash(customer.password, salt, (err, hash) => {
        this.$http
          .post(`${this.apiUrl}/customer`,
            {username: customer.username, email: customer.email, password: hash}
          )
      })
    })
    this.$state.go('login')
  }

  login (customer) {
    this.$log.debug('AuthSrvc Login Function.')
    let curPass = customer.password
    this.getValidCust(customer.username)
      .then((customer) => {
        if (bcrypt.compareSync(curPass, customer.password)) {
          this.$log.debug('Password Authenticated.')
          this.appService.validCust = true
          this.appService.curCust = customer
          this.$state.go('search')
        } else {
          this.$log.debug('Password not Authenticated.')
        }
    })
  }

  getValidCust (name) {
    this.$log.debug('AuthSrvc Retrieving Customer Info for Validation.')
    return this.$http
      .get(`${this.apiUrl}/customer/validate/name`, { params: { name } })
      .then(customer => customer.data)
  }
}
