package esercizio1;

import java.util.Random;
import java.util.Scanner;

import exceptions.ArrayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio1 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio1.class);
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }
        
        System.out.println("Array iniziale:");
        stampaArray(array);
        
        boolean statoDelCiclo = true;
        
        while (statoDelCiclo) {
            logger.info("Inizio della modifica dell'array");
            
            try {
                System.out.println("Inserisci la posizione da modificare (0-4) -1 per uscire");
                
                int posizione = scanner.nextInt();
                if (posizione == -1) {
                    statoDelCiclo = false;
                    continue;
                }
                
                if (posizione < 0 || posizione >= array.length) {
                    throw new ArrayException("Errore: posizione non valida!");
                }
                
                System.out.println("Inserisci il nuovo valore (0 per terminare):");
                int valore = scanner.nextInt();
                
                if (valore == 0) {
                    statoDelCiclo = false;
                    continue;
                }
                
                array[posizione] = valore;
                logger.info("Modificato elemento in posizione " + posizione + " con valore " + valore);
                
                System.out.println("Nuovo stato dell'array:");
                stampaArray(array);
                
            } catch (ArrayException e) {
                System.out.println(e.getMessage());
                logger.info("Errore, posizione non valida", e);
            } catch (Exception e) {
                System.out.println("Errore nell'inserimento dei dati.");
                logger.info("Errore durante l'input", e);
                scanner.nextLine();
            }
        }
        
        scanner.close();
        System.out.println("Programma terminato.");
    }
    
    private static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
