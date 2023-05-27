import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-acte-soin',
  templateUrl: './new-acte-soin.component.html',
  styleUrls: ['./new-acte-soin.component.scss']
})
export class NewActeSoinComponent implements OnInit,OnChanges {
@Input() object=null  
  dispositifs= [];
  selectedDispositif: string='';
  selectedMatiere: string='';
  acte={id:null,codification:null,description:null,name:null,dispositifsMedicaux:[],matieres:[],prix_unitaire:null}
  selectedDispositifs  = [];
  matieres=[]
  @Output() actionAcomplished = new EventEmitter();
    searchMatiere(nom: string): void {
    if(nom===null || nom==="")this.dispositifs=[]
    else  this.clientHttp.get(`matiere-premiere/name/${nom}`).subscribe(
        (data) => {
          this.matieres = data;
        },
        (error) => {
          console.error('Failed to fetch filtered medicaments:', error);
        }
      );
    }
  searchDispositif(nom: string): void {
    if(nom===null || nom==="")this.dispositifs=[]
    else  this.clientHttp.get(`dispositif-medical/name/${nom}`).subscribe(
        (data) => {
          this.dispositifs = data;
        },
        (error) => {
          console.error('Failed to fetch filtered medicaments:', error);
        }
      );
    }
  addDispositif(interest:any): void {
    this.acte.dispositifsMedicaux.push(interest);
    this.selectedDispositif = '';
    this.dispositifs=[]
    
  }
  addMatiere(interest:any): void {
    this.acte.matieres.push(interest);
    this.selectedMatiere = '';
    this.matieres=[]
    
  }

  removeDispositif(interest: any): void {
    this.acte.dispositifsMedicaux =  this.acte.dispositifsMedicaux.filter(item => item.name !== interest.name);
  }
  removeMatiere(interest: any): void {
    this.acte.matieres =  this.acte.matieres.filter(item => item.name !== interest.name);
  }

 

  constructor(private clientHttp:GenericClientService) { }
  ngOnChanges(changes: SimpleChanges): void {
   if(changes["object"].currentValue){
  if(this.object!=null)  this.acte=this.object
   }
  }
  saveActe(){
    this.clientHttp.post('acte/save',this.acte).subscribe(
   data=>   this.actionAcomplished.emit(true)
    )
  }

  ngOnInit(): void {
  /*  this.clientHttp.get('dispositif-medical').subscribe(
      data=>this.dispositifs=data
    )*/
  }

}
