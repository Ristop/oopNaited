package ut.ee.pank.var2;

public class Konto {

  private String omanik;
  private int pin;
  private double saldo;

  public Konto(String omanik, int pin, double saldo) {
    this.omanik = omanik;
    this.pin = pin;
    this.saldo = saldo;
  }

  public Konto(String omanik, int pin) {
    this(omanik, pin, 0.0);
  }

  public String getOmanik() {
    return omanik;
  }

  public int getPin() {
    return pin;
  }

  public double getSaldo() {
    return saldo;
  }

  @Override
  public String toString() {
    return omanik + " (" + saldo + ")";
  }

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