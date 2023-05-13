import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-autocomplete-static',
  templateUrl: './input-autocomplete-static.component.html',
  styleUrls: ['./input-autocomplete-static.component.scss']
})
export class InputAutocompleteStaticComponent implements OnInit {
  ngOnInit(): void {
  //  throw new Error('Method not implemented.');
  }
  @Input() label: string;
  @Input() placeholder: string;
  @Input() values: string[]; // Liste des valeurs pour l'autocomplete
  selectedValue: string;
  filteredValues: string[];

  filterValues(event: any) {
    this.filteredValues = this.values.filter(value =>
      value.toLowerCase().includes(event.target.value.toLowerCase())
    );
  }

  selectValue(value: string) {
    this.selectedValue = value;
    this.filteredValues = [];
  }

}
