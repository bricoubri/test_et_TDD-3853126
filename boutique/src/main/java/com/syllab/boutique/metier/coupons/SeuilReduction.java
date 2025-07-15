package com.syllab.boutique.metier.coupons;

/**
 * Représente une réduction de type N € de réduction pour un minimum d'achat
 */
public class SeuilReduction implements IReduction {

  double seuilReduction;
  double montantReduction;

  /**
   * Initialise une réduction d'un certain montant pour un seuil minimum d'achat
   * 
   * @param seuilReduction   seuil d'acgat à partir duquel la réduction est
   *                         appliquée
   * @param montantReduction montant de la réduction accordée
   */
  public SeuilReduction(double seuilReduction, double montantReduction) {
    this.seuilReduction = seuilReduction;
    this.montantReduction = montantReduction;
  }

  @Override
  public double getMontantPanier(double prixTotal) {
    return prixTotal >= this.seuilReduction ? this.montantReduction : 0;
  }

  @Override
  public double getMontantLigne(String referenceProduit, double quantite, double prix) {
    return 0;
  }
}
