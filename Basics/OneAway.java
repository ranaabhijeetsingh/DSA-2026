public class OneAway{
    public static boolean isOneAway( String first, String second){
        // Quick check: If length difference > 1, return false
        if(Math.abs(first.lenght() - second.length()) > 1){
            return false;
        }
        // Ensure s1 is always the shorter (or equal length) string

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.lenght() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        
    }
}