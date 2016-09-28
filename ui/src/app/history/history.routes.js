export default
function route ($stateProvider) {
  /* @ngInject */

  $stateProvider
  .state('history', {
    url: '/history',
    component: 'flightHistory',
    title: 'Saved Flights',
    resolve: {
      results: function (historyService) {
        return historyService.getAllItineraries()
      }
    }
  })
}
