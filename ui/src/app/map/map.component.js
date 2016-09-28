import templateUrl from './map.template.html'

/* @ngInject */
class MapController {
  zoom = 7
  center = [35.5175, -86.5804]
  markers = []
  paths = []

  constructor ($map, locations) {
    this.$map = $map
    let i = 0
    const colors = ['#CC0099', '#AA1100', '#FF3388', '#660066', '#CC66ff']

    // Works with multiple leg flights, though you have to add them
    // in the database due to other issues.
    $map.details.forEach(flight => {
      let origin = $map.nameCheck(flight.origin)
      let destination = $map.nameCheck(flight.destination)

      $map.getMarkerByCityName(origin)
        .then(origin => {
          this.addMarker(origin)
          $map.getMarkerByCityName(destination)
            .then(destination => {
              this.addMarker(destination)
              this.addPath(origin, destination, colors[ i % 5 ])
              i++
            })
        })
    })
  }

  addMarker ({ latitude, longitude }) {
    this.markers.push({
      position: `[${latitude}, ${longitude}]`
    })
  }

  addPath (a, b, color) {
    this.paths.push({
      path: `[[${a.latitude}, ${a.longitude}], [${b.latitude}, ${b.longitude}]]`,
      strokeColor: color,
      strokeOpacity: 1.0,
      strokeWeight: 2,
      geodesic: true
    })
  }

}

export default {
  templateUrl,
  controller: MapController,
  controllerAs: '$mapCtrl'
}
