export default class HistoryService {
  /* @ngInject */
  constructor ($http, apiUrl, $state, appService) {
    this.$http = $http
    this.apiUrl = apiUrl
    this.$state = $state
    this.appService = appService
  }

  getAllItineraries () {
    let results = []
    this.$http
      .get(`${this.apiUrl}/itinerary/` + this.appService.curCust.id)
      .then((itineraries) => {
        itineraries.data.forEach(itinerary => {
          let details = []
          itinerary.flight.forEach(flight => {
            details.push(flight)
          })
          results.push(details)
        })
      })
    return results
  }
}
