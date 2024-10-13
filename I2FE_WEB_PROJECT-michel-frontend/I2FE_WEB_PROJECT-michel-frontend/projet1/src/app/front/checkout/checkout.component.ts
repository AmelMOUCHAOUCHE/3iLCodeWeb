import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  validerPanierFormGroup: FormGroup;
  prixTotal: number = 0;
  quantiteTotal: number = 0;

  constructor(private formBuilder: FormBuilder){}


  ngOnInit(): void {
    
    //ici dans les formcontrol tu dois penser a revenir mettre les infos de l'utilisateur connecté

    this.validerPanierFormGroup = this.formBuilder.group({
      //client
      client: this.formBuilder.group({
        nom: new FormControl("lechelmi", [Validators.required, Validators.minLength(3)]),
        prenom: new FormControl("dubois", [Validators.required, Validators.minLength(3)]),
        email: new FormControl("dubois@gmail.fr",
          [Validators.required,
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]),
        adresse: new FormControl('', [Validators.required, Validators.minLength(4)]),
      }),
      
    });
  }


   //getter pour le client
   get nom() { return this.validerPanierFormGroup.get('client').get('nom'); }
   get prenom() { return this.validerPanierFormGroup.get('client').get('prenom'); }
   get email() { return this.validerPanierFormGroup.get('client').get('email'); }
   get adresse() { return this.validerPanierFormGroup.get('client').get('adresse'); }
 


    //methode pour valider le panier
    onSubmit() {
      console.log("valider le panier");
      console.log(this.validerPanierFormGroup.value);

     if (this.validerPanierFormGroup.invalid) {
        this.validerPanierFormGroup.markAllAsTouched();
        return;
      }
  
      //on doit creer la commande
    /*   let commande = new Commande();
      commande.prixTotal = this.prixTotal;
      commande.quantiteTotale = this.quantiteTotal;
  
      //on doit créer l'element du panier
      const allPanierElements = this.panierService.elementPaniers;
      //on doit creer le commandElement de lelement du panier
      let commandElements  : CommandeElement[] = allPanierElements.map(elementPan => new CommandeElement(elementPan));
      
      // let commandElements: CommandeElement[] = [];
      // for (let i = 0; i < allPanierElements.length; i++) {
      //   commandElements[i] = new CommandeElement(allPanierElements[i]);
      // }
      
      //on doit creer l'achat
      let achat = new Achat();
  
      //on doit creer remplir l'achat avec le client
      achat.utilisateur = this.validerPanierFormGroup.controls['client'].value;
    
      //on doit creer remplir l'achat avec le commandElement
      achat.commande = commande;
      achat.commandeElements = commandElements;
  
      // on doit creer le paymentInfo
      this.paymentInfo.amount = Math.round( this.prixTotal * 100);
      this.paymentInfo.currency = "USD";
      this.paymentInfo.receiptEmail = achat.utilisateur.email;
  
      //si le formulaire est valide on doit passer la commande
      // on créer lordre de payement
      // on confirm le payement
      //- on passe la commande
  
      if(!this.validerPanierFormGroup.invalid )
        {
        this.achatService.createPaymentIntent(this.paymentInfo).subscribe(
          (PayementIntentResponse) => {
            this.stripe.confirmCardPayment(PayementIntentResponse.client_secret,
              {
                
                payment_method: {
                  card: this.cardElement,
                  billing_details: {
                    name: this.validerPanierFormGroup.controls['client'].value.nom + " " + this.validerPanierFormGroup.controls['client'].value.prenom,
                    email: this.validerPanierFormGroup.controls['client'].value.email,
                    address: {
                      line1: this.validerPanierFormGroup.controls['client'].value.adresse,
                      city: 'Tunis',
                      state: 'TN',
                      country: 'TN',
                      postal_code: '99351'
                    }
                  }
                  
                }
              }, { handleActions: false })
              .then((result : any) => {
                if (result.error) {
                  // Show error to your customer (e.g., insufficient funds)
                  //alert(`Il y a une erreur dans le payement : ${result.error.message}`);
                  Swal.fire('Erreur', `Il y a une erreur dans le payement : ${result.error.message}`, 'error');
                } else{
                  // The payment has been processed!
                  if (result.paymentIntent.status === 'succeeded') {
                    // Show a success message to your customer
                  //  alert('Félicitation, votre payement a été effectué avec succès');
                    // Swal.fire('Félicitation', 'Votre payement a été effectué avec succès', 'success');
                    //on passe la commande
                    // this.achatService.passerCommande(achat).subscribe({
                      // next: (response : any) => {
                       // alert(`Votre commande a été passée avec succès \n Numéro de commande : ${response.numeroSuiviCommande}`);
                        // Swal.fire('Félicitation', `Votre commande a été passée avec succès \n Numéro de commande : ${response.numeroSuiviCommande}`, 'success');
                        //on vide le panier
                        // this.viderPanier();
                     // },
                      error: (err : any) => {
                        // alert(`Il y a une erreur dans la passation de la commande : ${err}`);
                        Swal.fire('Erreur', `Il y a une erreur dans la passation de la commande : ${err}`, 'error');
                      }
                    }                    
                    );
                  } else{
                    this.validerPanierFormGroup.markAllAsTouched();
                    return;
                  }
                }
              });
          }
        );
      } */
    }

}
