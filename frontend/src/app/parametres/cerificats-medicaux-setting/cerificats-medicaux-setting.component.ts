import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-cerificats-medicaux-setting',
  templateUrl: './cerificats-medicaux-setting.component.html',
  styleUrls: ['./cerificats-medicaux-setting.component.scss'],
})
export class CerificatsMedicauxSettingComponent implements OnInit {

  constructor(private httpClient:GenericClientService) {}
certificats=[]
selectedCertificat=null
delete(id){
  this.httpClient.delete(id,'certificat-medical-type').subscribe(
    data=>{
      this.fetchCertificatsType()      
    }
  )
}
fetchCertificatsType(){
  
  this.httpClient.get('certificat-medical-type').subscribe(
    data=>{this.certificats=data.map(c=>{return Object.assign(c,{active:false})})
  this.selectedCertificat=this.certificats[0]
this.selectedCertificat.active=true}
  )
}
  ngOnInit() {
 
   this.fetchCertificatsType() 
    //  this.certificats = this.certificatService.getCertificats();
  }
  selectCertificat(i,object){
this.certificats.forEach(e=>e.active=false)
this.certificats[i].active=true
this.selectedCertificat=object
 }
}
