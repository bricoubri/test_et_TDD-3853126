package com.syllab.boutique.metier.coupons;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.syllab.boutique.NommageRoyOsherove;

@DisplayNameGeneration(NommageRoyOsherove.class)
public class GestionnaireCouponsTest {

  private GestionnaireCoupons gestionnaireCoupons;

  @BeforeEach
  void init() {
    this.gestionnaireCoupons = new GestionnaireCoupons();
  }

  @Test
  void initialisation_gestionnaireVide() {
    assertNotNull(this.gestionnaireCoupons);
    assertNull(this.gestionnaireCoupons.recupererReductionDepuisCodeCoupon("RZ"));
  }

  @Test
  void referencer_1Coupon() {
    var rz = new ReducZero();

    this.gestionnaireCoupons.referencerCoupon("RZ", rz);

    assertSame(rz, this.gestionnaireCoupons.recupererReductionDepuisCodeCoupon("RZ"));
  }

  @Test
  void referencer_2Coupons() {
    var rz = new ReducZero();

    this.gestionnaireCoupons.referencerCoupon("R1", rz);
    this.gestionnaireCoupons.referencerCoupon("R2", new ReducZero());

    assertSame(rz, this.gestionnaireCoupons.recupererReductionDepuisCodeCoupon("R1"));
  }

  @Test
  void referencer_couponVide_leveIllegalArgumentException() {
    Executable act = () -> this.gestionnaireCoupons.referencerCoupon("", new ReducZero());

    assertThrows(IllegalArgumentException.class, act);
  }

  @Test
  void referencer_couponNull_leveNullPointerException() {
    Executable act = () -> this.gestionnaireCoupons.referencerCoupon(null, new ReducZero());

    assertThrows(NullPointerException.class, act);
  }

  @Test
  void referencer_reducNull_leveNullPointerException() {
    Executable act = () -> this.gestionnaireCoupons.referencerCoupon("RZ", null);

    assertThrows(NullPointerException.class, act);
  }

  private class ReducZero implements IReduction {

    @Override
    public double getMontantPanier(double prixTotal) {
      return 0;
    }

    @Override
    public double getMontantLigne(String ref, double qte, double prix) {
      return 0;
    }
  }
}
