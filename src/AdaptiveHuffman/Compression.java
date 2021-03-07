
package AdaptiveHuffman;



public class Compression {

    
   public static String s; 
  
 
 
   
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
     
      
   s="abracadabra";
    System.out.println("========compression============\n");
   Adaptive_huffman adap=new Adaptive_huffman();
    adap.adaptive(s);
    new AdaptiveTable().setVisible(true);
       System.out.println("\n========Decompression============");
    adap.Adaptive_huffman_decompres("1111010110100");
    System.out.println("\n");
    }
    
}
