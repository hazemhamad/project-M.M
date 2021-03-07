
package ShannonFano;

import RunLength.RunLengthCompression;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import multimediaproject.Huffman.CodesTable;
import multimediaproject.Huffman.HuffmanNode;


public class ShannonCompress extends javax.swing.JFrame {

       
         public static ArrayList<ShannonFano> list=new ArrayList<>();
       public  ArrayList<String> Letters=new ArrayList<>();
       
       
       
       
        ArrayList<String> WordList=new ArrayList<>();
        ArrayList<Integer> freqList=new ArrayList<>();
        ArrayList<String> SortedList=new ArrayList<>();
        

        
        

       static String word;
         DefaultTableModel model;
    String line="";
    public ShannonCompress(String word) {
        initComponents();
        this.word=word;
        sortArray();
        compress(list);
         jTextField1.setEnabled(false);
        model= (DefaultTableModel)jTable1.getModel();
        for (int i = 0; i < list.size(); i++) {
            Object row[]={list.get(i).word,list.get(i).freq,list.get(i).code};
                model.addRow(row);
        }
        
        for(int i=0;i<word.length();i++){
            for(int j=0;j<list.size();j++){
                if(String.valueOf(word.charAt(i)).equals(list.get(j).word)){
                    line+=list.get(j).code;
                }
            }
        }
       
         try {
            FileWriter fw=new FileWriter("E:\\MultiMediaProject\\ShannonFanon.txt");
            BufferedWriter bfw=new BufferedWriter(fw);
            bfw.write(line);
            bfw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }

    public  void sortArray()
    {
        int freq=1;
        
        for(int i=0;i<word.length();i++){
            freq=1;
            System.out.println(word.charAt(i));
            if(CheckLetter(Letters, String.valueOf(word.charAt(i)))){
            for(int j=i+1;j<word.length();j++){
                 System.out.println(word.charAt(j));
            if(word.charAt(i)==word.charAt(j))
                freq++;
            }
               WordList.add(String.valueOf(word.charAt(i)));
               WordList.add(String.valueOf(freq));
               freqList.add(freq);
               Letters.add(String.valueOf(word.charAt(i)));
            }
            
        }
        
     
       

               for (int i = freqList.size()-1; i >= 0; i--) {
                System.out.println(freqList.get(i));
                 for (int j = 1; i < WordList.size(); j+=2) {
                        if(freqList.get(i)==Integer.valueOf(WordList.get(j))){
                        if(check(list, WordList.get(j-1))){
                        list.add(new ShannonFano(WordList.get(j-1), freqList.get(i), ""));
                        break;
                        }
                    }
             
              }   
        }
       
    }
    
    public  void compress(ArrayList<ShannonFano> CodeList){
       
        
        if(CodeList.size()==1)
            return;
        else{
        int sum=0;
        for (int i = 0; i < CodeList.size(); i++) {
            sum+=CodeList.get(i).freq;
        }
        sum/=2;
        int subSum=CodeList.get(0).freq;
        int index=0;

        int c=1;
        do{
            index++;
            subSum+=CodeList.get(c).freq;
            if(subSum>sum){
                index--;
                break;
            }
            c++;
        }while(subSum<=sum);

        ArrayList<ShannonFano> leftWord=new ArrayList<>();
        ArrayList<ShannonFano> rightWord=new ArrayList<>();
        for(int i=0;i<CodeList.size();i++){
            if(i<=index){
           String codes=CodeList.get(i).code;
           
           CodeList.get(i).code=codes.concat("1");
                leftWord.add(CodeList.get(i));
            }
            else{
                String codes=CodeList.get(i).code;
                
                CodeList.get(i).code=codes.concat("0");
                rightWord.add(CodeList.get(i));
            }
        }
        compress(leftWord);
        compress(rightWord);
        
        }
    }
        
  
    
    
    public static boolean CheckLetter(ArrayList<String> l,String letter){
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

    private static boolean check(ArrayList<ShannonFano> h, String letter){
        boolean isCheck=true;
        if(h.size()==0){
            return isCheck;
        }
        for(int i=0;i<h.size();i++){
            if(letter.equals(h.get(i).word))
                isCheck=false;
        }
        return isCheck;
    }
   
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Letter", "Frequency", "Code"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Decompression");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Compresion Ratio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButton2)
                .addGap(81, 81, 81)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("E:\\MultiMediaProject\\ShannonFanon.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShannonCompress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShannonCompress.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        new ShannonDecompression(line).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("E:\\MultiMediaProject\\ShannonFanon.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShannonCompress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShannonCompress.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println("line"+line.length()+"");
              System.out.println("wod"+word.length()+"");
          double t=(double)((((word.length()*8)-(double)(line.length()))/(double)word.length())*100);
        jTextField1.setText(t+"");
        System.out.println(t);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ShannonCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShannonCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShannonCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShannonCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShannonCompress(word).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
