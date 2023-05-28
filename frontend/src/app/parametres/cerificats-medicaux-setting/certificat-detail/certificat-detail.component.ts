import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-certificat-detail',
  templateUrl: './certificat-detail.component.html',
  styleUrls: ['./certificat-detail.component.scss'],
})
export class CertificatDetailComponent implements OnInit, OnChanges {
  @Input() certificat = { id: null, name: null, title: null, paragraphe: null };
  variables = [];
  certifMock
  callApi(value: string) {
    // Utilisez HttpClient pour effectuer votre appel API avec la valeur fournie
    this.clientHttp
      .get('certificat-medical-type/name/' + value)
      .subscribe((response) => {
        this.certificats = response;
      });
  }
  certificats: any[] = [
    // Ajoutez d'autres types de certificats ici
  ];
  showAutocompleteList = false;
  autocompleteList: any[] = []; // Liste de variables prédéfinies
  transformerEnTexteThymeleaf(): string {
    const regexVariable = /\${(.*?)}/g;

    const texteTransforme = this.certificat.paragraphe.replace(
      regexVariable,
      (match, variable) => {
        const value = '<span th:text="${' + variable + '}></span>';
        return value;
      }
    );

    return texteTransforme;
  }
  constructor(private clientHttp: GenericClientService) {}
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['certificat'].currentValue) {
      this.clientHttp
        .get('certificat-medical-type/variables/' + this.certificat.id)
        .subscribe((data) => (this.certifMock = data));
    }
  }

  ngOnInit(): void {
    this.clientHttp
      .get('certificat-variable')
      .subscribe((data) => (this.autocompleteList = data));
    this.clientHttp
      .get('certificat-medical-type/variables/' + this.certificat.id)
      .subscribe((data) => {
        this.variables = data
        console.log(data)
      });
  }
  sauvegarderCertificat(certificat: any) {
    this.clientHttp
      .post('certificat-medical-type/save', certificat)
      .subscribe((data) => (this.certificat = data));
  }
  onTextareaKeyup(text) {
    const lastWordStartIndex = text.target.value.lastIndexOf('$') + 1;
    const lastWord = text.target.value.substring(lastWordStartIndex);
    this.showAutocompleteList = lastWord.startsWith('$');

    if (this.showAutocompleteList) {
      const textarea = document.getElementById(
        'paragraphe1'
      ) as HTMLTextAreaElement;
      const textareaRect = textarea.getBoundingClientRect();
      const list = document.getElementById(
        'autocomplete-list'
      ) as HTMLUListElement;
      list.style.top = `${textareaRect.bottom}px`;
      list.style.left = `${textareaRect.left}px`;
    }
  }
  onTextareaInput(event: any) {
    console.log(event);
    const cursorPosition = event.target.selectionStart;
    const textareaValue = event.target.value;

    if (textareaValue.charAt(cursorPosition - 1) === '$') {
      this.showAutocompleteList = true;
    } else {
      this.showAutocompleteList = false;
    }
  }

  insertVariable(variable: any) {
    const textarea = document.getElementById(
      'paragraphe'
    ) as HTMLTextAreaElement;
    const cursorPosition = textarea.selectionStart;
    const textareaValue = textarea.value;

    const updatedTextareaValue =
      textareaValue.substring(0, cursorPosition - 1) +
      '${' +
      variable.name +
      '}' +
      textareaValue.substring(cursorPosition);

    textarea.value = updatedTextareaValue;
    this.certificats.forEach((certificat) => {
      if (certificat.paragraphe === textareaValue) {
        certificat.paragraphe = updatedTextareaValue;
      }
    });

    this.showAutocompleteList = false;
  }
}
