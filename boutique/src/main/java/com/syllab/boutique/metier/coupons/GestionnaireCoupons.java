package com.syllab.boutique.metier.coupons;

import java.util.HashMap;
import java.util.Map;

/**
 * Implémentation d'un gestionnaire de coupons
 */
public class GestionnaireCoupons implements IGestionnaireCoupons {

  Map<String, IReduction> coupons;

  /**
   * Initialise le gestionnaire de coupons
   */
  public GestionnaireCoupons() {
    this.coupons = new HashMap<>();
  }

  @Override
  public void referencerCoupon(String codeCoupon, IReduction reduction) {
    if (codeCoupon.isEmpty()) {
      throw new IllegalArgumentException();
    }
    if (reduction == null) {
      throw new NullPointerException();
    }

    this.coupons.put(codeCoupon, reduction);
  }

  @Override
  public IReduction recupererReductionDepuisCodeCoupon(String codeCoupon) {
    if (this.coupons.containsKey(codeCoupon)) {
      return this.coupons.get(codeCoupon);
    }

    return null;
  }

}
