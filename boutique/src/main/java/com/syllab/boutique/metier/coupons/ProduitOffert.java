package com.syllab.boutique.metier.coupons;

/**
 * Représente une réduction du type 1 offert pour N acheté(s)
 */
public class ProduitOffert implements IReduction {

  String referenceProduit;
  double seuilQuantite;

  /**
   * Initialise la réduction
   * 
   * @param referenceProduit référence du produit concerné par la réduction
   * @param seuilQuantite    quantité de produits commandés à partir duquel un
   *                         produit est offert
   */
  public ProduitOffert(String referenceProduit, double seuilQuantite) {
    if (referenceProduit.isEmpty()) {
      throw new IllegalArgumentException("La référence ne peut pas être vide");
    }
    if (seuilQuantite <= 0) {
      throw new IllegalArgumentException("La quantité doit être supérieure à 0");
    }

    this.referenceProduit = referenceProduit;
    this.seuilQuantite = seuilQuantite;
  }

  @Override
  public double getMontantPanier(double prixTotal) {
    return 0;
  }

  @Override
  public double getMontantLigne(String referenceProduit, double quantite, double prix) {
    return this.referenceProduit.equals(referenceProduit) ? (Math.floor(quantite / this.seuilQuantite)) * prix : 0;
  }
}
