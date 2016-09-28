import templateUrl from './flights.template.html'

import FlightsController from './flights.controller.js'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: FlightsController,
  bindings: {
    flights: '<'
  }
}
