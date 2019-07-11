// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
    production: false,
    apiHost: '',
    CONSUMER_KEY : 'someReallyStupidTextWhichWeHumansCantRead', 
    codes: [ 'AB', 'AC', 'XYZ' ],
    projectTitle: 'crescent',
    endpoint: 'http://172.18.2.50:7706/eventmanagementservice/',
    userManagementBaseUrl: 'http://172.18.2.50:7706/giveaway-usermanagement/',
    inventoryManagementBasUrl: 'http://172.18.2.50:7706/giveaway-inventorymanagement/',
    reportendpont: 'http://172.18.2.50:7706/giveawayreportingservice/',
    mailBasUrl: 'http://172.18.2.50:7706/mailingsystem/'
  };

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
