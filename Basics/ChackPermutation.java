/* Q: 1.2: Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

Solution: We should confirm some details with our interviewr. We should understand if the permutation comparison is case sensitive. That is; is Good a permutation of dog? Additionally,
          we should ask if whitespace is significant. We will assume for this problem that the comparison is case sensitive and whitespace is 
          significant. So, "god   " is different from "dog".

          Observe first that strings of different lengths cannot be permutations of each other. There are two easy ways to solve this problem, both of which use this optimization.
*/
public class ChackPermutation{
    // Solution #1 : Sort the strings.
    /**
     *  If two string are permutations, then we know they have the same characters, but in different orders.These for,sorting the string will put the characters from two permutations in teh same order.
     *  We just need to compare teh sorted versions of the strings.
     */

    static String Sort(String str){
        char[] content = str.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    static boolean permutation(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        return Sort(s).equals(Sort(t));
    }

    public static void main(String[] args){

        // System.out.println(permutation("dog","god")); true
        System.out.println()

    }
}