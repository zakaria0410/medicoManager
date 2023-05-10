import { Component, OnInit } from '@angular/core';
import { Chart, ChartConfiguration, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-temps-attente-moyen',
  templateUrl: './temps-attente-moyen.component.html',
  styleUrls: ['./temps-attente-moyen.component.scss']
})
export class TempsAttenteMoyenComponent implements OnInit {
  title = 'ng2-charts-demo';
  public doughnutChartDatasets: ChartConfiguration<'doughnut'>['data']['datasets'] = [
    { data: [ 350, 450, 100 ], label: 'Series A' },

  ];

public doughnutChartOptions: ChartConfiguration<'doughnut'>['options'] = {
  responsive: false
};
public doughnutChartLabels: string[] = [ 'Moins de 15 mins', 'Entre 15 Mins et 1h', 'Dépassant une heure D\'attente' ];
  public lineChartData: ChartConfiguration<'line'>['data'] = {
    labels: [
      'January',
      'February',
      'March',
      'April',
      'May',
      'June',
      'July'
    ],
    datasets: [
      {
        data: [ 65, 59, 80, 81, 56, 55, 40 ],
        label: 'Series A',
        fill: true,
        tension: 0.5,
        borderColor: 'black',
        backgroundColor: 'rgba(255,0,0,0.3)'
      }
    ]
  };
  public lineChartOptions: ChartOptions<'line'> = {
    responsive: false
  };
  public lineChartLegend = true;

  constructor() {
  }

  ngOnInit() {
  }
  
}