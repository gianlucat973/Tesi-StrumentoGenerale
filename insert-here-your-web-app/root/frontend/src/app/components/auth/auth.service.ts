import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {BehaviorSubject, tap, throwError} from "rxjs";
import {User} from "../../model/user/user.model";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // @ts-ignore
  user = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient, private router: Router) {
  }

  signup(email: string, password: string) {
    return this.http.post('http://localhost:8081/users/', {
      email: email,
      password: password
    }).pipe(tap(response => {
      this.handleAuthentication(email, password);
    }))
  }

  login(email: string, password: string) {
    return this.http.post('http://localhost:8081/users/authenticate/', {
      email: email,
      password: password
    }).pipe(tap(response => {
      // @ts-ignore
      this.handleAuthentication(email, response.token);
    }))
  }

  handleAuthentication(email: string, token: string) {
    const user = new User(email, token);
    console.log(user);
    this.user.next(user);
    localStorage.setItem('userData', JSON.stringify(user));
  }

  autoLogin() {
    // @ts-ignore
    const userData = JSON.parse(localStorage.getItem('userData'));
    if (!userData)
      return;
    const loadedUser = new User(userData.email, userData.token);
    this.user.next(loadedUser);
  }

  logout() {
    // @ts-ignore
    this.user.next(null);
    this.router.navigate(['/auth']);
    localStorage.removeItem('userData');
  }

  isAuthenticated() {
    console.log("I'm here");
    return new Promise((resolve, reject) => {
      const token = localStorage.getItem('token');
      const email = localStorage.getItem('email');
      if (token) {
        const url = 'http://localhost:8081/users/validate';
        this.http.post(url, {email: email, token: token}).subscribe(
          (result) => {
            const data = JSON.parse(JSON.stringify(result));
            console.log(data);
            resolve(data.status);
          },
          (error) => {
            resolve(600); // ERRORE DI CONNESSIONE COL DB
          }
        );
      } else {
        resolve(401); // TOKEN NON PRESENTE NEL BROWSER
      }
    });
  }

  private handleError(errRes: HttpErrorResponse) {
    console.log("AAAAAAAA : " + errRes.status);
    let errorMessage = 'An unknown error occurred!';
    switch (errRes.status) {
      case 400:
        errorMessage = 'Wrong Email/Password';
        break;
    }
    return throwError(errorMessage);
  }
}
