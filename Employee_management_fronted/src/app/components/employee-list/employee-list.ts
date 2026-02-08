import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [
    CommonModule,   // *ngFor, *ngIf
    FormsModule,    // ngModel
    RouterModule    // routerLink
  ],
  templateUrl: './employee-list.html'
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];
  keyword = '';

  constructor(
    private service: EmployeeService,
    private router: Router
  ) {
    // ✅ Reload employees whenever route activates
    this.router.events.subscribe(() => {
      this.loadEmployees();
    });
  }

  ngOnInit(): void {
    this.loadEmployees(); // still good to keep
  }

  loadEmployees(): void {
    this.service.getAll().subscribe({
      next: data => this.employees = data ?? [],
      error: err => {
        console.error(err);
        this.employees = [];
      }
    });
  }

  search(): void {
    const trimmedKeyword = this.keyword.trim();

    if (!trimmedKeyword) {
      this.loadEmployees();
      return;
    }

    this.service.search(trimmedKeyword).subscribe({
      next: data => this.employees = data ?? [],
      error: () => this.employees = []
    });
  }

  delete(id: number): void {
    if (confirm('Delete employee?')) {
      this.service.delete(id).subscribe(() => {
        this.loadEmployees();
      });
    }
  }
}
