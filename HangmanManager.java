//https://github.com/flahertyian/EvilHangman/

import java.util.*;

public class HangmanManager{

   	private int length;
   	private int max;
   	private List<String> dictionary;
   	private Map<String,Set<String>> word;
   	private String pattern;
   	private SortedSet<Character> guesses;
   
   	public HangmanManager(List<String> dictionary, int length, int max){
      	this.length = length;
      	this.max = max;
        this.dictionary = dictionary;
        initMap();
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
      	int count = 0;
        guesses.add(guess);
        updateMap(guess);
        pattern = compareSize();
        for(int x = 0 ; x < length; x++){
            if(pattern.charAt(x) != '-'){
               count++;
            }  
        } 
        return count;       
   	}


   	private void updateMap(char g){
		//I think this might acthualy work!!!!!
   		for(String s: dictionary){
   		   if(s.length() == length){
               String tempPattern = "";
      			for(int x=0; x< s.length(); x++){
      				if(s.charAt(x) == g){
      					tempPattern+="g";
      				}else{
      					tempPattern+="-";
      				}
      			}
      			if(!word.containsKey(tempPattern)){
      				word.put(tempPattern, new TreeSet<String>());
      			}
      			word.get(tempPattern).add(s);
            }
   		}

   	}
   
    private String compareSize(){
        int biggestSize = 0;
        String biggestKey="";
        for(String key : word.keySet()){
            int size=0;
            for(String s : word.get(key)){
               size++;              
            }
            if(size>biggestSize){
               biggestKey=key;
            }
        }
        return biggestKey;
      }
      
//    	private void initDictionary(){
//       	for(String s: dictionary){
//          	if(s.length() != length){
//             	dictionary.remove(s);
//          	}
//       	}
//    	} 

//          private void initDictionary(){
//         
//             for(int x = 0; x < dictionary.size() ; x++){
//                if(dictionary.get(x).length() != length){
//                   dictionary.remove(x);
//                   
//                }
//             }
//          
//          }
    private void initMap(){
       word = new TreeMap<String, Set<String>>();
       String temp = "";
       for(int y = 0 ; y < length; y++){
          temp += "-";
       }
       Set<String> value = new TreeSet<String>();
       for(int x = 0; x < dictionary.size(); x++){
          if(dictionary.get(x).length() == length){
            value.add(dictionary.get(x));
             
          }
       }
       word.put(temp,value);
       pattern = temp;
    }
}