import {Component} from '@angular/core';
import {AtmService} from './service/atm.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  title = 'ATM';
  accessGranted = 'granted';
  pin: number;
  balance: number;
  deposit: number;
  show = false;
  statusCode: number;

  constructor(private atmService: AtmService) {}

  public login(pin: number) {

    if (this.validate(pin)) {

      this.pin = pin;

      this.atmService.login(pin)
        .subscribe(user => {
          user.access === this.accessGranted ? this.show = true : this.show = false;
          if (!this.show) {
            alert('Access denied');
          } else {
            this.atmService.getAccount(pin)
              .subscribe(account => {
                this.balance = account.balance;
                this.deposit = account.deposit;
              },
              errorCode => this.statusCode = errorCode);
          }
        },
        errorCode => this.statusCode = errorCode);
    }
  }

  public withdraw(sum: number) {
    if (this.validate(sum)) {
      this.atmService.getAccount(this.pin)
        .subscribe(account => {
          if (account.balance < sum) {
            alert('Sorry, but you do not have enough money on your account');
          } else {
            account.balance -= sum;
            this.atmService.updateAccount(account)
              .subscribe(successCode => {
                this.statusCode = successCode;
                this.balance = account.balance;

              },
              errorCode => this.statusCode = errorCode);
          }
        },
        errorCode => this.statusCode = errorCode);
    }
  }

  public makeDeposit(sum: string) {
    if (this.validate(sum)) {
      this.atmService.getAccount(this.pin)
        .subscribe(account => {
          if (account.balance < parseFloat(sum)) {
            alert('Sorry, but you do not have enough money on your account');
          } else {
            account.deposit += parseFloat(sum);
            account.balance -= parseFloat(sum);
            this.atmService.updateAccount(account)
              .subscribe(successCode => {
                this.statusCode = successCode;
                this.balance = account.balance;
                this.deposit = account.deposit;

              },
              errorCode => this.statusCode = errorCode);
          }
        },
        errorCode => this.statusCode = errorCode);
    }
  }

  public validate(value) {
    if (!isNaN(parseFloat(value)) && isFinite(value)) {
      return true;
    }
    alert('Please enter a number value');
    return false;
  }
}
