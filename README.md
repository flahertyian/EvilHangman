# EvilHangman
Lab 4 Wcc
Constructor:
	Input: a dictionary word in a List<String> object along with an length int and a max int. 
	Function: makes a hangmanManager object where max is maximum number of wrong guesses, length is the length of the word and list
  is the word. Throws IllegalArgumentException if length < 1 || max < 0 

Words() : 
	no Input
	Function: returns a Set<String> that represent the set of words that match the pattern

guessesLeft() : 
	no Input
	Function: returns an int representing max guesses – wrong guesses.
  
guesses() :
  no Input
  Function: returns a SortedSet of Chars that represent all the guesses made by the user.
  
Pattern() :
	no Input
	Function: returns the current pattern reflecting the guesses made. Throws IllegalStateException if words() == null;
  
Record() :
	Input: char guess representing the letter guess that the user has input
	Function: returns an int representing the number of times the input char appears in the  dictionary. Throws an
  IllegalStateException if guessesLeft() <=0 || words() ==null. Also throws an IllegalArgumentException if words()!=null && char
  guess == “${previousGuess}”.
