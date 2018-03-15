package ut.ee.pank.var4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestKontod {

  public static void main(String[] args) {

    Konto konto1 = new TavalineKonto("Mari", 1234, 40.0);
    Konto konto2 = new HoiusKonto("Jüri", 3452, 90, 33);
    Konto konto3 = new HoiusKonto("Madis", 2463, 40.0, 365);
    Konto konto4 = new TavalineKonto("Hannes", 1623);

    List<Konto> kontod = new ArrayList<>();

    kontod.add(konto1);
    kontod.add(konto2);
    kontod.add(konto3);
    kontod.add(konto4);

    // Sorteerime kontod
    Collections.sort(kontod);

    prindiKontodeInfo(kontod);
  }

  // Meetod mis prindib välja kõik kontod
  // Vastavalt objekti tüübile kutsutakse välja toString igal objektil
  private static void prindiKontodeInfo(List<Konto> kontod) {
    for (Konto konto : kontod) {
      System.out.println(konto);
    }
  }

}
