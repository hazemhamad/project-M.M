
package AdaptiveHuffman;

import java.util.ArrayList;


class Nod {
    String wod="";
    public char letter;     
    public int count;      
    public int left;        
    public int codright;        
    public int parent;       
    public int codleft;


    public Nod(char letter, int count, int left, int right, int codlef, int parent) {

        this.codleft = codleft;
        this.letter = letter;
        this.count = count;
        this.left = left;
        this.codright = right;
        this.parent = parent;
    }

    public Nod() {

    }
}

public class Adaptive_huffman {

    public static double lenA=0.0,lenB=0.0,compession = 0.0;
    public Adaptive_huffman() {
    }

    ArrayList<ShannonFano.ShannonFano> codeWord=new ArrayList<>();
    public void adaptive(String s) {

        coding(s);
        sorttt(nodeList);
        printAllRootToLeafPaths(nodeList);

    }
    //String s="abcaab";
      public static ArrayList<String> code = new ArrayList<String>();
      public static  ArrayList<Character> symbol = new ArrayList<Character>();
    ArrayList<Nod> nodeList = new ArrayList<Nod>();
    int i = 0, index = -1;
    int le = 0, co = 1;

    public void coding(String s) {
        if (i < s.length()) {
            if (!first_readOf(s.charAt(i))) {
                Nod nod = new Nod();
                nod = new Nod(s.charAt(i), co, le, 1, 0, (le + co));
                nodeList.add(nod);
                update_tree(nodeList);
                sorttt(nodeList);
            }

            i++;
            coding(s);
        }
        for (int i = 0; i < nodeList.size() - 1; i++) {

            nodeList.get(i).left = nodeList.get(i + 1).parent;
            nodeList.get(i).parent = nodeList.get(i).count + nodeList.get(i).left;
            if (nodeList.get(i).left > nodeList.get(i).count) {
                nodeList.get(i).codleft = 1;
                nodeList.get(i).codright = 0;
            }

        }
       
    }

public void sorttt(ArrayList<Nod> nn) {

        int temp = 0;
        Character tempStr = ' ';
        for (int i = nodeList.size() - 1; i >0; i--) {

            for (int j = 1; j <=(i) ; j++) {
                if (nn.get(i).count > nn.get(j-1).count) {

                    // =================sort char
                    tempStr = nn.get(i).letter;
                    nn.get(i).letter = nn.get(j-1).letter;
                    nn.get(j-1).letter = tempStr;

                    //swap count
                    temp = nn.get(i).count;
                    nn.get(i).count = nn.get(j-1).count;
                    nn.get(j-1).count = temp;

                    nn.get(j-1).left=nn.get(j).count+nn.get(j).left;
                    nn.get(j-1).parent=nn.get(j-1).count+nn.get(j-1).left;


                    nn.get(i).parent=nn.get(i).count+nn.get(i).left;
                    nn.get(i-1).left=nn.get(i).count+nn.get(i).left;
                   // nn.get(i-1).parent=nn.get(i-1).count+nn.get(i-1).left;
                }

            }
        }

    }

    
public void Adaptive_huffman_decompres(String s)
{
    String neStr="";
    for(int i=0;i<s.length();i++)
    {
        neStr+=s.charAt(i);
     if(search_s(neStr))
        {
         neStr="";
         
        }
    
    }


}
public boolean search_s(String s)
{
   for(int i=0;i<code.size();i++)
    {
        if(code.get(i).equals(s))
        {
        
            System.out.print(symbol.get(i));
            return true;
        }
 
    }
return false;
}

    
    public void printAllRootToLeafPaths(ArrayList<Nod> n) {
        ArrayList<String> nodes = new ArrayList<String>();
        int ii = 1;
        nodes.add(String.valueOf(n.get(ii - 1).codright));
        code.add(String.valueOf(n.get(ii - 1).codright));
        symbol.add(n.get(ii - 1).letter);
        nodes.add(String.valueOf(n.get(ii - 1).letter));
        String codee="";
        while (ii < nodeList.size()) {
            for (int i = 0; i < ii; i++) {
                codee+=n.get(i).codleft;
                nodes.add(n.get(i).codleft + "");
                

            }
            codee+=String.valueOf(n.get(ii).codright);
            code.add(codee);
            codee="";
            nodes.add(String.valueOf(n.get(ii).codright));
            nodes.add(String.valueOf(n.get(ii).letter));
            symbol.add(n.get(ii).letter);
            
            ii++;
        }

        String temp="";
        String x= "";
       
        for (int i = 0; i < nodes.size(); i++) {
         
            lenB = nodeList.size();
            lenA = Math.abs(lenB - nodes.size());
            System.out.println("Code :| "+nodes.get(i));  
            lenA += lenB;
            
                }
        System.out.println("len "+ lenA);
        compession =  Math.abs(((double)(lenB*8 - lenA))/ ((double)(lenB*8)));
        int nm=0;
    }

    private boolean first_readOf(char c) {

        for (int i = 0; i < nodeList.size(); i++) {
      
            if (c == nodeList.get(i).letter) {
                nodeList.get(i).count += 1;

                nodeList.get(i).parent = nodeList.get(i).count + nodeList.get(i).left;
               
                return true;
            }

        }
      
        return false;
    }

    private void update_tree(ArrayList<Nod> nodeList) {

      
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(0).left = nodeList.get(1).parent;
            nodeList.get(i).left = nodeList.get(i + 1).parent;
            nodeList.get(i).parent = nodeList.get(i).count + nodeList.get(i).left;

        }
      

    }
}
