package ut.ee.pank.var4;

public class TavalineKonto extends Konto {

  public TavalineKonto(String omanik, int pin, double saldo) {
    super(omanik, pin, saldo);
  }

  public TavalineKonto(String omanik, int pin) {
    super(omanik, pin);
  }

  @Override
  void sisseMakse(double summa) {
    setSaldo(getSaldo() + summa);
  }

  @Override
  void valjaMakse(double summa) {
    if (getSaldo() >= summa) {
      setSaldo(getSaldo() - summa);
      System.out.println("Väljastan: " + summa);
    }
  }

  @Override
  public String toString() {
    return "TavalineKonto:" + super.toString();
  }

}
