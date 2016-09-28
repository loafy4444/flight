export default
function route ($stateProvider) {
  /* @ngInject */

  $stateProvider
  .state('flights', {
    url: '/flights',
    component: 'flightFlights',
    title: 'Daily Flights',
    resolve: {
      flights: function (flightsService) {
        return flightsService.getAllFlights()
      }
    }
  })
}
