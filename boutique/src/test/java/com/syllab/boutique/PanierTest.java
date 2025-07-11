package com.syllab.boutique;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.syllab.boutique.metier.Panier;
import com.syllab.boutique.metier.Produit;

class PanierTest {

  @Test
  void add_product_to_basket() {
    // Arrange
    Produit p1 = new Produit("AT23", "Parpaing", 3);
    Panier panier = new Panier();

    // Act
    panier.ajouter(p1, 2);

    // Assertion
    assertEquals(6, panier.getPrixTotal());
  }
}