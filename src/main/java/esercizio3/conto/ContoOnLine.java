package esercizio3.conto;

import exceptions.BancaException;
import lombok.Getter;

@Getter

public class ContoOnLine extends ContoCorrente {
    private double maxPrelievo;
    
    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }
    
    public void stampaSaldo() {
        System.out.println("Titolare: " + getTitolare() + " - Saldo: " + getSaldo() + " - Num movimenti: " + getNMovimenti()
                + " - Massimo movimenti: " + getMaxMovimenti() + " - Massimo prelievo possibile: " + maxPrelievo);
    }
    
    public void preleva(double x) throws BancaException {
        if (x > restituisciSaldo()) {
            throw new BancaException("Saldo insufficiente!");
        }
        if (x > maxPrelievo) {
            throw new BancaException("Il prelievo non è disponibile");
        }
        if (x <= maxPrelievo) {
            super.preleva(x);
        }
    }
}

