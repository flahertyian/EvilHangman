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
      	initDictionary();
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
   		return pattern;
   	}
   
   //subtract from max after every wrong guesses
   	public int record(char guess){
      	guesses.add(guess);
        updateMap(guess);
        return 0; //temp return statement to make it compile :)
      
   	}


   	private void updateMap(char g){
		//I think this might acthualy work!!!!!
   		for(String s: dictionary){
   			String tempPattern = "";
   			for(int x=0; x< s.length(); x++){
   				if(s.charAt(x) == g){
   					tempPattern+="g";
   				}else{
   					tempPattern+="-";
   				}
   			}
   			if(!word.containsKey(tempPattern)){
   				word.put(tempPattern, new HashSet<String>());
   			}
   			word.get(tempPattern).add(s);

   		}
   		//Github Testaroni

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
   	private void initDictionary(){
      	for(String s: dictionary){ // <-- currentaly throwing null pointer here
         	if(s.length() != length){
            	dictionary.remove(s);
         	}
      	}
   	} 
}