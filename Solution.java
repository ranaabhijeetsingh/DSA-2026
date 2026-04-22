
import java.util.*;
public class Solution {

     public static boolean containsDuplicate(int[] nums) {
//        Create a hasset to store the elements from the array
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                System.out.println("Duplicate Element of Your Given array: " + nums[i]);
                return true;
                // Duplicate element are Found
            }
//            Add the element to the Hashset
            set.add(nums[i]);
        }
        System.out.println("No duplicates");
        return false;
    }
    static void main(String [] args) {
        System.out.println("This is Question 1: Find out the element which are duplicate in the given array ");
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the demo Array");
        System.out.println("First Enter the Size of Your Array: ");
        int number = sc.nextInt();

        int nums[] = new int[number];

        System.out.println("Keep it mind String position will be 0: Please Enter the elements: ");
        for (int i = 0; i <number; i++) {
             nums[i] = sc.nextInt();
        }
        System.out.println("Your Entered Elements are: ");
        for (int i = 0; i <number; i++) {
            System.out.println(nums[i]+" ");
        }
        System.out.println("Here is Solution Of Your Array: "+ containsDuplicate(nums));
    }
}