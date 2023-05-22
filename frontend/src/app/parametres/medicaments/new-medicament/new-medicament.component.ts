import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-medicament',
  templateUrl: './new-medicament.component.html',
  styleUrls: ['./new-medicament.component.scss'],
})
export class NewMedicamentComponent implements OnInit, OnChanges {
  @Input() medicament: any; // Remplacez le type "any" par le type de votre objet médicament si possible
  @Output() actionAcomplished = new EventEmitter();
  medicamentForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private clientHttp: GenericClientService
  ) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['medicament'] && this.medicament) {
      this.medicamentForm.patchValue(this.medicament);
    }
  }

  initializeForm(): void {
    this.medicamentForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      dosage: [''],
      contreIndication: [''],
    });

    if (this.medicament) {
      this.medicamentForm.patchValue(this.medicament);
    }
  }

  onSubmit(): void {
    if (this.medicamentForm.invalid) {
      return;
    }

    // Récupérer les valeurs du formulaire et traiter la création du médicament
    const newMedicament = this.medicamentForm.value;
    console.log(newMedicament);
    this.clientHttp
      .post('medicament/save', newMedicament)
      .subscribe((data) => this.actionAcomplished.emit(true));
    // Ajouter le code pour enregistrer le médicament dans la base de données ou effectuer d'autres actions nécessaires
  }
}
