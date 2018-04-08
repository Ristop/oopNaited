package ut.ee.pank.var4;

// Loome abstraktse klassi Konto millel on kaks abstraktset meetodit sisseMakse ja väljaMakse
// Kõik abstraktsed meetodid on üle kirjutatud alamklassides HoiusKonto ja TavalineKonto
public abstract class Konto implements Comparable<Konto>{

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

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  abstract void sisseMakse(double summa);

  abstract void valjaMakse(double summa);

  @Override
  public String toString() {
    return omanik + " (" + saldo + ")";
  }

  @Override
  public int compareTo(Konto o) {
    if (this.saldo > o.getSaldo()) {
      return 1;
    }
    else if (this.saldo < o.getSaldo()) {
      return -1;
    }
    else {
      return 0;
    }
  }

}