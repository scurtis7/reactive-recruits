import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { College } from '../model/college';

@Injectable({
  providedIn: 'root'
})
export class CollegeService {

  private baseUrl = 'colleges';

  constructor(private http: HttpClient) {
  }

  getAllColleges(): Observable<College[]> {
    return this.http.get<College[]>(this.baseUrl).pipe(
      catchError(this.handleError<College[]>(`getAllColleges`))
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
