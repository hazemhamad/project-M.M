
package Arithmetic;

import RunLength.RunLengthCompression;
import ShannonFano.ShannonCompress;
import ShannonFano.ShannonDecompression;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArithmeticCompress extends javax.swing.JFrame {

   static String word;
    String Code="0.";
     String []symbols={"a","b","c","d","e","f","$"};
     
   public static ArrayList<Arithmetic> list=new ArrayList<Arithmetic>();
    
    public ArithmeticCompress(String word) {
        initComponents();
        jTextField1.setEnabled(false);
        list.add(new Arithmetic(symbols[0],0.2,0.2));
        list.add(new Arithmetic(symbols[1],0.1,0.3));
        list.add(new Arithmetic(symbols[2],0.2,0.5));
        list.add(new Arithmetic(symbols[3],0.05,0.55));
        list.add(new Arithmetic(symbols[4],0.3,0.85));
        list.add(new Arithmetic(symbols[5],0.05,0.9));
        list.add(new Arithmetic(symbols[6],0.1,1.0));
        this.word=word;
        
        
        
        
        
    }

    
    public void paint(Graphics g){
      g.drawLine(50, 50, 50, 650);
      g.drawString("0", 20, 60);
     // g.setColor(Color.red);
      int x=20;
      int y=60;
      g.drawString(list.get(0).symbol, x, y+40);
      for(int i=1;i<list.size();i++){
          y=y+80;
          g.drawString(String.valueOf(list.get(i-1).cummulative), x, y);
          if(list.size()!=list.size()-1)
          g.drawString(list.get(i).symbol, x, y+40);
      }
      g.drawString(String.valueOf(list.get(list.size()-1).cummulative), x, y+80);
      
      int k=1;
      y=80;
      x=50;
      String begin=null,end=null;
             String previousBegin=null,previousEnd=null;
     
      for(int i=0;i<word.length()-1;i++){
          for (int j = 0; j < list.size(); j++) {
         
          if(String.valueOf(word.charAt(i)).equals(list.get(j).symbol)){
             
             
              if(j==0){
                  if(previousBegin!=null)
                      begin=previousBegin;
                      else
                 begin="0";
              }
              else{
                  if(previousBegin!=null){
                double newRenge=Double.parseDouble(previousBegin)+((Double.parseDouble(previousEnd)-Double.parseDouble(previousBegin))*list.get(j-1).cummulative);
                      DecimalFormat df=new DecimalFormat("#.00");
                      String angleFormat=df.format(newRenge);
                g.drawString(angleFormat, x-20, (80*k)-20);
                g.drawString(angleFormat, x+100, 650);
                begin=String.valueOf(newRenge);
                }else
                 begin=String.valueOf(list.get(j-1).cummulative);
              }
             
                end=String.valueOf(list.get(j).cummulative);
                g.drawLine(x, (80*k)-20, x+100, 60);
                
                g.drawString(begin, x+100, 60);
                k++;
                g.drawLine(x, (80*k)-20, x+100, 650);
                if(previousBegin!=null){
                double newRenge=Double.parseDouble(previousBegin)+((Double.parseDouble(previousEnd)-Double.parseDouble(previousBegin))*list.get(j).cummulative);
                
                DecimalFormat df=new DecimalFormat("#.00");
                      String angleFormat=df.format(newRenge);
                g.drawString(angleFormat, x-20, (80*k)-20);
                g.drawString(angleFormat, x+100, 650);
                end=String.valueOf(newRenge);
                }else{
                g.drawString(end, x+100, 650);
                }
                g.drawLine(x+100, 60, x+100, 650);
                x=x+100;
                k=1;
                
               
                
                break;
          }
              else
              k++;
         }
          previousBegin=begin;
          previousEnd=end;
      }
      k=1;
      double newEnd=-1,newBegin=-1;
      for(int i=0;i<list.size();i++){
          if(String.valueOf(word.charAt(word.length()-1)).equals(list.get(i).symbol)){
                
              newBegin=Double.parseDouble(previousBegin)+((Double.parseDouble(previousEnd)-Double.parseDouble(previousBegin))*list.get(i-1).cummulative);
               begin=String.valueOf(newBegin);
                newEnd=Double.parseDouble(previousBegin)+((Double.parseDouble(previousEnd)-Double.parseDouble(previousBegin))*list.get(i).cummulative);
               end=String.valueOf(newEnd);
          }
              
      }
      
        System.out.println((int)newEnd);
        
        double en=newEnd;
        double bg=newBegin;
        boolean inRange=false;
        while(!inRange){
      while((int)newEnd!=1){
          newEnd=2*newEnd;
          Code+=(int)newEnd;
      }
      double sum=0;
      for(int i=2;i<Code.length();i++){
         sum+= Double.parseDouble(String.valueOf(Code.charAt(i)))*Math.pow(2, -(i-1));
      }
      
      if(sum>=bg&&sum<=en){
         inRange=true; 
      }else{
          String nn=String.valueOf(newEnd);
         String kk= nn.replaceFirst(String.valueOf(nn.charAt(0)),"0");
          newEnd=Double.parseDouble(kk);
      }
          
        }
        System.out.println(Code);
        g.drawString("Code : "+Code, 800, 500);
        printFile();
    }
    public void printFile(){
                try {
            FileWriter fw=new FileWriter("E:\\MultiMediaProject\\Arthematic.txt");
            BufferedWriter bfw=new BufferedWriter(fw);
            bfw.write(Code);
            bfw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ArithmeticCompress.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(643, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("C:\\Users\\Mo7amed\\Pictures\\MultiMedia_Project_1\\Arthematic.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShannonCompress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShannonCompress.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        float sum=0;
      for(int i=2;i<line.length();i++){
          
         sum+= Double.parseDouble(String.valueOf(Code.charAt(i)))*Math.pow(2, -(i-1));
      }
      
      Arithmatic_deCompression decom= new Arithmatic_deCompression((float)sum);
       String x= decom.ouuut;
       
      new ArithematicTable(word).setVisible(true);
        //System.out.println("tom"+line.length()+"");
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("C:\\Users\\Mo7amed\\Pictures\\MultiMedia_Project_1\\Arthematic.txt");
            BufferedReader bfr=new BufferedReader(fr);
            line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        double t=(double)((((word.length()*8)-(double)(line.length()-2))/(double)word.length())*100);
        jTextField1.setText(t+"");
        System.out.println("koo"+(line.length()-2)+"");
        System.out.println("kkjk"+t);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(ArithmeticCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArithmeticCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArithmeticCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArithmeticCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArithmeticCompress(word).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
