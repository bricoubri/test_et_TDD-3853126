package com.syllab.boutique.metier.coupons;

/**
 * Définit les fonctionnalités d'un gestionnaire de coupons
 */
public interface IGestionnaireCoupons {

  /**
   * Référence un coupon de réduction.
   * 
   * @param codeCoupon code du coupon
   * @param reduction  réduction représentant le coupon
   * @exception IllegalArgumentException Code de coupon vide.
   * @exception NullPointerException     Coupon ou réduction nulle.
   */
  void referencerCoupon(String codeCoupon, IReduction reduction);

  /**
   * Obtient la réduction associée au coupon.
   * 
   * @param codeCoupon code du coupon à récupérer
   * @return IReduction réduction associée au coupon, null si le coupon est
   *         inconnu.
   */
  IReduction recupererReductionDepuisCodeCoupon(String codeCoupon);
}
