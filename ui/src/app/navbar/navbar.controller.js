export default class NavBarController {
  /* @ngInject */
  constructor ($log, $state, appService, navBarService) {
    this.$log = $log
    this.$state = $state

    this.appService = appService
    this.navBarService = navBarService

    this.$log.debug('NavBarCtrl instantiated.')
  }
}
