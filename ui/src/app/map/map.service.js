export default class MapService {
  /* @ngInject */
  constructor ($http, $state, $log, apiUrl, appService) {
    this.$http = $http
    this.$state = $state
    this.$log = $log
    this.apiUrl = apiUrl
    this.appService = appService

    this.details = []
  }

  getMarkerByCityName (name) {
    this.$log.debug('MapSrvc Get Marker By City Function.')
    return this.$http
      .get(`${this.apiUrl}/location/name`, { params: { name } })
      .then(result => result.data)
  }

  // Simple handling of names not being the same case as
  // found in the locations on the back end.
  nameCheck (name) {
    if (name === 'Memphis') {
      return 'Memphis'
    } else if (name === 'CHATTANOOGA') {
      return 'Chattanooga'
    } else if (name === 'KNOXVILLE') {
      return 'Knoxville'
    } else if (name === 'NASHVILLE') {
      return 'Nashville'
    }
  }
}
