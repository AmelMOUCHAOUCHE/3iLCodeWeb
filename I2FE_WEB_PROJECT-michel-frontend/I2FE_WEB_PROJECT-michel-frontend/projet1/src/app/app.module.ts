import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClient, HttpClientModule } from '@angular/common/http';



import { AppComponent } from './app.component';
import { HomeFComponent } from './front/home-f/home-f.component';
import { PanierFComponent } from './front/panier-f/panier-f.component';
import { FooterFComponent } from './front/footer-f/footer-f.component';
import { NavbarFComponent } from './front/navbar-f/navbar-f.component';
import { ProductFComponent } from './front/product-f/product-f.component';
import { ProductDetailsComponent } from './front/product-details/product-details.component';
import { CartComponent } from './front/cart/cart.component';
import { CheckoutComponent } from './front/checkout/checkout.component';
import { UserAccountComponent } from './front/user-account/user-account.component';
import { SearchBarComponent } from './front/search-bar/search-bar.component';
import { DynamiqueImageSearchComponent } from './front/dynamique-image-search/dynamique-image-search.component';
import { AvisClientComponent } from './front/avis-client/avis-client.component';
import { CommandeComponent } from './front/commande/commande.component';
import { HomeBComponent } from './back/home-b/home-b.component';
import { HeaderBComponent } from './back/header-b/header-b.component';
import { NavbarTopComponent } from './back/navbar-top/navbar-top.component';
import { NavbarSideComponent } from './back/navbar-side/navbar-side.component';
import { TableComponent } from './back/table/table.component';
import { AddProductFormComponent } from './back/add-product-form/add-product-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StatusPanierComponent } from './front/status-panier/status-panier.component';
import { PanierDetailComponent } from './front/panier-detail/panier-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeFComponent,
    PanierFComponent,
    FooterFComponent,
    NavbarFComponent,
    ProductFComponent,
    ProductDetailsComponent,
    CartComponent,
    CheckoutComponent,
    UserAccountComponent,
    SearchBarComponent,
    DynamiqueImageSearchComponent,
    AvisClientComponent,
    CommandeComponent,
    HomeBComponent,
    HeaderBComponent,
    NavbarTopComponent,
    NavbarSideComponent,
    TableComponent,
    AddProductFormComponent,
    StatusPanierComponent,
    PanierDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
