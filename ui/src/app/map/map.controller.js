export default class MapController {
  /* @ngInject */
  constructor ($log, $map) {
    this.$map = $map
    $log.debug('MapCtrl instantiated.')
  }
}
