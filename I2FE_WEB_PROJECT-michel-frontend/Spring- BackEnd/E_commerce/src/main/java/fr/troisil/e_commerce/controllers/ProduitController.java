package fr.troisil.e_commerce.controllers;

import fr.troisil.e_commerce.entity.Produit;
import fr.troisil.e_commerce.services.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

    private final IProduitService produitService;

   @GetMapping("")
    List<Produit> getAll() {
        return produitService.getAll();
    }


   /* @GetMapping("")
    public Page<Produit> getAll(Pageable pageable) {
        return produitService.getAllPaggination(pageable);
    }*/

    @PostMapping("/add")
    Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }

    @PutMapping("/update")
    Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    @DeleteMapping("/delete/{numProd}")
    void delete(@PathVariable Long numProd) {
        produitService.delete(numProd);
    }

    @GetMapping("/get/{numProd}")
    Produit getById(@PathVariable Long numProd) {
        return produitService.getById(numProd);
    }

    @GetMapping("/search/{keyord1}")
    Page<Produit> searchProduit(@PathVariable String keyord1) {
        return produitService.findByNomAndDescription(keyord1, null);
    }


}
