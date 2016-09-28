import searchComponent from './search.component.js'
import searchService from './search.service.js'
import routes from './search.routes.js'

export default
  angular
    .module('flight.search', [])
    .component('flightSearch', searchComponent)
    .service('searchService', searchService)
    .config(routes)
    .name
