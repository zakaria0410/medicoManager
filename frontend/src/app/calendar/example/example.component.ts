import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CalendarOptions, DateSelectArg, EventApi, EventClickArg, EventInput } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.scss']
})
export class ExampleComponent implements OnInit {

  eventGuid = 0;
  TODAY_STR = new Date().toISOString().replace(/T.*$/, '');
 INITIAL_EVENTS: EventInput[] = [
   {
     id: this.createEventId(),
     title: 'All-day event',
     start: this.TODAY_STR
   },
   {
     id: this.createEventId(),
     title: 'Timed event',
     start: this.TODAY_STR + 'T00:00:00',
     end: this.TODAY_STR + 'T03:00:00'
   },
   {
     id: this.createEventId(),
     title: 'Timed event',
     start: this.TODAY_STR + 'T12:00:00',
     end: this.TODAY_STR + 'T15:00:00'
   }
 ];
 
  createEventId() {
   return String(this.eventGuid++);
 }

 calendarOptions: CalendarOptions = {
   plugins: [
 
     dayGridPlugin,
     interactionPlugin
   ],
   headerToolbar: {
     left: 'prev,next today',
     center: 'title',
     right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
   },
   initialView: 'dayGridMonth',
   initialEvents: this.INITIAL_EVENTS, // alternatively, use the `events` setting to fetch from a feed
   weekends: true,
   editable: true,
   selectable: true,
   selectMirror: true,
   dayMaxEvents: true,
   select: this.handleDateSelect.bind(this),
   eventClick: this.handleEventClick.bind(this),
   eventsSet: this.handleEvents.bind(this)
   /* you can update a remote database when these fire:
   eventAdd:
   eventChange:
   eventRemove:
   */
 };
 calendarVisible: boolean=true;
 currentEvents: EventApi[]=[];

 handleCalendarToggle() {
   this.calendarVisible = !this.calendarVisible;
 }

 handleWeekendsToggle() {
   const { calendarOptions } = this;
   calendarOptions.weekends = !calendarOptions.weekends;
 }
 constructor(private changeDetector: ChangeDetectorRef) {
 }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
 handleDateSelect(selectInfo: DateSelectArg) {
   const title = prompt('Please enter a new title for your event');
   const calendarApi = selectInfo.view.calendar;

   calendarApi.unselect(); // clear date selection

   if (title) {
     calendarApi.addEvent({
       id: '65665666',
       title,
       start: selectInfo.startStr,
       end: selectInfo.endStr,
       allDay: selectInfo.allDay
     });
   }
 }

 handleEventClick(clickInfo: EventClickArg) {
   if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
     clickInfo.event.remove();
   }
 }

 handleEvents(events: EventApi[]) {
   this.currentEvents = events;
   this.changeDetector.detectChanges();
 }

}
