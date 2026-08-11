   
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

         Time complexcity: O(n)
         Space complexcity: O(1)
         You could express the complexcity as O(c) spaceand O(min(Cj n)) or O(c) time, where c is the size of the character set.

         We can reduce our space usage by a factor of eight by using a bit vector. We will assume, in the below code,
         that the string only uses the lowercase letters a through z. This will allow us to use just a single int .

         boolean
        
*/
public class Main{

    static boolean isUniqueCahrs(String str) {
        if (str == null || str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                // already found this char in string
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

// Optimize version
    static boolean isUniqueCahrs(String str){
        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val  = str.charAt(i) - a;
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker != (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueCahrs("world"));
    }
}