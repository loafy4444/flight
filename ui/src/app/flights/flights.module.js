import flightsComponent from './flights.component.js'
import FlightsService from './flights.service.js'
import routes from './flights.routes.js'

export default
  angular
    .module('flight.flights', [])
    .component('flightFlights', flightsComponent)
    .service('flightsService', FlightsService)
    .config(routes)
    .name
