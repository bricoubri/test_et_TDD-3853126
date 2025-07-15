package com.syllab.boutique.metier.coupons;

/**
 * Définit les fonctionnalités d'une réduction
 */
public interface IReduction {

  /**
   * Calcule le montant de la réduction pour l'ensemble du panier si il est
   * éligible à la réduction
   * 
   * @param prixTotal montant total du panier
   * @return le montant de la réduction, 0 si le panier ne remplit pas les
   *         conditions
   */
  double getMontantPanier(double prixTotal);

  /**
   * Calcule le montant de la réduction pour la ligne du panier si elle est
   * éligible à la réduction
   * 
   * @param referenceProduit référence du produit
   * @param quantite         quantité du produit dans le panier
   * @param prix             prix du produit dans le panier
   * @return le montant de la réduction, 0 si la ligne du panier ne remplit pas
   *         les conditions
   */
  double getMontantLigne(String referenceProduit, double quantite, double prix);
}
