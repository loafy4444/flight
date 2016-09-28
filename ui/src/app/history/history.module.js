import historyComponent from './history.component.js'
import HistoryService from './history.service.js'
import routes from './history.routes.js'

export default
  angular
    .module('flight.history', [])
    .component('flightHistory', historyComponent)
    .service('historyService', HistoryService)
    .config(routes)
    .name
