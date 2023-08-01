import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-primeng-dropdown',
  templateUrl: './primeng-dropdown.component.html',
  styleUrls: ['./primeng-dropdown.component.scss'],
})
export class PrimengDropdownComponent implements OnInit, OnChanges {
  list: any[];
  selected: any;
  @Input() url;
  @Output() changed = new EventEmitter();
  getList() {
    this.genericClientHttp.get(this.url).subscribe((data) => {
      this.list = data;
      if (data.length > 0) {
        this.selected = data[0];
        this.changed.emit(this.selected);
      }
    });
  }
  ngOnInit() {}
  constructor(private genericClientHttp: GenericClientService) {}
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['url'].currentValue) {
      this.getList();
    }
  }
  log(event) {
    console.log(event.target.value);
  }
}
