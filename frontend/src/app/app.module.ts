import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FullCalendarModule } from '@fullcalendar/angular';
import { HomeComponent } from './home/home.component';
import { ExampleComponent } from './calendar/example/example.component';
import { ListPatientsComponent } from './patients/list-patients/list-patients.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ExampleComponent,
    ListPatientsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FullCalendarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
