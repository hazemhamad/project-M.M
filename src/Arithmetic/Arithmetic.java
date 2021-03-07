
package Arithmetic;


public class Arithmetic {
    
    String symbol;
    double probabilty;
    double cummulative;

    public Arithmetic(String symbol, double probabilty, double cummulative) {
        this.symbol = symbol;
        this.probabilty = probabilty;
        this.cummulative = cummulative;
    }

    public double getProbabilty() {
        return probabilty;
    }

    public double getCummulative() {
        return cummulative;
    }
    
}
