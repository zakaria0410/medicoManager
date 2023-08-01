import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-trial-statistics',
  templateUrl: './home-trial-statistics.component.html',
  styleUrls: ['./home-trial-statistics.component.scss']
})
export class HomeTrialStatisticsComponent implements OnInit {
  ngOnInit(): void {
 //   throw new Error('Method not implemented.');
  }

 // Données pour le premier graphique
 chart1Data: any[] = [
  { data: [65, 59, 80, 81, 56, 55, 40], label: 'Série A' },
  { data: [28, 48, 40, 19, 86, 27, 90], label: 'Série B' }
];
chart1Labels: string[] = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'];
chart1Options: any = {
  responsive: true
};
chart1Legend: boolean = true;
chart1Type: string = 'line';

// Données pour le deuxième graphique
chart2Data: any[] = [
  { data: [10, 20, 30, 40, 50], label: 'Série C' }
];
chart2Labels: string[] = ['Red', 'Blue', 'Yellow', 'Green', 'Purple'];
chart2Options: any = {
  responsive: true
};
chart2Legend: boolean = true;
chart2Type: string = 'bar';

}
