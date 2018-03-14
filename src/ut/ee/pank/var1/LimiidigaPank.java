package ut.ee.pank.var1;

/*
Loome panga kasutades masiivi kontode hoidmiseks. Kuna masiivile peame ette andma
suuruse siis on meie panga kontode arv selles näites piiratud.
 */
public class LimiidigaPank {

  // Klassi muutuja (static) mis hoiab endas kõikide limiidiga pankade kontode arvu
  private static int koguKontodeArv;

  private String nimi;
  private int hetkeKontodeArv = 0;
  private int maksimumKontodeArv;
  private Konto[] kontod;

  // Konstruktor uue panga loomiseks kahe parameetriga
  public LimiidigaPank(String nimi, int maksimumKontodeArv) {
    this.nimi = nimi;
    this.maksimumKontodeArv = maksimumKontodeArv;
    this.kontod = new Konto[maksimumKontodeArv];
  }

  // Konstruktor uue panga loomiseks ühe parameetriga. Selles konstruktoris kutsume välja
  // eelnevat kahe parameetriga konstruktorit kuhu anname kaasa maksimum kontode arvuks 100
  public LimiidigaPank(String nimi) {
    this(nimi, 100);
  }

  public void lisaKonto(Konto konto) {
    if (hetkeKontodeArv != maksimumKontodeArv) {
      kontod[hetkeKontodeArv] = konto;
      hetkeKontodeArv++;
      koguKontodeArv++;
    }
    else {
      System.out.println("Panga limiit täis!");
    }
  }

  public void prindiKontodeInfo() {
    for (int i = 0; i < hetkeKontodeArv; i++) {
      System.out.println(kontod[i]);
    }
  }

  public void prindiSaldo(String nimi, int pin) {
    for (int i = 0; i < hetkeKontodeArv; i++) {
      Konto konto = kontod[i];
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
