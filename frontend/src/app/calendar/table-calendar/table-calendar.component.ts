import { DatePipe } from '@angular/common';
import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-table-calendar',
  templateUrl: './table-calendar.component.html',
  styleUrls: ['./table-calendar.component.scss'],
  providers: [DatePipe],
})
export class TableCalendarComponent implements OnInit, OnChanges {
  today = true;
  @Input() dateArray: Date[] = [];
  calendarObject;
  timeList: string[] = [];

  constructor(
    private datePipe: DatePipe,
    private clientHttp: GenericClientService
  ) {}
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['dateArray']) {
      console.log('date arrrrayyy changed ', changes['dateArray']);
      //this.dateArray=Object.keys(this.calendarObject).map(e=>new Date(Date.parse(e)))
    }

  }
  formatTime(hours: number, minutes: number): string {
    const hourString = hours.toString().padStart(2, '0');
    const minuteString = minutes.toString().padStart(2, '0');
    return `${hourString}:${minuteString}`;
  }
  private padZero(value: number): string {
    return value < 10 ? `0${value}` : `${value}`;
  }

  todayDate(today:Date): string {
  
    const year = today.getFullYear();
    const month = this.padZero(today.getMonth() + 1);
    const day = this.padZero(today.getDate());
    return `${year}-${month}-${day}`;
  }
  testDistinctDates(){
    this.clientHttp.get('rdv/distinct-date').subscribe(
      data=>{
        
        this.calendarObject=data
      console.log(this.calendarObject)}
    )
  }
  confirmer(rdv) {
    this.clientHttp.post('rdv/confirmer', rdv).subscribe((data) => {
      console.log('okkk');
    });
  }
  annuler(rdv) {
    this.clientHttp.post('rdv/annuler', rdv).subscribe((data) => {
      console.log('okkk');
    });
  }
  isHourPresent(date: any, time: any): any {
    if(this.calendarObject){
      if (this.calendarObject[this.datePipe.transform(date, 'yyyy-MM-dd')]) {
        if (
          this.calendarObject[this.datePipe.transform(date, 'yyyy-MM-dd')][time]
        )
          return this.calendarObject[this.datePipe.transform(date, 'yyyy-MM-dd')][
            time
          ];
        else return null;
      } else return null;
    
    }
  else return null}
  ngOnInit(): void {
    this.testDistinctDates()
    const startTime = new Date();
    startTime.setHours(8, 0, 0); // Définir l'heure de début à 04:00

    const endTime = new Date();
    endTime.setHours(20, 0, 0); // Définir l'heure de fin à 20:00

    const currentTime = new Date(startTime);

    while (currentTime <= endTime) {
      const formattedTime = this.formatTime(
        currentTime.getHours(),
        currentTime.getMinutes()
      );
      this.timeList.push(formattedTime);

      currentTime.setMinutes(currentTime.getMinutes() + 30); // Ajouter 30 minutes à l'heure actuelle
    }
   /* const today = new Date(); // Obtenir la date d'aujourd'hui

    // Ajouter les dates des trois jours précédents
    for (let i = 3; i > 0; i--) {
      const prevDate = new Date();
      prevDate.setDate(today.getDate() - i);
      this.dateArray.push(prevDate);
    }

    // Ajouter la date d'aujourd'hui
    this.dateArray.push(today);

    // Ajouter les dates des trois jours suivants
    for (let i = 1; i <= 3; i++) {
      const nextDate = new Date();
      nextDate.setDate(today.getDate() + i);
      this.dateArray.push(nextDate);
    }
*/
    // Trier le tableau par ordre croissant
    this.dateArray.sort((a, b) => a.getTime() - b.getTime());
  
  }
}
