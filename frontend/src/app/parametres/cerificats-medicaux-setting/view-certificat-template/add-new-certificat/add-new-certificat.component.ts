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
  selector: 'app-add-new-certificat',
  templateUrl: './add-new-certificat.component.html',
  styleUrls: ['./add-new-certificat.component.scss']
})
export class AddNewCertificatComponent implements OnInit {

  @Input() certificatType: any; // Remplacez le type "any" par le type de votre objet médicament si possible
  @Output() actionAcomplished = new EventEmitter();
  certificatForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private clientHttp: GenericClientService
  ) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['certificatType'] && this.certificatType) {
      this.certificatForm.patchValue(this.certificatType);
    }
  }

  initializeForm(): void {
    this.certificatForm = this.formBuilder.group({
      id:[null],
      name: ['', Validators.required],
      description: ['', Validators.required],
      dosage: [''],
      contreIndication: [''],
    });

    if (this.certificatType) {
      this.certificatForm.patchValue(this.certificatType);
    }
  }

  onSubmit(): void {
    if (this.certificatForm.invalid) {
      return;
    }

    // Récupérer les valeurs du formulaire et traiter la création du médicament
    const newcertificat = this.certificatForm.value;
    console.log(newcertificat);
    this.clientHttp
      .post('certificat-medical-type/save', newcertificat)
      .subscribe((data) => this.actionAcomplished.emit(true));
    // Ajouter le code pour enregistrer le médicament dans la base de données ou effectuer d'autres actions nécessaires
  }

}
