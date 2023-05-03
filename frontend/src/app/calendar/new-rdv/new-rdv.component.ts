import { Component, OnInit } from '@angular/core';
import { Observable, map } from 'rxjs';

@Component({
  selector: 'app-new-rdv',
  templateUrl: './new-rdv.component.html',
  styleUrls: ['./new-rdv.component.scss']
})
export class NewRdvComponent implements OnInit {
  selectedMedicament: string;
  medicaments = [
    'Ibuprofène',
    'Paracétamol',
    'Aspirine',
    'Amoxicilline',
    'Lévothyroxine',
    'Atorvastatine'
  ];

  search = (text$: Observable<string>) =>
    text$.pipe(
      map(term => term === '' ? []
        : this.medicaments.filter(med => med.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

  formatter = (result: string) => result.toUpperCase();
  constructor() { }

  ngOnInit(): void {
  }

}
