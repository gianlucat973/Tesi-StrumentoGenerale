import {Component} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html'
})
export class AuthComponent {
  isLoginMode = true;
  fail1: boolean = false;
  fail2: boolean = false;

  constructor(private authService: AuthService, private router: Router) {
  }

  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit(form: NgForm) {
    const email = form.value.email;
    const password = form.value.password;
    if (this.isLoginMode) {
      this.authService.login(email, password).subscribe(response => {
        this.router.navigate(['/home']);
      }, error => {
        this.handleError(error);
      });
    } else {
      this.authService.signup(email, password).subscribe(response => {
        console.log(response)
      }, error => {
        console.log(error);
      });
    }
    form.reset();
  }

  handleError(error: HttpErrorResponse) {
    switch (error.status) {
      case 400:
        this.fail1 = true;
        break;
      default:
        this.fail2 = true;
        break;
    }
  }

}
