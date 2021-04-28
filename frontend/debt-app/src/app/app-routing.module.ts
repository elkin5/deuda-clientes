import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { Nopagefound404Component } from './pages/nopagefound404/nopagefound404.component';
import { PagesComponent } from './pages/pages.component';
import { ProgressComponent } from './pages/progress/progress.component';

const routes: Routes = [
  {
    path: '',
    component: PagesComponent,
    children: [{ path: 'dashboard', component: DashboardComponent },
    { path: 'progress', component: ProgressComponent },
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' }]
  },
  { path: 'login', component: LoginComponent },
  { path: '**', component: Nopagefound404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
