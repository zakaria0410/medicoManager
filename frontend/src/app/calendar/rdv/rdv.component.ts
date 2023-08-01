import { ChangeDetectorRef, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CalendarOptions, DateSelectArg, EventApi, EventClickArg, EventInput } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';
@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.scss'],
  providers:[]
})
export class RdvComponent implements OnInit {

dates=[]

initiateDate(event){
this.dates=event
//this.datesGenerated.emit(event)
}
  isList:boolean=true
rdvs = [];
rdv = {
  patient: null,
  date: null,
  heure: null,
  statut: null,medcin:null
};

calendarObject:any
inputValue: string;
inputValueSubject = new Subject<string>();
isSearch: boolean = false;

constructor(private clientHttp: GenericClientService) {}

initiateRdv() {
  if (this.isSearch) {
    this.isSearch = false;
    Object.keys(this.rdv).forEach((s) => (this.rdv[s] = null));
    console.log(this.rdv);
    this.inputValueSubject.next("");
  } else {
    this.isSearch = true;
  }
}

ngOnInit(): void {
  this.clientHttp.get('rdv').subscribe((data) => (this.rdvs = data));
  this.inputValueSubject.pipe(debounceTime(300)).subscribe((value) =>
    this.clientHttp
      .post('rdv/search', this.rdv)
      .subscribe((data) => (this.rdvs = data))
  );
this.testDistinctDates()}
confirmer(rdv){
this.clientHttp.post('rdv/confirmer',rdv).subscribe(
  data=>{
    this.clientHttp.get('rdv').subscribe(
      res=>this.rdvs=res
    )
  }
)
}
annuler(rdv){
  
  this.clientHttp.post('rdv/annuler',rdv).subscribe(
    data=>{
      this.clientHttp.get('rdv').subscribe(
        res=>this.rdvs=res
      )}
  )
  }

callApi(value: string) {
  this.clientHttp.get('rdv').subscribe((response) => {
    this.rdvs = response;
  });
}
testDistinctDates(){
  this.clientHttp.get('rdv/distinct-date').subscribe(
    data=>this.calendarObject=data
  )
}

}
