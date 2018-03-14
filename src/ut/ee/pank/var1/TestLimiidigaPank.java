package ut.ee.pank.var1;

/*
Test klass var1 panga testimiseks.
 */
public class TestLimiidigaPank {

  public static void main(String[] args) {

    // Loome kaks limiidiga panga objekti
    LimiidigaPank seb = new LimiidigaPank("SEB"); // Kasutame ainult nimega konstruktorit
    LimiidigaPank swed = new LimiidigaPank("SWED", 1000); // Kasutame nime ja maksimum kontode arvuga konstruktorit

    // Loome mõned test kontod
    Konto konto1 = new Konto("Mari", 1234, 40.0); // Kasutame koos saldoga konstruktorit
    Konto konto2 = new Konto("Jüri", 3452); // Kasutame ilma saldota konstruktorit
    Konto konto3 = new Konto("Madis", 2463, 40.0);
    Konto konto4 = new Konto("Hannes", 1623);

    // Lisame kaks kontot seb panka
    seb.lisaKonto(konto1);
    seb.lisaKonto(konto2);

    // Ja kaks kontot swed panka
    swed.lisaKonto(konto3);
    swed.lisaKonto(konto4);

    System.out.println(seb.getNimi() + ":");
    seb.prindiKontodeInfo();
    /* Väljastab:
      Mari (40.0)
      Jüri (0.0)
    */

    System.out.println(swed.getNimi() + ":");
    swed.prindiKontodeInfo();
    /* Väljastab:
      Madis (40.0)
      Hannes (0.0)
    */

    seb.prindiSaldo("Madis", 2463); // Väljastab: Kontot nimele Madis ei leitud!
    swed.prindiSaldo("Madis", 2463); // Väljastab: 40.0

    // Võrdleme kahte kontot
    System.out.println(konto1.equals(konto2)); // false
    System.out.println(konto2.equals(konto2)); // true
  }

}
