import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FullCalendarModule } from '@fullcalendar/angular';
import { HomeComponent } from './home/home.component';
import { ExampleComponent } from './calendar/example/example.component';
import { ListPatientsComponent } from './patients/list-patients/list-patients.component';
import { MainMenuComponent } from './navigation/main-menu/main-menu.component';
import { NewPatientComponent } from './patients/new-patient/new-patient.component';
import { RdvComponent } from './calendar/rdv/rdv.component';
import { GenerationFactureComponent } from './facturation/generation-facture/generation-facture.component';
import { TabviewComponent } from './example/tabview/tabview.component';
import {TabsModule} from 'ngx-bootstrap/tabs';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FichePatientComponent } from './patients/fiche-patient/fiche-patient.component';
import { TableCalendarComponent } from './calendar/table-calendar/table-calendar.component';
import { HistoriqueConsultationComponent } from './patients/historique-consultation/historique-consultation.component'
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { MadalComponent } from './example/madal/madal.component';
import { NewRdvComponent } from './calendar/new-rdv/new-rdv.component';
import { NewTraitementComponent } from './patients/fiche-patient/new-traitement/new-traitement.component';
import { ShcemaDentaireComponent } from './patients/fiche-patient/shcema-dentaire/shcema-dentaire.component';
import { BilanTypesComponent } from './patients/fiche-patient/bilan-types/bilan-types.component';
import { OrdonnaceComponent } from './fiche-patient/ordonnace/ordonnace.component';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ExampleComponent,
    ListPatientsComponent,
    MainMenuComponent,
    NewPatientComponent,
    RdvComponent,
    GenerationFactureComponent,
    TabviewComponent,
    FichePatientComponent,
    TableCalendarComponent,
    HistoriqueConsultationComponent,
    MadalComponent,
    NewRdvComponent,
    NewTraitementComponent,
    ShcemaDentaireComponent,
    BilanTypesComponent,
    OrdonnaceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FullCalendarModule,
    TabsModule,
    NgbModule,
    BsDropdownModule.forRoot(),
FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
