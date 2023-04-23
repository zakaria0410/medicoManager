import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListPatientsComponent } from './patients/list-patients/list-patients.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'patients', component: ListPatientsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
