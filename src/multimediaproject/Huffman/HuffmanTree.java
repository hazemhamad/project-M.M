
package multimediaproject.Huffman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.Timer;
import static multimediaproject.Huffman.Huffman.list;


public class HuffmanTree extends JFrame {

    HuffmanNode righttemp;
    HuffmanNode lefttemp;
    //static Graphics g;
    int b = 0;

    public HuffmanTree() {
        super("Data Visualizer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500, 1500);
  
        
        setVisible(true);

        righttemp = list.get(0).right;
        lefttemp = list.get(0).left;
        System.out.println("here");
    }

    public void paint(Graphics g) {
               super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
       // g2d.setColor(Color.red);
        
        int xo = 700;
        int yo = 50;
        g2d.drawOval(xo, yo, 50, 40);
        g2d.drawString(String.valueOf(list.get(0).freq), xo + 20, yo + 20);
        g2d.drawString(String.valueOf(list.get(0).letter), xo + 20, yo + 30);
        if (list.get(0).right != null) {
            g2d.drawLine(xo + 30, yo + 40, xo + 260, yo + 70);
            g2d.drawString("0", ((xo + 30) + (xo + 90)) / 2, ((yo + 40) + (yo + 70)) / 2);

        }
        if (list.get(0).left != null) {
            g2d.drawLine(xo + 30, yo + 40, xo - 160, yo + 70);
            //k+=60;
            g2d.drawString("1", ((xo + 30) + (xo - 90)) / 2, ((yo + 40) + (yo + 70)) / 2);
        }

        drawLeftandRight(list.get(0).left, g2d, xo - 260, yo);
        drawLeftandRight(list.get(0).right, g2d, xo + 160, yo);

    }

public void drawLeftandRight(HuffmanNode n ,Graphics g,int xo,int yo){

        if(n==null){
            return;
        }else{
        xo=xo+80;
        yo=yo+70;
        g.drawOval(xo, yo, 50, 40);
        g.drawString(String.valueOf(n.freq), xo+20, yo+20);
        g.drawString(String.valueOf(n.letter), xo+20, yo+30);
        if(n.right!=null){
        g.drawLine(xo+30, yo+40, xo+120, yo+70);
        g.drawString("0", ((xo+30)+(xo+90))/2, ((yo+40)+(yo+70))/2);
        
        }
        if(n.left!=null){
        g.drawLine(xo+30, yo+40, xo-160, yo+70);
        //k+=60;
        g.drawString("1", ((xo+30)+(xo-90))/2, ((yo+40)+(yo+70))/2);
        }
        
          drawLeftandRight(n.left, g, xo-250, yo);
          drawLeftandRight(n.right, g, xo+30, yo);
         }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new HuffmanTree();
    }
}
