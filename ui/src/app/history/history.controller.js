export default class HistoryController {
  /* @ngInject */
  constructor ($log, $state, $interval, appService, historyService, $map) {
    this.$log = $log
    this.$state = $state

    this.appService = appService
    this.historyService = historyService
    this.$map = $map

    this.$log.debug('HistoryCtrl instantiated.')
  }

  map (details) {
    this.$map.details = details
    this.$state.go('map')
  }
}
