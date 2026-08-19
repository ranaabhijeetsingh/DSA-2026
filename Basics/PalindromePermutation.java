/**
 *  1.4   PalindromePermutation: Given a string, write a function to check if it  is a permutation of a palindrome. A palindrome is a word or phase that is the same forwards and backwards, 
 *                               A  Permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 *        Example:
 *                  Input: Tact Coa
 *                  Output: True(permutations: "taco cat""atco eta" etc.)
 *      Solution: This is a question where it helps to figure out what is means for string to be a permutation of a palindrome.This is like asking what the "defining features" of such string would be.
 *                A palindrome is a string that is the same forwords and backwords. Therefore, to decide if a string is a permutation of a palindrome, 
 *                we need to know if it can be written such that it's the same forwards and backwards.
 *                What does it take to be able to write a set of characters the same way forwards  and backwords?We need to have an even number of almost all characters, so that half can be on one side
 *                and half can be on the ofter side. At most one character(the middle character) can have and odd count.
 *     For Example, we-know tact coapapa is a permutation of a palinderome because if has two Ts,fourAs, two Cc, two Ps, and one O. That O would be ta center of all passible palindromes.
 *    
 *    :: to be more precise, strings with even length (after remaoving ail non-letter characters) must have all even counts of characters. String of an dd length must have exactly one character with
 *        an odd count. Of course, an "even" string can't have and odd number of exactly one character, otherwise it wouldn't ea an even-length string (an odd number + many even numbers = an odd number).
 *        Likewise, a string with odd length can't have all characters with even count(sum of evens in even). It's therfore sufficient to say that, to be a permutation of a palindrome, a string can have no more than 
 *        one charecter that is odd. This will cover both tha odd and thee even cases.
 *  This leads us to our first algorithm.
 *
 *  
 * 
 * Real world Applications:
 * 
 * In real world The "Palindrome Permutation" problem maps directly to data cleaning, cryptography, and bio-informatics. The core logic check if a dataset can be arranged symmentrically 
 * by verifying that at most one character has an odd frequency.
 * 
 * Data Deduplicatino & anonymization: 
 *                                      Identifying user-generated text inputs that are structurelly identical despite cahracter reordering.
 * Bioinformatics(DNA Sequesce Analysis):
 *                                       Detecting inverted repeats or Palindromic molecular structures in genetic ssequenses, which  indecate specific binding site.
 * Text Analytics & Natural Language Processing(NLP): Standerdizing serch queries or processing text where latter order is scramled but composition matters
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *   
 * */




// Solution #1
// Implementing this algorithm is fairly straightforward. We use a hash table to count how many times each character appears. Then, we iterate through teh hase table and ensure that no more one character has an odd count.


public class PalindromePermutation{

    /** Check that no more than one character has an odd count. */
    static boolean checkMaxOneOdd(int[] table){
        boolean foundOdd = false;
        for(int count : table){
            if(count % 2 == 1){
                if (foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /** Map each character to a number a >> 0, b>>1, c>>2 etc.
     *  This is case insensitive. Non-letter characters map to -1.
     */
    static int getCharNumber(char c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z){
            return val - a;
        } 
        return -1;
    }

    /** Count how many times each character appears.
     *  This algorithm takes O(N) time, where N is the length of the string.
     */
    static int[] buildCharFrequencyTable(String phrase){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }
        return table;
    }

    static boolean isPermutationOfPalindrome(String phrase){
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }


// Solution #2 We can't optimize the bigO time here since any algorithm will always have to look through the entire string.
// However, we can make some smaller incremental improvements. Because this is a relatively simple problem.
//  It can be worthwhile to discuss some small optimizations or at least some tweaks.
// Instead of checking the number of odd counts at the end, we can check as we go along.Then, as soon as we get to the end , we have our answer.

static boolean isPermutationOfPalindromeOptimized(String phrase){
    int countOdd = 0;
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

    for(char c: phrase.toCharArray()){
        int x = getCharNumber(c);
        if(x != -1){
            table[x]++;
            if(table[x]%2 ==1){
                countOdd++;
            }else{
                countOdd--;
            }
        }
        
    }
    
}
    public static void main(String[] args){
        System.out.println("palindromePermutation");

        String test1 = "Tact Coa";
        String test2 = "abccccdd";
        String test3 = "a";
        
        System.out.println("\"" + test1 + "\" is permutation of palindrome: " + isPermutationOfPalindrome(test1));
        System.out.println("\"" + test2 + "\" is permutation of palindrome: " + isPermutationOfPalindrome(test2));
        System.out.println("\"" + test3 + "\" is permutation of palindrome: " + isPermutationOfPalindrome(test3));
    }
}