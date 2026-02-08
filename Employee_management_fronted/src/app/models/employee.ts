export interface Employee {
  id?: number;

  employeeCode: string;
  name: string;
  department: string;
  designation: string;
  email: string;
  phoneNumber: string;
  emergencyContact: string;

  salary: number;
  experienceYears: number;

  workLocation: string;
  address: string;

  dateOfBirth?: string;      // LocalDate → string (ISO)
  dateOfJoining?: string;
  lastWorkingDay?: string;

  profileImageUrl?: string;

  gender: string;
  employmentType: string;
  status: string;

  createdAt?: string;        // LocalDateTime → string
  updatedAt?: string;
}

