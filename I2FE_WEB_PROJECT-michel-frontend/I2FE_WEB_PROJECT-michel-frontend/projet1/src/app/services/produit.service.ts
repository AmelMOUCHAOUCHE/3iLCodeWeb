import { Injectable } from '@angular/core';
import { Produit } from '../model/produit';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProduitService {
private url = "http://localhost:8089/e_commerce/produit";

constructor(private httpClient: HttpClient) { }

getProductList(): Observable <Produit[]>{
  return this.httpClient.get<Produit[]>(`${this.url}`);
}

getProductListe(): Observable <Produit[]>{
  return this.httpClient.get<GetResponse>(`${this.url}`).pipe(
    map(response => response._embedded.produits)
  );
}

/*getProductList(): Observable <Produit[]>{
  return this.httpClient.get<Produit[]>(`${this.url}`);
}

getProduct(id : number): Observable <Produit>{
  return this.httpClient.get<Produit>(`${this.url}/get/${id}`);
}
searchProduct(keyword : string): Observable <Produit[]>{
  return this.httpClient.get<Produit[]>(`${this.url}/search/${keyword}`);
}

deleteProduit(id : number) {
  return this.httpClient.delete(this.url+"/delete/" + id);
}

addProduit(produit : Produit) {
  return this.httpClient.post(this.url+"/add",produit);
}


getProductListPagination(currentPage: number,pageSize: number) : Observable<any>{
  return this.httpClient.get(`${this.url}?page=${currentPage}&size=${pageSize}`);
}*/
}

interface GetResponse {
_embedded: {
  produits: Produit[]
}

}

