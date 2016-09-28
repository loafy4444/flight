import navBarComponent from './navbar.component.js'
import navBarService from './navbar.service'

export default
  angular
    .module('flight.navbar', [])
    .component('navBar', navBarComponent)
    .service('navBarService', navBarService)
    .name
