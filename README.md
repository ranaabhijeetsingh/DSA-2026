# DSA-2026: Data Structures & Algorithms

## 📚 Overview
A comprehensive collection of **Basic to Advanced DSA problems** with detailed solutions in **Java**. Each problem includes:
- ✅ Brute Force approach
- ✅ Optimized solutions
- ✅ Time & Space complexity analysis
- ✅ Real-world use cases

Perfect for beginners building solid DSA foundations and for professionals preparing for technical interviews.

---

## 📖 Repository Structure

### 1. Array & String
#### Q 1.4: Palindrome Permutation
**Problem:** Given a string, write a function to check if it is a permutation of a palindrome.

**Concepts:**
- A palindrome is a word or phrase that reads the same forwards and backwards
- A permutation is a rearrangement of letters
- The palindrome does not need to be limited to dictionary words

**Solutions:**
- Brute Force Approach
- Optimized Approach using HashMap
- Space-Efficient Approach using BitSet
[visit overview 1.4:  palindromePermutation](https://www.google.com/search?sca_esv=2fbc8fd622ef6d70&rlz=1C1CHBF_enIN1133IN1133&biw=1920&bih=953&sxsrf=APpeQntOQ2zWmzmAkE6cDT52t-rZenYrLw:1786925208835&q=real+world+implementation+of+the+dsa+question+how+it+help+for+java+Engineer.+1.4+Palindrome+Permutation:+Given+a+string,+write+a+function+to+check+if+it+is+a+permutation+of+a+palindrome.+A+palindrome+is+a+word+or+phase+that+is+the+same+forwards+and+backwards,+*+A+Permutation+is+a+rearrangement+of+letters.+The+palindrome+does+not+need+to+be+limited+to+just+dictionary+words.&spell=1&sa=X&ved=2ahUKEwiE-r-Sr6aWAxXbcmwGHaeeMuMQkeECKAB6BAgQEAE)


### 1. Array & String
#### Q 1.5: One Away
**Problem:** There are three types of edits that can be performed on Strings: insert a character, remove acharaceter, or replace a character,or replace a character.
Given twwo strings, write afunction to check if they are one edit(or zero edit) away.
e.g: pale, pie -> true
     pales, pale -> true
     pale, bale -> true
     pale, bae -> false

**Real-World Applications:**
- Spell Checkers & Autocorrect: When you type "teh", standard spell-checking algorithms calculate edit distances to suggest "the" or automatically fix single-character typos (insertions, deletions, or substitutions) instantly without heavy processing.

- Search Engine "Did You Mean?" Prompts: Search engines use edit distance to catch search typos (e.g., searching "Gogole" brings up results for "Google").

- Bioinformatics & DNA Sequencing: Genomic sequence alignment measures differences in DNA base pairs ($A, T, C, G$). Determining single-nucleotide mutations or single-letter sequence insertions/deletions helps identify genetic variations and diseases.
- Data Cleansing & Deduplication: When importing customer datasets, companies match records with small typos (e.g., matching "Jon Smith" with "John Smith" or "Street" vs. "St") to prevent duplicate accounts.
- Version Control & File Diffing: Tools like git diff rely on string editing algorithms (like Levenshtein or Myers diff) to highlight inserted, deleted, or modified lines of code.

**How Learning This Benefits You**
- Optimized Problem Solving (O(N) Efficiency): Instead of building a full $O(N \times M)$ Dynamic Programming matrix meant for general Levenshtein distance, you learn to solve a specific constraint ($\le 1$ edit) in a single pass ($O(N)$ time and $O(1)$ space) using two pointers.
- Handling Edge Cases: It teaches you systematic boundary checking—such as immediately returning False if string lengths differ by more than 1 character.
- Core Interview Readiness: This classic coding interview problem tests whether you can write clean code for multiple conditional paths (insertion vs. substitution) without repeating yourself.

Here is the production-ready implementation of the One Away problem in Java, maintaining $O(N)$ time complexity and $O(1)$ space complexity.

```java

public class OneAway {

    public static boolean isOneAway(String first, String second) {
        // 1. Quick check: If length difference > 1, return false
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // Ensure s1 is always the shorter (or equal length) string
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // Second mismatch means > 1 edit is required
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (s1.length() == s2.length()) {
                    // Case A: Strings are equal length -> Replacement
                    index1++;
                    index2++;
                } else {
                    // Case B: Strings differ in length -> Insertion / Deletion
                    // Skip the mismatched character in the longer string (s2)
                    index2++;
                }
            } else {
                // Matching characters -> advance both pointers
                index1++;
                index2++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(isOneAway("pale", "ple"));   // true  (Deletion)
        System.out.println(isOneAway("pales", "pale")); // true  (Insertion)
        System.out.println(isOneAway("pale", "bale"));  // true  (Replacement)
        System.out.println(isOneAway("pale", "bake"));  // false (Two edits)
    }
}

```
```python
# Here is the  production-ready Python implementation for the One Away Problem to run in
# 
# O(N) time and 
# O(1) space.
#
def is_one_away(s1: str, s2: str) -> bool:
    # 1. Quick Check: If length difference > 1, impossible to fix in 1 edit
    if abs(len(s1) - len(s2)) > 1:
        return False

    # Ensure s1 is always the shorter (or equal length) string
    if len(s1) > len(s2):
        s1, s2 = s2, s1

    index1 = 0
    index2 = 0
    found_difference = False

    while index1 < len(s1) and index2 < len(s2):
        if s1[index1] != s2[index2]:
            # If we already found one mismatch, a second means > 1 edit is needed
            if found_difference:
                return False
            found_difference = True

            # Case A: Strings are equal length -> Replacement
            if len(s1) == len(s2):
                index1 += 1
                index2 += 1
            # Case B: Strings differ in length -> Insertion into s1 / Deletion from s2
            else:
                index2 += 1  # Skip mismatch in the longer string (s2)
        else:
            # Characters match, advance both pointers
            index1 += 1
            index2 += 1

    return True


# Test Cases
print(is_one_away("pale", "ple"))    # True  (Deletion)
print(is_one_away("pales", "pale"))  # True  (Insertion)
print(is_one_away("pale", "bale"))   # True  (Replacement)
print(is_one_away("pale", "bake"))   # False (Two replacements needed)


```