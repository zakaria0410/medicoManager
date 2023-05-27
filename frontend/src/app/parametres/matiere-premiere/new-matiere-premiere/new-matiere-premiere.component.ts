import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-matiere-premiere',
  templateUrl: './new-matiere-premiere.component.html',
  styleUrls: ['./new-matiere-premiere.component.scss']
})
export class NewMatierePremiereComponent implements OnInit {

  bilanForm: FormGroup;
  @Output() actionAcomplished=new EventEmitter
  @Input() bilan: any;
  initializeForm(): void {
    this.bilanForm = this.formBuilder.group({
    id:[null],
      name: ['', Validators.required],
      unite_mesure: ['', Validators.required],
      prix_achat: ['', Validators.required],
      description: ['', Validators.required],
    });
  
    if (this.bilan) {
      this.bilanForm.patchValue(this.bilan);
    }
  }
  constructor(private formBuilder: FormBuilder,private clientGttp:GenericClientService) { }
  ngOnChanges(changes: SimpleChanges): void {
    if (changes["bilan"].currentValue && this.bilan) {
      console.log(this.bilan)
      this.initializeForm()
      console.log(this.bilanForm.value,"foooooooooorm")
    }
  }
    ngOnInit(): void {
      this.initializeForm()
    }
  
    onSubmit(): void {
      if (this.bilanForm.invalid) {
        return;
      }
  
      // Récupérer les valeurs du formulaire et traiter la création du bilan
      const newBilan = this.bilanForm.value;
      console.log(newBilan);
      this.clientGttp.post('matiere-premiere/save',newBilan).subscribe(
        data=>this.actionAcomplished.emit(true)
      )
      // Ajouter le code pour enregistrer le bilan dans la base de données ou effectuer d'autres actions nécessaires
    }
}
