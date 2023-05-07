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
import { PrintComponent } from './examples/print/print.component';
import { ParametresComponent } from './parametres/parametres.component';
import { ActesSoinsComponent } from './parametres/actes-soins/actes-soins.component';
import { MedicamentsComponent } from './parametres/medicaments/medicaments.component';
import { BilansComponent } from './parametres/bilans/bilans.component';
import { ParametresVitauxComponent } from './parametres/parametres-vitaux/parametres-vitaux.component';
import { BilanTypeComponent } from './parametres/bilan-type/bilan-type.component';
import { CerificatsMedicauxSettingComponent } from './parametres/cerificats-medicaux-setting/cerificats-medicaux-setting.component';
import { DepensesSettingsComponent } from './parametres/depenses-settings/depenses-settings.component';
import { FacturationComponent } from './facturation/facturation.component';
import { CategorieDepenseComponent } from './parametres/categorie-depense/categorie-depense.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'patients',
    children: [
      { path: '', component: ListPatientsComponent },
      { path: 'new', component: NewPatientComponent },
    ],
  },
  { path: 'agenda', component: RdvComponent },
  { path: 'factures', component: TableCalendarComponent },
  { path: 'historique-fiches-patient', component: MadalComponent },
  { path: 'fiche-patient', component: FichePatientComponent },
  { path: 'print', component: PrintComponent },
  {path:'parametres',component:ParametresComponent},
  {path:'actes-soins',component:ActesSoinsComponent},
  {path:'medicaments',component:MedicamentsComponent},
  {path:'bilans',component:BilansComponent},
  {path:'parametres-vitaux',component:ParametresVitauxComponent},
  {path:'bilan-type',component:BilanTypeComponent},
  {path:'certificat-medical-settings',component:CerificatsMedicauxSettingComponent},
  {path:'depense-settings',component:DepensesSettingsComponent},
  {path:'facturation',component:FacturationComponent},
  {path:'depenses-categories',component:CategorieDepenseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
