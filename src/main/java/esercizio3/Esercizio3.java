package esercizio3;

import esercizio3.conto.ContoCorrente;
import esercizio3.conto.ContoOnLine;
import exceptions.BancaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Esercizio3 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio3.class);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ContoCorrente contoCorrente = new ContoCorrente("Mario Rossi", 500);
        ContoOnLine contoOnLine = new ContoOnLine("Luigi Bianchi", 1000, 300);
        
        System.out.println("Benvenuto! Scegli su quale conto effettuare i prelievi.");
        System.out.println("1 - ContoCorrente");
        System.out.println("2 - ContoOnLine");
        
        int scelta = scanner.nextInt();
        ContoCorrente contoScelto = (scelta == 1) ? contoCorrente : contoOnLine;
        
        System.out.println("Hai scelto: " + (scelta == 1 ? "ContoCorrente" : "ContoOnLine"));
        
        while (true) {
            System.out.println("Saldo attuale: " + contoScelto.restituisciSaldo());
            
            if (contoScelto instanceof ContoOnLine) {
                System.out.println("Massimo prelievo: " + ((ContoOnLine) contoScelto).getMaxPrelievo());
            }
            
            System.out.print("Inserisci l'importo da prelevare (0 per uscire): ");
            double importo = scanner.nextDouble();
            
            if (importo == 0) {
                System.out.println("Uscita dal programma.");
                break;
            }
            
            try {
                contoScelto.preleva(importo);
                System.out.println("Prelievo effettuato con successo!");
            } catch (BancaException e) {
                logger.error("Errore: ", e);
            }
        }
        
        scanner.close();
    }
}
