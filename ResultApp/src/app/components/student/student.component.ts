import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  filteredStudentData: any[];
  roll: number;
  dOB: string;
  Student: any[];
  errorText: string;
  constructor(private api: ApiService) { }

  ngOnInit(): void {
    this.filteredStudentData = []
    this.Student = []
    this.getAllData()
  }

  //GET method
  getAllData() {
    this.api.getAllStudents().subscribe(res => {
      console.log(typeof (res));

      this.filteredStudentData.push(...res)

    })
  }

  SearchData() {
    console.log(this.filteredStudentData)
    this.Student = []
    this.errorText=undefined
    if (this.filteredStudentData.find(data => data.rollno === this.roll && data.dob === this.dOB)) {

      this.Student.push(this.filteredStudentData.find(data => data.rollno === this.roll && data.dob === this.dOB))
      console.log(this.Student)
    }
    else
    {
      this.errorText="Wrong Details !!!!";
      console.log("Wrong Details!!!");
    }
  }
}
