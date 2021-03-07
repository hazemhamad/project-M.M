
package multimediaproject.Huffman;


public class HuffmanNode {
    int freq;
    String c;
    String letter;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int freq, String letter, HuffmanNode left, HuffmanNode right) {
        this.freq = freq;
        this.letter = letter;
        this.left = left;
        this.right = right;
    }

    public HuffmanNode(int freq,HuffmanNode left, HuffmanNode right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
    
    
}
