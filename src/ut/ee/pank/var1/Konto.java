package ut.ee.pank.var1;

public class Konto {

  // Igal kontol on kolm privaatset isendi välja omanku, pini ja saldo jaoks
  private String omanik;
  private int pin;
  private double saldo;

  public Konto(String omanik, int pin, double saldo) {
    this.omanik = omanik;
    this.pin = pin;
    this.saldo = saldo;
  }

  // Kui saldod kaasa ei anta siis kutsutakse välja järgnev konstruktor. Konstruktori sees
  // kutsume välja esimse konstruktori kuhu anname kaasa saldo 0.0
  public Konto(String omanik, int pin) {
    this(omanik, pin, 0.0);
  }

  // Kolm get meetodit privaatsete väljade kätte saamiseks

  public String getOmanik() {
    return omanik;
  }

  public int getPin() {
    return pin;
  }

  public double getSaldo() {
    return saldo;
  }

  // Kirjutame üle toString meetodi, et välja printides Konto objektid ilusamad välja näeksid
  // @Override tähendab siin seda et me kirjutame üle meetodi klassi ülem klassist.
  // @Override on ülekirjutamisel alati soovituslik!
  @Override
  public String toString() {
    return omanik + " (" + saldo + ")";
  }

  // Kirjutame ole equals meetodi nii, et kui kahe konto omanku sõned
  // on võrdse on ka Kontod võrdsed
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Konto)) {
      return false;
    }

    Konto konto = (Konto) obj;

    if (this.getOmanik().equals(konto.getOmanik())) {
      return true;
    }
    else {
      return false;
    }

  }
}