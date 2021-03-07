
package multimediaproject.Huffman;

import java.util.ArrayList;
import java.util.Scanner;


public class Huffman {
    
     public static String word;
       public static ArrayList<HuffmanNode> list=new ArrayList<>();
       public static ArrayList<String> Letters=new ArrayList<>();
       
       
       
       
        ArrayList<String> WordList=new ArrayList<>();
        ArrayList<Integer> freqList=new ArrayList<>();
        ArrayList<String> SortedList=new ArrayList<>();
        

    public Huffman(String word) {
        this.word = word;
    }
    
    public void run(){
        
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
        
      // freqList.sort(null);
        for (int i = freqList.size()-1; i >= 0; i--) {
            System.out.println(freqList.get(i));
             for (int j = 1; i < WordList.size(); j+=2) {
                    if(freqList.get(i)==Integer.valueOf(WordList.get(j))){
                        if(check(list, WordList.get(j-1))){
                        list.add(new HuffmanNode(Integer.valueOf(WordList.get(j)), WordList.get(j-1), null, null));
                        break;
                        }
                            
                        
                    }
             
              }   
        }
           
        while(list.size()>1){
                int Root=list.get(list.size()-1).freq+list.get(list.size()-2).freq;
                list.get(list.size()-1).c="0";
                list.get(list.size()-2).c="1";
                HuffmanNode node=new HuffmanNode(Root, list.get(list.size()-2), list.get(list.size()-1));
                
                for(int i=0;i<list.size();i++){
                    if(list.get(i).freq<node.freq){
                        list.add(i, node);
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                                break;
                    }
                }
         }
        
       for(int i=0;i<list.size();i++){
           System.out.print(list.get(i).letter+"  ");
       }
                
                new HuffmanTree().setVisible(true);
                new CodesTable().setVisible(true);
        
    }
    
    private static boolean check(ArrayList<HuffmanNode> h, String letter){
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
}
