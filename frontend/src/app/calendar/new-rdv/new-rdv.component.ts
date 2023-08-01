import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, map } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-rdv',
  templateUrl: './new-rdv.component.html',
  styleUrls: ['./new-rdv.component.scss']
})
export class NewRdvComponent implements OnInit {



  @Input() rdv: any; // Remplacez le type "any" par le type de votre objet rdv si possible
  @Output() actionAccomplished = new EventEmitter();
  @Input() supplement_object
  rdvForm: FormGroup;
  patients: any[]; // Remplacez le type "any" par le type de votre objet patient
  filteredPatient: any[];
  filteredPatients: any[];
selectedPatient
  constructor(
    private formBuilder: FormBuilder,
    private clientHttp: GenericClientService
  ) {}
  selectPatient(patient: any): void {
this.rdvForm.get('patient').setValue(patient)
this.rdvForm.get('patientName').setValue(patient.nom+' '+patient.prenom)
    this.filteredPatients = [];  
  }

  
  ngOnInit(): void {
    this.initializeForm();
    this.getPatients();

    this.rdvForm.get("patientName").valueChanges.subscribe(
      data=>{
     if(data!=''){ 
      console.log("searching patient")
        this.searchPatients(data)}
      else{
      this.filteredPatients=[]
      }})
  }
changeMedcin(event){

  this.rdvForm.get('medcin').setValue(event)
  console.log("reciving medcin ",event,this.rdvForm.value)
}
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['rdv'] && this.rdv) {
      this.initializeForm()
      this.rdvForm.patchValue(this.rdv);
    }
  }

  initializeForm(): void {
    this.rdvForm = this.formBuilder.group({
      id: [null],
      medcin: [null, Validators.required],
      patient: [null, Validators.required],
      date: ['', Validators.required],
      heure: ['', Validators.required],
      statut: [''],
      patientName:[],
      initiationPatient:[],sansRdv:[]
    });

    if (this.rdv) {
      this.rdvForm.patchValue(this.rdv);
    }
  }
  searchPatients(nom: string): void {
    if(nom===null || nom==="")this.filteredPatients=[]
    else  this.clientHttp.post(`patient/search`,{nom:nom}).subscribe(
        (data) => {
          this.filteredPatients = data;
        },
        (error) => {
          console.error('Failed to fetch filtered medicaments:', error);
        }
      );
    }
  getPatients(): void {
    // Appeler l'API pour récupérer la liste des patients
    this.clientHttp.get('patient').subscribe((data) => {
      this.patients = data;
    });
  }

  onSubmit(): void {
    if (this.rdvForm.invalid) {
      return;
    }

    // Récupérer les valeurs du formulaire et traiter la création du rendez-vous (rdv)
    const newRdv = this.rdvForm.value;
    console.log(newRdv);
    this.clientHttp.post('rdv/save', newRdv).subscribe((data) => this.actionAccomplished.emit(true));
    // Ajouter le code pour enregistrer le rendez-vous dans la base de données ou effectuer d'autres actions nécessaires
  }
}
