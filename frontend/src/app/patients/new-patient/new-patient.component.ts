import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-patient',
  templateUrl: './new-patient.component.html',
  styleUrls: ['./new-patient.component.scss']
})
export class NewPatientComponent implements OnInit {
  @Input() patient: any; // Remplacez le type "any" par le type de votre objet patient si possible
  @Output() actionAccomplished = new EventEmitter();
  patientForm: FormGroup=this.formBuilder.group({});

  constructor(
    private formBuilder: FormBuilder,
    private clientHttp: GenericClientService
  ) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['patient'] && this.patient) {
      this.patientForm.patchValue(this.patient);
      console.log("changement "+this.patientForm.value)
    }
  }

  initializeForm(): void {
    this.patientForm = this.formBuilder.group({
      id: [null],
      nom: ['', Validators.required],
      prenom: ['', Validators.required],   
      civilite: [''],
      cin: [''],
      sexe: [''],
      dateNaissance: [null],
      nombreEnfants: [''],
      profession: [''],
      mutuelle: [''],
      ncnss:[''],
      nmutuelle:[''],
      groupeSanguin: [''],
      adresse: [''],
      email: ['', Validators.email],
      telephone1: [''],
      telephone2: [''],
    });

    if (this.patient) {
      this.patientForm.patchValue(this.patient);
    }
  }

  onSubmit(): void {


    // Récupérer les valeurs du formulaire et traiter la création du patient
    const newPatient = this.patientForm.value;
    console.log(newPatient);
    this.clientHttp
      .post('patient/save', newPatient)
      .subscribe(data =>{
        console.log(data)
        this.actionAccomplished.emit(true)
      });
    // Ajouter le code pour enregistrer le patient dans la base de données ou effectuer d'autres actions nécessaires
  }

}
