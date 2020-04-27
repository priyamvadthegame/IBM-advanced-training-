import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FirstAngular} from './component/firstAngularApp.component'
import {AdvertisementForm} from './component/advertisementForm.component'
@NgModule({
  declarations: [
    AppComponent,
    FirstAngular,AdvertisementForm
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
