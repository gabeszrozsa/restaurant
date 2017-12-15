// export class Routes {
//   static LOGIN: String = 'user/login';
//   static REGISTER: String = 'user/register';
//   static LOGOUT: String = 'user/logout';
//   static ISSUES: String = 'issues';
// }
//
// export class Server {
//   private static address: String = 'localhost';
//   private static port: String = '4200';
//   private static prefix: String = 'api';
//
//   static routeTo(route: String) {
//     return `http://${Server.address}:${Server.port}/${Server.prefix}/${route}`
//   }
// }
export class Routes {
  static LOGIN: String = 'user/login';
  static REGISTER: String = 'user/register';
  static LOGOUT: String = 'user/logout';
  static ISSUES: String = 'issues';
  static RESTAURANTS: String = 'restaurants';
  static REVIEWS: String = 'reviews';
  static CITIES: String = 'cities';
}

export class Server {
  private static address: String = 'localhost';
  private static port: String = '8080';
  private static prefix: String = 'api';

  static routeTo(route: String) {
    return `http://${Server.address}:${Server.port}/${Server.prefix}/${route}`
  }
}
