package ut.ee.pank.var4;

import java.util.ArrayList;

/*
Loome panga kasutades listi kontode hoidmiseks. Kuna listi suurusel limiiti määrma ei pea
saame siia panka salvestada
 */
public class LimiiditaPank implements Pank {

  private static int koguKontodeArv;

  private String nimi;
  private ArrayList<Konto> kontod = new ArrayList<>();

  public LimiiditaPank(String nimi) {
    this.nimi = nimi;
  }

  public void lisaKonto(Konto konto) {
    kontod.add(konto);
    koguKontodeArv++;
  }

  public void prindiKontodeInfo() {
    for (Konto konto : kontod) {
      System.out.println(konto);
    }
  }

  public void prindiSaldo(String nimi, int pin) {
    for (Konto konto : kontod) {
      if (konto.getOmanik().equals(nimi)) {
        if (konto.getPin() == pin) {
          System.out.println(konto.getSaldo());
        }
        else {
          System.out.println("Vale PIN kood!");
        }
        return;
      }
    }
    System.out.println("Kontot nimele " + nimi + " ei leitud!");
  }

  public String getNimi() {
    return nimi;
  }

  public static int getKoguKontodeArv() {
    return koguKontodeArv;
  }

}
