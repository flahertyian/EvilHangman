//https://github.com/flahertyian/EvilHangman/

import java.util.*;

public class HangmanManager{

   private int length;
   private int max;
   private List<String> dictionary;
   private TreeMap<String,Set<String>> word;
   private String pattern;
   private SortedSet<Character> guesses;
   
   public HangmanManager(List<String> dictionary, int length, int max){
      this.length = length;
      this.max = max;
      updateDictionary();
      //populateMap();
      
   }
   
   public Set<String> words(){
      return word.get(pattern);
   }
   
   public int guessesLeft(){
      return max;
   }
   
   public SortedSet<Character> guesses(){
      return guesses;
   }
   
   public String pattern(){
   
   }
   
   //subtract from max after every wrong guesses
   public int record(char guess){
      guesses.add(guess);
         
      
   }
   
   private void updatePattern(){
      //use another data strucutre to filter everything out first before putting it into a map
   }
   
  
      
//    private void populateMap(){
//       String key = "";
//       for(int x=0; x<length ; x++){
//          key += "-";
//       }
//       Set<String> match = new Set<String>();
//       for(String s: dictionary){
//          if(s.length == length){
//             match.add(s);      
//          }
//       }
//       word.put(key, match);
//    }
//   
   private void updateDictionary(){
      for(String s: dictionary){
         if(s.length != length){
            dictionary.remove(s);
         }
      }
   } 
}