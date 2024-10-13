import { Component, OnInit } from '@angular/core';
import { ElementPanier } from 'src/app/model/element-panier';
import { Produit } from 'src/app/model/produit';
import { PanierService } from 'src/app/services/panier.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-product-f',
  templateUrl: './product-f.component.html',
  styleUrls: ['./product-f.component.css']
})
export class ProductFComponent implements OnInit{
  
  //liste des produits
  produits: Produit[] = [];

    //properties for pagination
    currentPage: number = 1;
    pageSize: number = 8;
    totalElements: number = 0;
    searchMode: boolean = false;
  
 constructor(private produitService: ProduitService,
    private panierService: PanierService  

 ){}

 ngOnInit(): void {
   this.listProduits();
 }

 listProduits() {
   this.produitService.getProductList().subscribe(
     data => {
       this.produits = data;
       console.log(data)
     }
   )
 }
 
 ajouterAuPanier(produit: Produit) {
  console.log("ajouter au panier", produit);
  let elementPanier = new ElementPanier(produit); // Remove the argument from the constructor

  this.panierService.addToPanier(elementPanier);
}
 
}
