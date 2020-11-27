import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Player247 } from '../model/player247';

@Injectable({
  providedIn: 'root'
})
export class ScraperService {

  private baseUrl = 'scrape/247';

  constructor(private http: HttpClient) {
  }

  scrape(college: string, year: string): Observable<Player247[]> {
    const url = `${this.baseUrl}/${college}/${year}`;
    console.log('scrape url -> ' + url);
    return this.http.get<Player247[]>(url).pipe(
      catchError(this.handleError<Player247[]>(`Season: ${year}`))
    );
  }

  getPlayers(): Observable<Player247[]> {
    const url = `/recruit`;
    return this.http.get<Player247[]>(url).pipe(
      catchError(this.handleError<Player247[]>(`getPlayers`))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
