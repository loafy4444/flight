export default
function route ($stateProvider) {
  /* @ngInject */

  $stateProvider
  .state('login', {
    url: '/login',
    template: '<auth-login></auth-login>',
    title: 'Login'
  })
  .state('register', {
    url: '/register',
    template: '<auth-register></auth-register>',
    title: 'Register'
  })
}
