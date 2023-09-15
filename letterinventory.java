// Zacharia Kornas
// TA: Kent Zeng
// The LetterInventory takes in a string and stores how
// many of each letter appear in the string
import java.util.*;

public class LetterInventory {
   
   public static final int LETTER_CAPACITY = 26; // Sets the capacity of
                                                 // the LetterInventory
   
   private int[] numLetter;
   private int size;
   
   // Constructs an empty LetterInventory
   public LetterInventory(){
      this("");
   }
   
   // Constructs a new LetterInventory of string data.
   // Parameters:
   //    data - the string that the client wants a letter inventory of
   //           Will store each letter in data as lowercase in LetterInventory
   //           regardless of capitalization.
   public LetterInventory(String data){
      numLetter = new int[LETTER_CAPACITY];
      size = 0;
      for(int i = 0; i < data.length(); i++){
         char ch = data.charAt(i);
         ch = Character.toLowerCase(ch);
         if('a' <= ch && ch <= 'z'){ 
            numLetter[ch - 'a'] += 1;
            size++;
         }
      }
   }
   
   // Gets the count of a specific letter in the LetterInventory
   // Throws an IllegalArgumentException if the given letter is
   // not an English letter from the alphabet
   // Returns the count of the specific letter
   // Parameters:
   //    letter - the letter that the client wants a count of. Will ignore
   //             capitalization.
   public int get(char letter){
      letter = Character.toLowerCase(letter);
      if(letter < 'a' || letter > 'z'){
         throw new IllegalArgumentException();
      }  
      letter = Character.toLowerCase(letter);
      int letterCount = numLetter[letter - 'a'];
      return letterCount;
   }

   // Sets the count of a specific letter in the LetterInventory to
   // the value passed in by the user
   // Throws an IllegalArgumentException if the given letter is
   // not an English letter from the alphabet or if the value passed is less
   // than zero.
   // Parameters:
   //    letter - the letter that the client wants to change the value of.
   //             Ignores capitalization.
   //    value - the value that the client wants to change the letter to
   public void set(char letter, int value){
      letter = Character.toLowerCase(letter);
      if(letter < 'a' || letter > 'z' || value < 0) {
         throw new IllegalArgumentException();
      }
      size -= numLetter[letter - 'a'];;
      numLetter[letter - 'a'] = value;
      size += numLetter[letter - 'a'];
   }
   
   // Allows client to add the content of two separate letter inventories
   // Returns a new LetterInventory combinedInventory which is the sum
   // of the two LetterInventories. Adds the LetterInventories together
   // regardless of capitalization. 
   // Parameters:
   //    other - the second LetterInventory that the client wants to add to the
   //            original LetterInventory
   public LetterInventory add(LetterInventory other){
      LetterInventory combinedInventory = new LetterInventory();
      for(int i = 0; i < LETTER_CAPACITY; i ++){
         combinedInventory.numLetter[i] += this.numLetter[i] + other.numLetter[i];
      }
      combinedInventory.size = this.size + other.size;
      return combinedInventory;
   }
   
   // Allows client to subtract the content of one LetterInventory from another
   // Will ignore capitalization of each letter when subtracting them.
   // Returns a new LetterInventory of the sum of the two LetterInventories
   // Parameters:
   //    other - the LetterInventory that will be subtracted from the original
   //            LetterInventory
   public LetterInventory subtract(LetterInventory other){
      LetterInventory subtractedInventory = new LetterInventory();
      for(int i = 0; i < LETTER_CAPACITY; i ++){
         subtractedInventory.numLetter[i] += this.numLetter[i] - other.numLetter[i];
         if(subtractedInventory.numLetter[i] < 0) {
            return null;
         }
         subtractedInventory.size += subtractedInventory.numLetter[i];
      }
      return subtractedInventory;
   }
   
   // Checks if the LetterInventory is empty or not
   // Returns true if empty and false if not empty
   public boolean isEmpty(){
      return(size == 0);
   }
   
   // Checks the size of the LetterInventory, which is
   // The sum of all characters in the LetterInventory
   // Returns the size of the Letter Inventory
   public int size(){
      return size;
   }
   
   // Creates a string of the content of the LetterInventory
   // Returns the LetterInventory as a readable string
   // which can be printed to the console
   public String toString(){
      String letterString = "";
      for(int i = 0; i < LETTER_CAPACITY; i++){
         char ch = (char)('a' + i);
         for(int j = 1; j <= numLetter[i]; j++){
            letterString = letterString + ch;
         }
      }
      return "[" + letterString + "]";
   }

}
