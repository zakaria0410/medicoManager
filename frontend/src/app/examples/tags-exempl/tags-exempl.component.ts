import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tags-exempl',
  templateUrl: './tags-exempl.component.html',
  styleUrls: ['./tags-exempl.component.scss']
})
export class TagsExemplComponent implements OnInit {
  ngOnInit(): void {
 //   throw new Error('Method not implemented.');
  }
  nom: string;
  interests: string[] = ['Sport', 'Musique', 'Art', 'Cinéma', 'Voyages'];
  selectedInterest: string;
  selectedInterests: string[] = [];

  addInterest(interest: string): void {
    this.selectedInterests.push(interest);
    this.selectedInterest = '';
  }

  removeInterest(interest: string): void {
    this.selectedInterests = this.selectedInterests.filter(item => item !== interest);
  }

  removeItem(item: string): void {
    this.selectedInterests = this.selectedInterests.filter(interest => interest !== item);
  }

}
