import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../models/employee';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/api/employees';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl);
  }

  getById(id: number) {
  return this.http.get<Employee>(
    `http://localhost:8080/api/employees/by-id?id=${id}`
  );
}


  create(emp: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.baseUrl, emp);
  }

  update(id: number, emp: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.baseUrl}?id=${id}`, emp);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}?id=${id}`);
  }

  search(keyword: string): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}/search?keyword=${keyword}`);
  }
}
