import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-new-bilan-type',
  templateUrl: './new-bilan-type.component.html',
  styleUrls: ['./new-bilan-type.component.scss'],
})
export class NewBilanTypeComponent implements OnInit {
  @Output() actionAcomplished = new EventEmitter();
  @Input() object = null;
  bilanType: any = {
    id: null,
    name: '',
    description: '',
    bilans: [],
  };
  filteredBilans: any[] = [];
  selectedBilan;
  constructor(private clientHttp: GenericClientService) {}
  ngOnChanges(changes: SimpleChanges) {
    if (changes['object']) {
      if (changes['object'].currentValue != null)
        this.bilanType = changes['object'].currentValue;
    }
  }

  ngOnInit(): void {}

  searchMedicaments(nom: string): void {
    if (nom === null || nom === '') this.filteredBilans = [];
    else
      this.clientHttp.get(`bilan/name/${nom}`).subscribe(
        (data) => {
          this.filteredBilans = data;
        },
        (error) => {
          console.error('Failed to fetch filtered medicaments:', error);
        }
      );
  }

  selectMedicament(medicament: any): void {
    this.bilanType.bilans.push(medicament);
    this.filteredBilans = [];
    this.selectedBilan = '';
  }

  removeMedicament(index: number): void {
    this.bilanType.bilans.splice(index, 1);
  }

  submitForm(): void {
    // Envoyer les données du formulaire au backend

    this.clientHttp
      .post('bilan-type/save', this.bilanType)
      .subscribe((data) => this.actionAcomplished.emit(true));
    console.log(this.bilanType);
  }
}
