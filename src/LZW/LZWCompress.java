
package LZW;

import RunLength.RunLengthCompression;
import RunLength.RunLengthDecompression;
import java.awt.HeadlessException;
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


public class LZWCompress extends javax.swing.JFrame {


       static String word;
      ArrayList<Dictionary> dictionaryList=new ArrayList<Dictionary>();
     
    DefaultTableModel model;

    
    
    
    
    public LZWCompress(String word) {
        initComponents();
        jTextField1.setEnabled(false);
           this.word=word;
        model= (DefaultTableModel)jTable1.getModel();
        
        printTable();
        
    }
    
     public void printTable(){
    
         String Codes="";
        dictionaryList.add(new Dictionary(1, "a"));
        dictionaryList.add(new Dictionary(2, "b"));
        dictionaryList.add(new Dictionary(3, "c"));
        
        String s= String.valueOf(word.charAt(0));
        for(int i=1;i<word.length();i++){
            String c=String.valueOf(word.charAt(i));
            String newWord=s.concat(c);
            int output= getCode(s);
           
           boolean exist= searchDictionary(newWord);
           if(!exist){
               int newCode=dictionaryList.get(dictionaryList.size()-1).code+1;
               dictionaryList.add(new Dictionary(newCode, newWord));
               Object row[]={s,c,output,newCode, newWord};
                model.addRow(row);
                Codes+=output;
               s=c;
           }else{    
               Object row[]={s,c,"","", ""};
                model.addRow(row);
               s=newWord;
           }
          
        }

        getCode(String.valueOf(word.charAt(word.length()-1)));
     
        Object row[]={word.charAt(word.length()-1),"EOF",getCode(String.valueOf(word.charAt(word.length()-1))),"", ""};
                model.addRow(row);
                Codes+=getCode(String.valueOf(word.charAt(word.length()-1)));
                
               
        try {
            FileWriter fw=new FileWriter("E:\\MultiMediaProject\\LZW.txt");
            BufferedWriter bfw=new BufferedWriter(fw);
            bfw.write(Codes);
            bfw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        }
                
     }

          private  boolean searchDictionary(String Letter) {
              boolean found=false;
             for(int i=0;i<dictionaryList.size();i++){
                 if(Letter.equals(dictionaryList.get(i).word)){
                     found=true;
                     break;
                     
                     
                 }
         
             }
             return found;
         }

    private int getCode(String s) {
        int output=-1;
        for(int i=0;i<dictionaryList.size();i++){
                 if(s.equals(dictionaryList.get(i).word)){
                     output= dictionaryList.get(i).code;
                 break;
                 }
             }
       return output;
    }
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S", "C", "Output", "Code", "String"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "a"},
                {"2", "b"},
                {"3", "c"}
            },
            new String [] {
                "Code", "String"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Decompression");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Compression Ratio");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addGap(67, 67, 67)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("C:\\Users\\Mo7amed\\Pictures\\MultiMedia_Project_1\\LZW.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LZWCompress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LZWCompress.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=1;i<line.length();i+=2){
            int count=Integer.parseInt(String.valueOf(line.charAt(i)));
            for(int j=1;j<=count;j++){
                text+=line.charAt(i-1);
            }
        }
      
        new LZWDecompress(text).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("C:\\Users\\Mo7amed\\Pictures\\MultiMedia_Project_1\\LZW.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LZWCompress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LZWCompress.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println("line"+line.length()+"");
        double t=(double)((((word.length()*8)-(double)(line.length()))/(double)word.length())*100);
        jTextField1.setText(t+"");
        System.out.println(t+"");
        
        
        
        
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
            java.util.logging.Logger.getLogger(LZWCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LZWCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LZWCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LZWCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LZWCompress(word).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
