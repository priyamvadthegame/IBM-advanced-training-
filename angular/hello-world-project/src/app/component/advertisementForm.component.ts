import { Component } from '@angular/core';

@Component({
  selector: 'advform',
  templateUrl: './advertisementForm.component.html',
  styleUrls: ['./firstAngularApp.component.css']
})
export class AdvertisementForm {
  namep:string='tv add'
  titlep:string='TV'
  categories:any=['electronics','home-appliances','cosmetics']
  array:any=[]
  content:string;
  
  submit(titles:string,names:string,category:string,description:string,event:Event)
  {     
       event.preventDefault()
       let adv={title:titles,names:names,category:category,description:description}
        this.array.push(adv);
        console.log(this.array)
  }

 
}
