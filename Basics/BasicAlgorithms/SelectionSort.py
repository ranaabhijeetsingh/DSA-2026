"""
# Step 1: We have an unsorted array of numbers that we want to sort in ascending order. Let's say we have the following array:
my_array = [ 7, 12, 9, 11, 3]
# Step 2: Go though the array, one value at a time, Which value is the lowest? In this case, the lowest value is 3.
#
# Step 3: We will place it at the beginning of the sorted portion. The array now looks like this:
# [ 3,  7, 12, 9, 11,]
#
#Step 4: Look through the rest of the values, starting with 7. 7 is the lowest value, and already at the front of the array, so we don't need to move it.
# [ 3,  7, 12, 9, 11,]
#
#Step 5: Look through the rest of the array: 12, 9 and 11. 9 is the lowest value.
# [ 3, 7, 12, 9, 11]
#
#Step 6: Move 9 to the front.
#[ 3, 7, 9, 12, 11]
#
#Step 7: Looking at 12 and 11, 11 is the lowest.
# [ 3, 7, 9, 12, 11]

# Step 8: Move it to the front.
# [ 3, 7, 9, 11, 12]

# Finally, the array is sorted.
``````````````````````````````````````````````````````````````````````````````````````````````````````````````
To implement the Selection Sort algorithm in a programming language, we need:

# An array with values to sort.
# An inner loop that goes through the array, finds the lowest value, and moves it to the front of the array. This loop must loop through one less value each time it runs.
# An outer loop that controls how many times the inner loop must run. For an array with 
# n
#  values, this outer loop must run 
# n
# −
# 1
#  times.
# The resulting code looks like this:
"""
print("Selection Sort Algorithm: Enter the values to sort in the array:")
my_array = [ 3, 7, 9, 11, 12]

n = len(my_array)
for i in range(n-1):
    min_index = i
    for j in range(i+1, n):
        if my_array[j] < my_array[min_index]:
            min_index = j
    min_value = my_array.pop(min_index)
    my_array.insert(i, min_value)

print("Sorted array is:", my_array)
# but there is the problem of shifting and 