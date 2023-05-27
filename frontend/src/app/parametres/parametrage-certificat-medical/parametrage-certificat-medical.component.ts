import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parametrage-certificat-medical',
  templateUrl: './parametrage-certificat-medical.component.html',
  styleUrls: ['./parametrage-certificat-medical.component.scss']
})
export class ParametrageCertificatMedicalComponent implements OnInit {
  certificats: any[] = [
    { type: 'Arrêt maladie', titre: 'Titre par défaut', paragraphe: 'Paragraphe par défaut' },
       // Ajoutez d'autres types de certificats ici
  ]; 
  showAutocompleteList = false;
  autocompleteList: string[] = ['variable1', 'variable2', 'variable3']; // Liste de variables prédéfinies

  constructor() {}

  ngOnInit() {
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
      const textarea = document.getElementById('paragraphe1') as HTMLTextAreaElement;
      const textareaRect = textarea.getBoundingClientRect();
      const list = document.getElementById('autocomplete-list') as HTMLUListElement;
      list.style.top = `${textareaRect.bottom}px`;
      list.style.left = `${textareaRect.left}px`;
    }
  }
  onTextareaInput(event: any) {
    const cursorPosition = event.target.selectionStart;
    const textareaValue = event.target.value;

    if (textareaValue.charAt(cursorPosition - 1) === '$') {
      this.showAutocompleteList = true;
    } else {
      this.showAutocompleteList = false;
    }
  }

  insertVariable(variable: string) {
    const textarea = document.getElementById('paragraphe') as HTMLTextAreaElement;
    const cursorPosition = textarea.selectionStart;
    const textareaValue = textarea.value;

    const updatedTextareaValue =
      textareaValue.substring(0, cursorPosition - 1) +
      '${'+variable+'}' +
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
