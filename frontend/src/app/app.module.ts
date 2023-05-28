import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';
import { FullCalendarModule } from '@fullcalendar/angular';
import { HomeComponent } from './home/home.component';
import { ExampleComponent } from './calendar/example/example.component';
import { ListPatientsComponent } from './patients/list-patients/list-patients.component';
import { MainMenuComponent } from './navigation/main-menu/main-menu.component';
import { NewPatientComponent } from './patients/new-patient/new-patient.component';
import { RdvComponent } from './calendar/rdv/rdv.component';
import { GenerationFactureComponent } from './facturation/generation-facture/generation-facture.component';
import { TabviewComponent } from './example/tabview/tabview.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FichePatientComponent } from './patients/fiche-patient/fiche-patient.component';
import { TableCalendarComponent } from './calendar/table-calendar/table-calendar.component';
import { HistoriqueConsultationComponent } from './patients/historique-consultation/historique-consultation.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { MadalComponent } from './example/madal/madal.component';
import { NewRdvComponent } from './calendar/new-rdv/new-rdv.component';
import { NewTraitementComponent } from './patients/fiche-patient/new-traitement/new-traitement.component';
import { ShcemaDentaireComponent } from './patients/fiche-patient/shcema-dentaire/shcema-dentaire.component';
import { BilanTypesComponent } from './patients/fiche-patient/bilan-types/bilan-types.component';
import { OrdonnaceComponent } from './fiche-patient/ordonnace/ordonnace.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
import { FactureClientComponent } from './facturation/facture-client/facture-client.component';
import { SalleAttenteComponent } from './salle-attente/salle-attente.component';
import { TempsAttenteMoyenComponent } from './salle-attente/temps-attente-moyen/temps-attente-moyen.component';
import { NgChartsModule } from 'ng2-charts';
import { GroupsComponent } from './securite/groups/groups.component';
import { SecuriteComponent } from './securite/securite.component';
import { GroupSettingsComponent } from './securite/groups/group-settings/group-settings.component';
import { FormComponent } from './utils/form/form.component';
import { InputTextComponent } from './utils/form/input-text/input-text.component';
import { InputNumberComponent } from './utils/form/input-number/input-number.component';
import { SelectStaticComponent } from './utils/form/select-static/select-static.component';
import { SelectApiComponent } from './utils/form/select-api/select-api.component';
import { InputAutocompleteComponent } from './utils/form/input-autocomplete/input-autocomplete.component';
import { InputAutocompleteStaticComponent } from './utils/form/input-autocomplete-static/input-autocomplete-static.component';
import { TextAreaComponent } from './utils/form/text-area/text-area.component';
import { InputDateComponent } from './utils/form/input-date/input-date.component';
import { JsonEntityUploaderComponent } from './json-entity-uploader/json-entity-uploader.component';
import { OrdonanceTypeComponent } from './parametres/ordonance-type/ordonance-type.component';
import { NewOrdonanceTypeComponent } from './parametres/ordonance-type/new-ordonance-type/new-ordonance-type.component';
import { DispositifMedicalComponent } from './parametres/dispositif-medical/dispositif-medical.component';
import { NewDispositifMedicalComponent } from './parametres/dispositif-medical/new-dispositif-medical/new-dispositif-medical.component';
import { MatierePremiereComponent } from './parametres/matiere-premiere/matiere-premiere.component';
import { NewMatierePremiereComponent } from './parametres/matiere-premiere/new-matiere-premiere/new-matiere-premiere.component';
import { TagsExemplComponent } from './examples/tags-exempl/tags-exempl.component';
import { ParametrageCertificatMedicalComponent } from './parametres/parametrage-certificat-medical/parametrage-certificat-medical.component';
import { ViewCertificatTemplateComponent } from './parametres/cerificats-medicaux-setting/view-certificat-template/view-certificat-template.component';
import { AddNewCertificatComponent } from './parametres/cerificats-medicaux-setting/view-certificat-template/add-new-certificat/add-new-certificat.component';
import { CertificatDetailComponent } from './parametres/cerificats-medicaux-setting/certificat-detail/certificat-detail.component';
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
    NewCategorieDepenseComponent,
    FactureClientComponent,
    SalleAttenteComponent,
    TempsAttenteMoyenComponent,
    GroupsComponent,
    SecuriteComponent,
    GroupSettingsComponent,
    FormComponent,
    InputTextComponent,
    InputNumberComponent,
    SelectStaticComponent,
    SelectApiComponent,
    InputAutocompleteComponent,
    InputAutocompleteStaticComponent,
    TextAreaComponent,
    InputDateComponent,
    JsonEntityUploaderComponent,
    OrdonanceTypeComponent,
    NewOrdonanceTypeComponent,
    DispositifMedicalComponent,
    NewDispositifMedicalComponent,
    MatierePremiereComponent,
    NewMatierePremiereComponent,
    TagsExemplComponent,
    ParametrageCertificatMedicalComponent,
    ViewCertificatTemplateComponent,
    AddNewCertificatComponent,
    CertificatDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FullCalendarModule,
    TabsModule,
    NgbModule,
    BsDropdownModule.forRoot(),
    FormsModule,
    NgxPrintModule,
    NgChartsModule,
    HttpClientModule,
    NgbTypeaheadModule,
    TypeaheadModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
