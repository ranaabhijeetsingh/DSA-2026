/*
    1.3 : URLify: Write a method to replace all spaces in a string with '%20' You may assume that the string
    has sufficient space at the end to hold the additional characters, and that You given the 'true'
    length of the string.(Note: if implementing in java, Please use a character array so that you can perform this operation in place.)

    Example:
    input:    "Mr John Smith"
    output:   "Mr%20John%20Smith"

    Solution: 
    A common approach in string manipulation problems is to edit the string starting from the dend and working
    backworkds. This is useful because we have an extra buffer at the end, which allows to change characters without worrying about what we're overwriting.

    We will use this approach in this problem.The algorithm emplpys a two-scan approach. In the first scan, we count the numner of spaces. By tripling this number, we can compute how many extra characters we will have in the final string. In the second pass, which Is done in reverse order, we actually
    edit the string. When we see a space, we replace it with %20.If there is no space, then we copy the original character.

    The below implements this algorithm.
*/

/**
 * URLify: Replace spaces with '%20' in a string (in-place operation)
 * 
 * ALGORITHM EXPLANATION:
 * =====================
 * This solution uses a TWO-PASS REVERSE APPROACH:
 * 
 * Pass 1 (Forward): Count total spaces in the string
 *   - Each space requires 2 extra characters (%20 instead of space)
 *   - Calculate final string length: trueLength + (spaceCount * 2)
 * 
 * Pass 2 (Backward): Fill from the END going backwards
 *   - Start from the end of the original string and work backwards
 *   - Why backwards? To avoid overwriting characters we haven't processed yet
 *   - When space found: write %20 in reverse order ('0', '2', '%')
 *   - When non-space found: copy character as-is
 *   - Decrement index pointer accordingly
 * 
 * TIME COMPLEXITY: O(n) - two passes through the string
 * SPACE COMPLEXITY: O(1) - in-place modification, no extra space needed
 * 
 * REAL-WORLD APPLICATIONS:
 * ========================
 * 1. URL ENCODING: Web browsers encode spaces in URLs as %20
 *    Example: "hello world" → "hello%20world"
 * 
 * 2. PATH HANDLING: File systems need to encode spaces in filenames
 *    Example: "My Document.pdf" → "My%20Document.pdf"
 * 
 * 3. HTML/FORM SUBMISSION: Web forms encode user input
 *    Example: "John Smith" in name field → "John%20Smith"
 * 
 * 4. API QUERY PARAMETERS: REST APIs encode query strings
 *    Example: Search query "machine learning" → "machine%20learning"
 * 
 * 5. EMAIL/PROTOCOL ENCODING: Mail clients encode special characters
 *    Example: Subject line spaces → %20 in headers
 * 
 * BEHIND THE SCENES:
 * ==================
 * - Why not just replace left-to-right? Because each space becomes 3 chars,
 *   it would overwrite unreplaced characters to the right.
 * 
 * - Why reverse iteration? Working backwards with a pre-allocated buffer prevents
 *   data loss. We know exactly where final string ends, so no collision.
 * 
 * - Key Insight: This is fundamental in competitive programming (CtCI problem).
 *   Tests understanding of: in-place algorithms, reverse iteration, space management,
 *   and efficient string manipulation without using built-in methods.
 * 
 * - Buffer Management: Pre-allocate space at the end (given in problem).
 *   This is crucial - we need exact space for all %20 replacements.
 */
public class URLify{

    /**
     * Replaces all spaces in a character array with '%20' in-place
     * 
     * @param str The character array with sufficient space at the end
     * @param trueLength The actual length of the string (excluding padding)
     */
    static void replaceSpaces(char[] str, int trueLength){
        // PASS 1: Count spaces
        int spaceCount = 0, index, i = 0;
        for(i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        
        // Calculate final index where new string will end
        // Each space (1 char) becomes %20 (3 chars), so +2 extra chars per space
        index = trueLength + spaceCount * 2;
        
        // Mark end of array with null terminator
        if(trueLength < str.length) str[trueLength] = '\0';
        
        // PASS 2: Work backwards from end to beginning
        for(i = trueLength - 1; i >= 0; i--){
            if(str[i] == ' '){
                // Replace space with %20 (written in reverse: 0, 2, %)
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                // Copy non-space character to new position
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args){
        String input = "Mr Rana";
        // Calculate required buffer: original length + (2 extra chars per space)
        char[] str = new char[input.length() + (input.split(" ", -1).length - 1) * 2];
        System.arraycopy(input.toCharArray(), 0, str, 0, input.length());
        
        URLify urlify = new URLify();
        urlify.replaceSpaces(str, input.length());
        System.out.println(new String(str).trim());
        
    }
}