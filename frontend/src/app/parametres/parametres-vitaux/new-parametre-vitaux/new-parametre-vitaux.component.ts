import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-parametre-vitaux',
  templateUrl: './new-parametre-vitaux.component.html',
  styleUrls: ['./new-parametre-vitaux.component.scss']
})
export class NewParametreVitauxComponent implements OnInit {

  @Input() parametreVital: any; // Remplacez le type "any" par le type de votre objet paramètre vital si possible
  @Output() actionAcomplished = new EventEmitter();
  parametreVitalForm: FormGroup;
  
  constructor(
    private formBuilder: FormBuilder,
    private clientHttp: GenericClientService
  ) {}
  
  ngOnInit(): void {
    this.initializeForm();
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['parametreVital'] && this.parametreVital) {
      this.parametreVitalForm.patchValue(this.parametreVital);
    }
  }
  
  initializeForm(): void {
    this.parametreVitalForm = this.formBuilder.group({
      id: [null],
      nom: ['', Validators.required],
      description: ['', Validators.required],
      valeurMin: [null, Validators.required],
      valeurMax: [null, Validators.required],
      uniteMesure: ['', Validators.required],
    });
  
    if (this.parametreVital) {
      this.parametreVitalForm.patchValue(this.parametreVital);
    }
  }
  
  onSubmit(): void {
    if (this.parametreVitalForm.invalid) {
      return;
    }
  
    // Récupérer les valeurs du formulaire et traiter la création du paramètre vital
    const newParametreVital = this.parametreVitalForm.value;
    console.log(newParametreVital);
    this.clientHttp
      .post('parametre-vital/save', newParametreVital)
      .subscribe((data) => this.actionAcomplished.emit(true));
    // Ajouter le code pour enregistrer le paramètre vital dans la base de données ou effectuer d'autres actions nécessaires
  }
  

}
