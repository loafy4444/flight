export default class AppController {
  /* @ngInject */
  constructor ($log, appService) {
    $log.debug('AppController instantiated.')
    this.appService = appService
  }
}
