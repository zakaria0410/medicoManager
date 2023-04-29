import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListPatientsComponent } from './patients/list-patients/list-patients.component';
import { ExampleComponent } from './calendar/example/example.component';
import { RdvComponent } from './calendar/rdv/rdv.component';
import { GenerationFactureComponent } from './facturation/generation-facture/generation-facture.component';
import { TabsetComponent } from 'ngx-bootstrap/tabs';
import { TabviewComponent } from './example/tabview/tabview.component';
import { NewPatientComponent } from './patients/new-patient/new-patient.component';
import { FichePatientComponent } from './patients/fiche-patient/fiche-patient.component';
import { TableCalendarComponent } from './calendar/table-calendar/table-calendar.component';
import { HistoriqueConsultationComponent } from './patients/historique-consultation/historique-consultation.component';
import { MadalComponent } from './example/madal/madal.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'patients', children:[{path:'',component:ListPatientsComponent},{path:'new',component:NewPatientComponent}] },
  {path:'agenda',component:RdvComponent},
  {path:'factures',component:TableCalendarComponent},
  {path:'historique-fiches-patient',component:MadalComponent},
  {path:'fiche-patient',component:FichePatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
