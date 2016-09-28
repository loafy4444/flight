export default class SearchController {
  /* @ngInject */
  constructor ($log, $state, $interval, appService, searchService, flightsService) {
    this.$log = $log
    this.$state = $state

    this.appService = appService
    this.searchService = searchService
    this.flightsService = flightsService

    this.$log.debug('SearchCtrl instantiated.')
  }

  search () {
    this.results = this.searchService.checkFlights(this.formData.origin, this.formData.destination)
  }

  select (flight) {
    this.results = this.searchService.bookItinerary(flight)
  }
}
