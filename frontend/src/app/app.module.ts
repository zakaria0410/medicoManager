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
import { CertificatsComponent } from './fiche-patient/certificats/certificats.component';
import { NewCertificatComponent } from './fiche-patient/certificats/new-certificat/new-certificat.component';
import { NgxPrintModule } from 'ngx-print';
import { PrintComponent } from './examples/print/print.component';
import { EditionCertificatComponent } from './fiche-patient/certificats/edition-certificat/edition-certificat.component';
import { ParametresComponent } from './parametres/parametres.component';
import { ActesSoinsComponent } from './parametres/actes-soins/actes-soins.component';
import { NewActeSoinComponent } from './parametres/actes-soins/new-acte-soin/new-acte-soin.component';
import { MedicamentsComponent } from './parametres/medicaments/medicaments.component';
import { NewMedicamentComponent } from './parametres/medicaments/new-medicament/new-medicament.component';
import { BilansComponent } from './parametres/bilans/bilans.component';
import { NewBilanComponent } from './parametres/bilans/new-bilan/new-bilan.component';
import { ParametresVitauxComponent } from './parametres/parametres-vitaux/parametres-vitaux.component';
import { BreadcrumbComponent } from './shared/breadcrumb/breadcrumb.component';
import { BilanTypeComponent } from './parametres/bilan-type/bilan-type.component';
import { NewBilanTypeComponent } from './parametres/bilan-type/new-bilan-type/new-bilan-type.component';
import { CerificatsMedicauxSettingComponent } from './parametres/cerificats-medicaux-setting/cerificats-medicaux-setting.component';
import { DepensesSettingsComponent } from './parametres/depenses-settings/depenses-settings.component';
import { DepensesComponent } from './facturation/depenses/depenses.component';
import { FacturationComponent } from './facturation/facturation.component';
import { NewDepenseComponent } from './facturation/depenses/new-depense/new-depense.component';
import { CategorieDepenseComponent } from './parametres/categorie-depense/categorie-depense.component';
import { NewCategorieDepenseComponent } from './parametres/categorie-depense/new-categorie-depense/new-categorie-depense.component';
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
    OrdonnaceComponent,
    CertificatsComponent,
    NewCertificatComponent,
    PrintComponent,
    EditionCertificatComponent,
    ParametresComponent,
    ActesSoinsComponent,
    NewActeSoinComponent,
    MedicamentsComponent,
    NewMedicamentComponent,
    BilansComponent,
    NewBilanComponent,
    ParametresVitauxComponent,
    BreadcrumbComponent,
    BilanTypeComponent,
    NewBilanTypeComponent,
    CerificatsMedicauxSettingComponent,
    DepensesSettingsComponent,
    DepensesComponent,
    FacturationComponent,
    NewDepenseComponent,
    CategorieDepenseComponent,
    NewCategorieDepenseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FullCalendarModule,
    TabsModule,
    NgbModule,
    BsDropdownModule.forRoot(),
FormsModule,
NgxPrintModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
