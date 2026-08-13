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

public class URLify{

    void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0, index, i = 0;
        for(i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if(trueLength < str.length) str[trueLength] = '\0'; // End array
        for(i = trueLength - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Hello world");
        replaceSpaces(tim devid );

    }
}