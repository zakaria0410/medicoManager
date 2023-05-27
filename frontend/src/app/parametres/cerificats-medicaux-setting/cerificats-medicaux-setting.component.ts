import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-cerificats-medicaux-setting',
  templateUrl: './cerificats-medicaux-setting.component.html',
  styleUrls: ['./cerificats-medicaux-setting.component.scss'],
})
export class CerificatsMedicauxSettingComponent implements OnInit {
  certificat = { type: null, titre: null, paragraphe: null };

  certificats: any[] = [
    {
      type: 'Arrêt maladie',
      titre: 'Titre par défaut',
      paragraphe: 'Paragraphe par défaut',
    },
    // Ajoutez d'autres types de certificats ici
  ];
  showAutocompleteList = false;
  autocompleteList: string[] = []; // Liste de variables prédéfinies
  transformerEnTexteThymeleaf(): string {
    const regexVariable = /\${(.*?)}/g;
  
    const texteTransforme = this.certificat.paragraphe.replace(regexVariable, (match, variable) => {
      const value = '<span th:text="${'+variable+'}></span>';
      return value;
    });
  
    return texteTransforme;
  }
  constructor(private httpClient:GenericClientService) {}

  ngOnInit() {
    this.httpClient.get('certif/fields/').subscribe(
      data=>this.autocompleteList=data
    )
    //  this.certificats = this.certificatService.getCertificats();
  }

  sauvegarderCertificat(certificat: any) {
    this.certificats.push(certificat);
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
  console.log(event)
    const cursorPosition = event.target.selectionStart;
    const textareaValue = event.target.value;

    if (textareaValue.charAt(cursorPosition - 1) === '$') {
      this.showAutocompleteList = true;
    } else {
      this.showAutocompleteList = false;
    }
  }
  

  insertVariable(variable: string) {
    const textarea = document.getElementById(
      'paragraphe'
    ) as HTMLTextAreaElement;
    const cursorPosition = textarea.selectionStart;
    const textareaValue = textarea.value;

    const updatedTextareaValue =
      textareaValue.substring(0, cursorPosition - 1) +
      '${' +
      variable +
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
