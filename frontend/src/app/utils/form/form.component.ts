import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  myForm!: FormGroup

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      inputValue: '',
      textareaValue: '',
      autocompleteValue: '',
      dateValue: '',
      inputNumberValue: ''
    });

    this.subscribeToValueChanges();
  }

  subscribeToValueChanges() {
    this.myForm.valueChanges.subscribe(values => {
      console.log('Form values:', values);
    });
  }
}
