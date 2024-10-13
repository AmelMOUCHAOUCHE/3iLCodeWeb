import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeFComponent } from './front/home-f/home-f.component';
import { PanierFComponent } from './front/panier-f/panier-f.component';
import { CommandeComponent } from './front/commande/commande.component';
import { HomeBComponent } from './back/home-b/home-b.component';
import { AddProductFormComponent } from './back/add-product-form/add-product-form.component';
import { PanierDetailComponent } from './front/panier-detail/panier-detail.component';
import { CheckoutComponent } from './front/checkout/checkout.component';

const routes: Routes = [
    //################# FRONT-OFFICE #################

  { path: '', component: HomeFComponent},
  { path: 'home', component: HomeFComponent},
  { path: 'panier', component: PanierFComponent},
  { path: 'panierDetail', component: PanierDetailComponent},
  { path: 'commande', component: CommandeComponent},
  { path: 'validerPanier', component: CheckoutComponent},



  //################# BACK-OFFICE #################
  {path: 'home-back', component: HomeBComponent},
  { path: 'add-product-form', component: AddProductFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
