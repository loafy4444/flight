export default class FlightsController {
  /* @ngInject */
  constructor ($scope, $log, $state, $timeout, appService, flightsService) {
    this.$log = $log

    this.appService = appService
    this.flightsService = flightsService

    this.$log.debug('FlightsCtrl instantiated.')

    $scope.pageTimer = $timeout(function () {
      $state.reload()
    }, 25000)

    $scope.$on('$destroy', function () {
      $timeout.cancel($scope.pageTimer)
    })
  }
}
