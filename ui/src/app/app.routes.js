export default
  function routes ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/flights')

    $stateProvider
      .state('index', {
        url: '/index',
        template: '<flight-app></flight-app>',
        onEnter: function (appService) {
          console.dir(appService.validCust)
          console.dir(appService.curCust)
        }
      })
  }
