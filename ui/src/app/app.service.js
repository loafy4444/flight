export default class AppService {
  /* @ngInject */
  constructor ($http, $state, $log, apiUrl) {
    this.$http = $http
    this.$state = $state
    this.$log = $log
    this.apiUrl = apiUrl
    this.validCust = false
    this.curCust = {}
    // this.validCust = true // Dummy Cust added to stay logged in for testing
    // this.curCust = {      // because logging in was too much...
    //   'id': 1,
    //   'username': 'test',
    //   'password': '$2a$10$aMO9nUAdddoyyhIR3Yf5Te.LCP/x.rxktP2OsKC8awgjTrpZlkCYG'
    // }
  }

  logout () {
    this.validCust = false
    this.curCust = {}
    this.$state.go('flights', null, { reload: true })
  }
}
