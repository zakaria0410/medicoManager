import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-date',
  templateUrl: './input-date.component.html',
  styleUrls: ['./input-date.component.scss']
})
export class InputDateComponent implements OnInit {
  @Input() label: string;
  @Input() value: any;
  @Input() placeholder: string;
  constructor() { }

  ngOnInit(): void {
  }

}
