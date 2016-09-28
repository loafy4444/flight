export default class SearchService {
  /* @ngInject */
  constructor ($http, apiUrl, $state, appService, $map) {
    this.$http = $http
    this.apiUrl = apiUrl
    this.$state = $state
    this.appService = appService
    this.$map = $map

    this.flightIds = []
  }

  checkFlights (origin, destination) {
    console.log('SearchSrvc Check Flights Function.')
    // let results = []
    // this.$http
    //   .get(`${this.apiUrl}/flights/` + origin + '/' + destination)
    //   .then((flights) => {
    //     flights.data.forEach(flight => {
    //         results.push(flight)
    //     })
    //   })
    // return results
    let results = []
    this.$http
      .get(`${this.apiUrl}/flights`)
      .then((flights) => {
        flights.data.forEach(flight => {
          if (flight.origin === origin && flight.destination === destination) {
            results.push(flight)
          }
        })
      })
    return results
  }

  bookItinerary (flight) {
    console.log('SearchSrvc Book Flight Function.')
    let results = []
    this.$http
      .post(`${this.apiUrl}/dbflight/book`, flight)
      .then((flight) => {
        results.push(flight.data.id)
        this.$http
          .post(`${this.apiUrl}/itinerary/book/` + this.appService.curCust.id,
            results)
      })
    return null
  }
}
