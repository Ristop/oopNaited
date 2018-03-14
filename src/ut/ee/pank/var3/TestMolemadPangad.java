package ut.ee.pank.var3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMolemadPangad {

  public static void main(String[] args) throws FileNotFoundException {

    // Loome kaks limiidiga panga objekti
    Pank seb = new LimiiditaPank("SEB"); // Kasutame ainult nimega konstruktorit
    Pank swed = new LimiidigaPank("SWED"); // Kasutame nime ja maksimum kontode arvuga konstruktorit

    // Loeme sisse kontod kasutades Scannerit
    // Scanneri loome try-with-resources blokis, et peale kasutamist ta automaatselt suletaks
    try (Scanner kontodScanner = new Scanner(new File("src/ut/ee/pank/var3/kontod.txt"), "UTF-8")) {
      // Tsükkel jätkub kuni failis on ridu
      while (kontodScanner.hasNextLine()) {
        String kontoRida = kontodScanner.nextLine(); // Loeme sisse ühe rea
        String[] kontoOsad = kontoRida.split(" "); // Jagame rea tükkideks

        String nimi = kontoOsad[1];
        int pin = Integer.parseInt(kontoOsad[2]); // Kasutame mähisklassi, et sisse lugeda pin

        Konto uusKonto;

        // Kui konto real oli 4 osa, teame et kaasa on antud ka saldo
        if (kontoOsad.length == 4) {
          double saldo = Double.parseDouble(kontoOsad[3]); // Kasutame mähisklassi, et sisse lugeda saldo
          uusKonto = new Konto(nimi, pin, saldo);
        }
        else { // Kui saldot ei ole, kasutame ilma saldota konstruktorit
          uusKonto = new Konto(nimi, pin);
        }

        // Loeme sisse panga nime ja salvestame konto vastavasse panka
        String pangaNimi = kontoOsad[0];

        if ("seb".equals(pangaNimi)) {
          seb.lisaKonto(uusKonto);
        }
        else if ("swed".equals(pangaNimi)) {
          swed.lisaKonto(uusKonto);
        }
      }
    }

    List<Pank> pangad = new ArrayList<>();
    pangad.add(seb);
    pangad.add(swed);

    prindiPankadeInfo(pangad);
    salvestaPankadeNimed(pangad);

    seb.prindiSaldo("Madis", 2463); // Väljastab: Kontot nimele Madis ei leitud!
    swed.prindiSaldo("Madis", 2463); // Väljastab: 40.0
  }

  // Meetod pankade info printimiseks
  private static void prindiPankadeInfo(List<Pank> pangaList) {
    for (Pank pank : pangaList) {
      System.out.println(pank.getNimi() + ":");
      pank.prindiKontodeInfo();
    }
  }

  // Meetod mis salvestab ette antud pankade nimed faili
  private static void salvestaPankadeNimed(List<Pank> pangaList) throws FileNotFoundException {
    try (PrintWriter printWriter = new PrintWriter("src/ut/ee/pank/var3/pankade-nimed.txt")) {
      for (Pank pank : pangaList) {
        printWriter.println(pank.getNimi());
      }
    }
  }

}
