
package multimediaproject.Huffman;

import java.awt.Graphics;
import static multimediaproject.Huffman.CodesTable.TextCode;

public class HuffmanDecompression extends javax.swing.JFrame {

   
   static String code;
   String result="";
    public HuffmanDecompression(String code) {
        initComponents();
        this.code=code;
        
        String temp="";
        for(int i=0;i<code.length();i++){
            temp+=code.charAt(i);
            for(int j=1;j<TextCode.size();j++){
                if(temp.equals(TextCode.get(j))){
                    result+=TextCode.get(j-1);
                    temp="";
                }
            }
        }
        
        
    }
    
    public void paint(Graphics g){
        g.drawString(result, getWidth()/2, getHeight()/2);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HuffmanDecompression(code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
