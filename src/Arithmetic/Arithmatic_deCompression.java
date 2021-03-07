package Arithmetic;


import java.util.ArrayList;


class symbole {

    double prob, comulative, low, high;
    String ch;

    public symbole(String ch, double prob, double com, double low, double high) {
        this.prob = prob;
        this.low = low;
        this.high = high;
        this.ch = ch;
        this.comulative = com;
    }

    public double getComulative() {
        return comulative;
    }

    public String getCh() {
        return ch;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

}

public class Arithmatic_deCompression {

    ArrayList<symbole> symbolelist = new ArrayList<>();
    float Str;
    symbole s;
   
    String Code = "0.";
    String ouuut="";

boolean flage2=false;
    boolean flage=false;
    int ind;

    public Arithmatic_deCompression(float Str) {
        this.Str = Str;
    }

    

    public void compress() {

        symbolelist.add(new symbole("A", 0.2, 0.2, 0, 0.2));
        symbolelist.add(new symbole("B", 0.1, 0.3, 0.2, 0.3));
        symbolelist.add(new symbole("C", 0.2, 0.5, 0.3, 0.5));
        symbolelist.add(new symbole("D", 0.05, 0.55, 0.5, 0.55));
        symbolelist.add(new symbole("E", 0.3, 0.85, 0.55, 0.85));
        symbolelist.add(new symbole("F", 0.05, 0.9, 0.85, 0.9));
        symbolelist.add(new symbole("$", 0.1, 1, 0.9, 1));





int ii=0;
        do{

                ii++;
                if (!flage2) {
                    for (int j = 0; j < symbolelist.size(); j++) {
                        if (j == 0) {
                            symbolelist.get(j).setLow(s.getLow());
                            symbolelist.get(j).setHigh(Double.valueOf(/*d.format*/((float) s.getLow() + (symbolelist.get(j).getComulative() * (s.getHigh() - s.getLow())))));
                        } else if (j == symbolelist.size() - 1) {
                            symbolelist.get(j).setLow(symbolelist.get(j - 1).high);
                            symbolelist.get(j).setHigh(s.getHigh());
                        } else {

                            symbolelist.get(j).setLow(symbolelist.get(j - 1).high);
                            symbolelist.get(j).setHigh(Double.valueOf(/*d.format*/((float) s.getLow() + (symbolelist.get(j).getComulative() * (s.getHigh() - s.getLow())))));
                        }

                    }
                }

            flage2=false;
        }while (!flage);

     
    }

    public symbole Search(float c) {

        for (int j = 0; j < symbolelist.size(); j++) {
            if (c>=symbolelist.get(j).getLow()&&c<symbolelist.get(j).getHigh()) {
                ind=j;
                ouuut+=symbolelist.get(j).ch;
                Str=Float.valueOf((Str-(float)symbolelist.get(j).getLow())/(((float)symbolelist.get(j).getHigh())-((float)symbolelist.get(j).getLow())));
                return new symbole(symbolelist.get(j).ch, symbolelist.get(j).prob, symbolelist.get(j).comulative, symbolelist.get(j).low
                        , symbolelist.get(j).high);
            }

        }
        flage2=true;flage=true;
        return null;
    }

    public int Searchindex(float c) {

        for (int j = 0; j < symbolelist.size(); j++) {
            if (c>=symbolelist.get(j).getLow()&&c<symbolelist.get(j).getHigh()) {
                return j;
            }

        }
        return -1;
    }

}
