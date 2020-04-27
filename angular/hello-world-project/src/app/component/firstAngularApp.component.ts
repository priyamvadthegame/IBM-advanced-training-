import { Component } from '@angular/core';

@Component({
  selector: 'firstAngularApp',
  templateUrl: './firstAngularApp.component.html',
  styleUrls: ['./firstAngularApp.component.css']
})
export class FirstAngular {
  title = 'firstAngularApp-project';
  content:string;
  changeText(value:string)
  {
        this.content=value
  }
}
