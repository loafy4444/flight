import authLogin from './login.component.js'
import authRegister from './register.component.js'
import AuthService from './auth.service.js'
import routes from './auth.routes.js'

export default
  angular
    .module('flight.auth', [])
    .component('authLogin', authLogin)
    .component('authRegister', authRegister)
    .service('authService', AuthService)
    .config(routes)
    .name
