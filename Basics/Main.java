import java.util.*;

    
/* 
    Note: This questions are inherited for book Creacking the coding interview for only learning purpose.
   1.1   Is Unique: Implement an algorithm to determine if a string has all unique characters.What if you
         cananot use additional data structure.

         Solution :
         One solution is to create an array of boolean values, where the flag at index i indicates whether character
         i in the alphabet is contained in the string. The second time you see this character you can immediately return false.

         We can also immideately return false if the string length exceeds the number of unique characters in the 
         alphabet. After all, you can't form a string of 280 unique characters out of a 128-character alphabet.

         It's also okay to assume 256 characters. This would be the case in extended ASCII. You should clarify your assumptions with your interviewr.
        
*/
public class Main{

    boolean isUniqueCahrs(String str){
        if(str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            if(char_set[val]){
                // already fount this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    public static void main(String []args){

       

    }
}