import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-form',
  standalone: true,
  templateUrl: './employee-form.html',
  imports: [
    CommonModule,   // *ngIf, *ngFor
    FormsModule,    // ngModel  ✅ REQUIRED
    RouterModule    // routerLink
  ]
})
export class EmployeeFormComponent implements OnInit {

  employee: Employee = {} as Employee;
  id?: number;

  constructor(
    private route: ActivatedRoute,
    private service: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {
  this.id = Number(this.route.snapshot.paramMap.get('id'));

  if (this.id) {
    this.service.getById(this.id).subscribe({
      next: (data) => {
        this.employee = {
          ...data,
          dateOfBirth: data.dateOfBirth ? data.dateOfBirth.substring(0, 10) : undefined,
          dateOfJoining: data.dateOfJoining ? data.dateOfJoining.substring(0, 10) : undefined,
          lastWorkingDay: data.lastWorkingDay ? data.lastWorkingDay.substring(0, 10) : undefined
        };
      },
      error: (err) => console.error(err)
    });
  }
}


  save(): void {
    if (this.id) {
      this.service.update(this.id, this.employee).subscribe(() => {
        this.router.navigate(['/']);
      });
    } else {
      this.service.create(this.employee).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }
}






// import { Component, OnInit } from '@angular/core';
// import { FormsModule } from '@angular/forms';
// import { CommonModule } from '@angular/common';
// import { EmployeeService } from '../../services/employee.service';
// import { ActivatedRoute, Router, RouterModule } from '@angular/router';
// import { Employee } from '../../models/employee';

// @Component({
//   selector: 'app-employee-form',
//   standalone: true,                     // 👈 REQUIRED for standalone Angular
//   imports: [CommonModule, FormsModule, RouterModule],// 👈 REQUIRED for ngModel and routerLink
//   templateUrl: './employee-form.html'
// })
// export class EmployeeFormComponent implements OnInit {

//   employee: Employee = {
//     employeeCode: '',
//     name: '',
//     department: '',
//     designation: '',
//     email: '',
//     phoneNumber: '',
//     emergencyContact: '',
//     salary: 0,
//     experienceYears: 0,
//     workLocation: '',
//     address: '',
//     gender: 'MALE',
//     employmentType: 'FULL_TIME',
//     status: 'ACTIVE'
//   };

//   id?: number;

//   constructor(
//     private service: EmployeeService,
//     private route: ActivatedRoute,
//     private router: Router
//   ) {}

//   ngOnInit(): void {
//     this.id = Number(this.route.snapshot.paramMap.get('id'));
//     if (this.id) {
//       this.service.getById(this.id)
//         .subscribe(data => this.employee = data);
//     }
//   }

//   save() {
//     if (this.id) {
//       this.service.update(this.id, this.employee)
//         .subscribe(() => this.router.navigate(['/']));
//     } else {
//       this.service.create(this.employee)
//         .subscribe(() => this.router.navigate(['/']));
//     }
//   }
// }
