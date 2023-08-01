import { DatePipe } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-calendar-options',
  templateUrl: './calendar-options.component.html',
  styleUrls: ['./calendar-options.component.scss'],
  providers:[DatePipe]
})
export class CalendarOptionsComponent implements OnInit {
  constructor(private datePipe: DatePipe){}
  today: string;
  ngOnInit(): void {
    //   throw new Error('Method not implemented.');

    this.today = this.todayDate();
    this.numberOfDays=7
    this.generateDateArray();

    console.log(this.selectedDate, this.dateArray);

  }
  todayDate(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = this.padZero(today.getMonth() + 1);
    const day = this.padZero(today.getDate());
    return `${year}-${month}-${day}`;
  }
  private padZero(value: number): string {
    return value < 10 ? `0${value}` : `${value}`;
  }

  selectedDate: Date = new Date();
  numberOfDays: number;
  dateArray: Date[] = [];
  @Output() datesGenerated = new EventEmitter();
  generateDateArray() {
   let parsed= this.datePipe.transform(this.today, 'yyyy-MM-dd')
    this.selectedDate=new Date(parsed)

  //  console.log(event?.target.value, typeof event?.target.value);
    this.dateArray = [];

   
      const currentDate = new Date(this.selectedDate);

      // Ajouter la date actuelle
      this.dateArray.push(currentDate);

      // Ajouter les dates précédentes
      for (let i = 1; i <= this.numberOfDays / 2; i++) {
        const previousDate = new Date(currentDate);
        previousDate.setDate(currentDate.getDate() - i);
        this.dateArray.unshift(previousDate);
      }

      // Ajouter les dates suivantes
      for (let i = 1; i <= this.numberOfDays / 2; i++) {
        const nextDate = new Date(currentDate);
        nextDate.setDate(currentDate.getDate() + i);
        this.dateArray.push(nextDate);
      }
    
    this.datesGenerated.emit(this.dateArray);
  }
}
