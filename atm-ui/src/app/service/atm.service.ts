import {Injectable} from '@angular/core';
import {Http, Response, Headers, URLSearchParams, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {User} from './user';
import {Account} from './account';


@Injectable()
export class AtmService {

  //URLs
  loginUrl = 'http://localhost:8080/atm/login';
  accountUrl = 'http://localhost:8080/atm/account';

  constructor(private http: Http) {
  }

  //Login with a pin number
  public login(pin: number): Observable<User> {

    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: cpHeaders});

    return this.http.get(this.loginUrl + '/' + pin, options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  //Get account
  public getAccount(pin: number): Observable<Account> {

    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: cpHeaders});

    return this.http.get(this.accountUrl + '/' + pin, options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  //Update account
  updateAccount(account: Account): Observable<number> {
    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: cpHeaders});
    return this.http.put(this.accountUrl, account, options)
      .map(success => success.status)
      .catch(this.handleError);
  }


  private extractData(res: Response) {
    let body = res.json();
    return body;
  }
  private handleError(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }
}
