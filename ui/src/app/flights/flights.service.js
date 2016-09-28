export default class FlightsService {
  /* @ngInject */
  constructor ($http, $log, apiUrl, appService) {
    this.$http = $http
    this.$log = $log
    this.apiUrl = apiUrl
    this.appService = appService
  }

  getAllFlights () {
    this.$log.debug('FlightsSrvc Get All Flights Function.')
    return this.$http
      .get(`${this.apiUrl}/flights`)
      .then((flights) => flights.data)
  }
}
