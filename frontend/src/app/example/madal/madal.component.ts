import { Component, Input, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-madal',

  templateUrl: './madal.component.html',
  styleUrls: ['./madal.component.scss']
})
export class MadalComponent implements OnInit {
	closeResult = '';
	@Input() title
	@Input() component
	@Input() icon
	@Input() modalStyle
	constructor(private modalService: NgbModal) {}
	ngOnInit(): void {
		//throw new Error('Method not implemented.');
	}

	open(content) {
		this.modalService.open(content,Object.assign( {ariaLabelledBy: 'modal-basic-title' },this.modalStyle)).result.then(
			(result) => {
				this.closeResult = `Closed with: ${result}`;
			},
			(reason) => {
				this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
			},
		);
	}

	private getDismissReason(reason: any): string {
		if (reason === ModalDismissReasons.ESC) {
			return 'by pressing ESC';
		} else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
			return 'by clicking on a backdrop';
		} else {
			return `with: ${reason}`;
		}
	}
}
