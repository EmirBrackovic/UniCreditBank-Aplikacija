import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';


export class User{

  constructor(
    public id:number,
    public username:string,
    public firstName:string,
    public lastName:string,
    public password:string
  ){
}
}

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {

  users:User[] | undefined;

  constructor(
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {

    this.getUser();
  }

  getUser(){
    this.httpClient.get<any>('http://localhost:8080/api/v1/user').subscribe(
      response => {
        console.log(response);
        this.users=response;
      }
    );
  }
}