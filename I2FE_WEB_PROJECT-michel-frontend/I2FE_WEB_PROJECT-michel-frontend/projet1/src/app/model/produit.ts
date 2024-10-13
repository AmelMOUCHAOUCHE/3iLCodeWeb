export class Produit {
    constructor(
        public id: number,
        public nom: string,
        public description: string,
        public quantite: number,
        public prix : number,
        public image: string){}
}
