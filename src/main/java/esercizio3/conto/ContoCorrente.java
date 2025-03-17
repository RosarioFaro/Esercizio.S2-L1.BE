package esercizio3.conto;

import exceptions.BancaException;
import lombok.Getter;

@Getter

public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;
    
    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }
    
    public void preleva(double x) throws BancaException {
        if (x > saldo) {
            throw new BancaException("Saldo insufficiente!");
        }
        if (nMovimenti < maxMovimenti) saldo = saldo - x;
        else saldo = saldo - x - 0.50;
        if (saldo < 0) throw new BancaException("Il conto è in rosso!");
        nMovimenti++;
    }
    
    public double restituisciSaldo() {
        return saldo;
    }
}

