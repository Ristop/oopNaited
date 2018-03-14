package ut.ee.pank.var4;

import java.time.LocalDateTime;

public class HoiusKonto extends Konto {

  private LocalDateTime hoiuseTähtaeg;

  public HoiusKonto(String omanik, int pin, double saldo, int pikkusPäevades) {
    super(omanik, pin, saldo);
    this.hoiuseTähtaeg = LocalDateTime.now().plusDays(pikkusPäevades);
  }

  public HoiusKonto(String omanik, int pin, int pikkusPäevades) {
    super(omanik, pin);
    this.hoiuseTähtaeg = LocalDateTime.now().plusDays(pikkusPäevades);
  }

  @Override
  void sisseMakse(double summa) {
    System.out.println("Hoius lukus");
  }

  @Override
  void valjaMakse(double summa) {
    if (hoiuseTähtaeg.isAfter(LocalDateTime.now())) {
      if (getSaldo() >= summa) {
        setSaldo(getSaldo() - summa);
        System.out.println("Väljastan: " + summa);
      }
    }
  }

  @Override
  public String toString() {
    return "HoiusKonto:" + super.toString();
  }

}
