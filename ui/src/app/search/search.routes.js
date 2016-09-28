export default
function route ($stateProvider) {
  /* @ngInject */

  $stateProvider
  .state('search', {
    url: '/search',
    component: 'flightSearch',
    title: 'Find Your Flight'
  })
}
