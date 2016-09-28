import 'bcryptjs'

import navbar from './navbar/navbar.module.js'
import flightMap from './map/map.module.js'
import auth from './auth/auth.module.js'
import flights from './flights/flights.module.js'
import search from './search/search.module.js'
import history from './history/history.module.js'

import apiUrl from './api.url.js'

import appComponent from './app.component.js'
import appService from './app.service.js'
import routes from './app.routes.js'

export default
  angular
    .module('flight', ['ngAria',
      'ngAnimate', 'ngMaterial',
      'ngMessages', 'ui.router',
      navbar, flightMap, auth,
      flights, search, history])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .service('appService', appService)
    .config(routes)
    .name
