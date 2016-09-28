import templateUrl from './history.template.html'

import HistoryController from './history.controller.js'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: HistoryController,
  bindings: {
    results: '<'
  }
}
