
package VariableLength;

import java.awt.Graphics;
import java.util.ArrayList;
import multimediaproject.Huffman.HuffmanNode;


public class VariableLengthTree extends javax.swing.JFrame {

 
    
    
     
       public static ArrayList<VariableLength> list=new ArrayList<>();
       public static ArrayList<VariableLength> result=new ArrayList<>();
       public static ArrayList<String> Letters=new ArrayList<>();
       
     
       
       static String word;
       
        ArrayList<String> WordList=new ArrayList<>();
        ArrayList<Integer> freqList=new ArrayList<>();
        ArrayList<String> SortedList=new ArrayList<>();
        

    
    
    public VariableLengthTree(String word) {
        initComponents();
        this.word=word;
        run();
        new VariableCode().setVisible(true);
    }
    
    
    public void run(){
        
        int freq=1;
        
        for(int i=0;i<word.length();i++){
            freq=1;
            
            if(CheckLetter(Letters, String.valueOf(word.charAt(i)))){
            for(int j=i+1;j<word.length();j++){
        
            if(word.charAt(i)==word.charAt(j))
                freq++;
            }
               WordList.add(String.valueOf(word.charAt(i)));
               WordList.add(String.valueOf(freq));
               freqList.add(freq);
               Letters.add(String.valueOf(word.charAt(i)));
            }
            
        }
        
       //freqList.sort(null);
        for (int i = freqList.size()-1; i >= 0; i--) {
          
             for (int j = 1; i < WordList.size(); j+=2) {
                    if(freqList.get(i)==Integer.valueOf(WordList.get(j))){
                        if(check(list, WordList.get(j-1))){
                        list.add(new VariableLength(Integer.valueOf(WordList.get(j)), WordList.get(j-1)));
                        break;
                        }
                    }
             
              }   
        }
        for(int i=0;i<list.size()-1;i++){
       
            list.get(i).c=list.get(i).c.concat("0");
            for(int j=i+1;j<list.size();j++){
                list.get(j).c=list.get(j).c.concat("1");
            }
        }
        result=list;
    
    }

    public void paint(Graphics g){
        
        int sum=0;
        for(int i=0;i<freqList.size();i++){
            sum+=freqList.get(i);
        }
        g.drawOval(300, 50, 50, 40);
        g.drawString(String.valueOf(sum), 320, 65);
        g.drawLine(350, 75, 450, 120);
        g.drawString("1", (350+450)/2, (75+120)/2);
       
        
        g.drawLine(320, 90, 320, 130);
        g.drawString("0", (320+320)/2, (90+130)/2);
        
        
        
        
       String temp=list.get(0).letter;
 
        int x=300;
        int y=50;
        int center=300;
        for(int i=0;i<list.size()-1;i++){
            x+=150;
            y+=50;
        g.drawOval(x, y, 50, 40);
        g.drawOval(center, y+30, 50, 40);
        g.drawString(list.get(i).letter, center+20, y+45);
        String tempWord="";
        for(int j=i+1;j<list.size();j++){
            tempWord=tempWord.concat(list.get(j).letter);
        }
        g.drawString(tempWord, x+20, y+15);
        
// 
//        
        if((list.size()-1)-i!=1){
        g.drawLine(x+50, y+30, (x+50)+100, y+70);
        g.drawString("1", ((x+50)+((x+50)+100))/2, ((y+30)+(y+70))/2);
        g.drawLine(x+20, y+40, x+20, y+80);  
        g.drawString("0", ((x+20)+(x+20))/2, ((y+40)+(y+80))/2);
        center=x;
        }

        
       }

    }
    
    
    private static boolean check(ArrayList<VariableLength> h, String letter){
        boolean isCheck=true;
        if(h.size()==0){
            return isCheck;
        }
        for(int i=0;i<h.size();i++){
            if(letter.equals(h.get(i).letter))
                isCheck=false;
        }
        return isCheck;
    }
    
    private static boolean CheckLetter(ArrayList<String> l,String letter){
        boolean isCheck=true;
        if(l.size()==0){
            return isCheck;
        }
        for(int i=0;i<l.size();i++){
            if(letter.equals(l.get(i))){
                isCheck=false;
            break;
            }
        }
        return isCheck; 
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VariableLengthTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VariableLengthTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VariableLengthTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VariableLengthTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VariableLengthTree(word).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
