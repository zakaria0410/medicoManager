import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-ordonance-type',
  templateUrl: './new-ordonance-type.component.html',
  styleUrls: ['./new-ordonance-type.component.scss']
})
export class NewOrdonanceTypeComponent implements OnInit,OnChanges {
  @Output() actionAcomplished=new EventEmitter
  @Input() object=null
  ordonanceType: any = {
  id:null,
    name: '',
    description: '',
    medicaments: []
  };
  filteredMedicaments: any[] = [];
  selectedMedicament
  constructor(private clientHttp: GenericClientService) { }
  ngOnChanges(changes: SimpleChanges) {
    if (changes["object"]) {
  if(changes["object"].currentValue!=null)    this.ordonanceType = changes["object"].currentValue;
    }

  }

  ngOnInit(): void {
  }

  searchMedicaments(nom: string): void {
  if(nom===null || nom==="")this.filteredMedicaments=[]
  else  this.clientHttp.get(`medicament/name/${nom}`).subscribe(
      (data) => {
        this.filteredMedicaments = data;
      },
      (error) => {
        console.error('Failed to fetch filtered medicaments:', error);
      }
    );
  }

  selectMedicament(medicament: any): void {
    this.ordonanceType.medicaments.push(medicament);
    this.filteredMedicaments = [];
    this.selectedMedicament=""
  }

  removeMedicament(index: number): void {
    this.ordonanceType.medicaments.splice(index, 1);
  }

  submitForm(): void {
    // Envoyer les données du formulaire au backend

this.clientHttp.post('ordonance-type/save',this.ordonanceType).subscribe(
  data=>this.actionAcomplished.emit(true)
)
    console.log(this.ordonanceType);
  }

}
