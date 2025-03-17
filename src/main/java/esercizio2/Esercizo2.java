package esercizio2;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.DivisionePerZeroExc;

public class Esercizo2 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizo2.class);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int kmPercorsi = 0;
            int litriConsumiInt = 0;
            double litriConsumiDouble = 0.0;
            
            while (true) {
                try {
                    System.out.print("Inserisci i km percorsi: ");
                    kmPercorsi = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    logger.error("Errore durante l'inserimento dei km", e);
                    scanner.nextLine();
                }
            }
            
            while (true) {
                try {
                    System.out.print("Inserisci i litri di carburante consumati (int): ");
                    litriConsumiInt = scanner.nextInt();
                    if (litriConsumiInt == 0) {
                        throw new DivisionePerZeroExc("Errore: impossibile dividere per zero!");
                    }
                    break;
                } catch (DivisionePerZeroExc e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    logger.error("Errore durante l'inserimento dei litri", e);
                    scanner.nextLine();
                }
            }
            
            int kmPerLitroInt = (int) kmPercorsi / litriConsumiInt;
            logger.info("Consumo (km/litro) usando interi: {} km/l", kmPerLitroInt);
            
            while (true) {
                try {
                    System.out.print("Inserisci i litri di carburante consumati (double): ");
                    litriConsumiDouble = scanner.nextDouble();
                    if (litriConsumiDouble == 0.0) {
                        throw new DivisionePerZeroExc("Errore: impossibile dividere per zero!");
                    }
                    break;
                } catch (DivisionePerZeroExc e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    logger.error("Errore durante l'inserimento dei litri", e);
                    scanner.nextLine();
                }
            }
            
            double kmPerLitroDouble = kmPercorsi / litriConsumiDouble;
            logger.info("Consumo (km/litro) usando double: {} km/l", kmPerLitroDouble);
            
            System.out.print("Vuoi fare un altro calcolo? (s/n): ");
            String risposta = scanner.next();
            if (!risposta.equals("s")) {
                break;
            }
        }
    }
}
