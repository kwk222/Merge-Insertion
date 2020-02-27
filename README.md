# Merge-Insertion

Created a sorting algorithm, combining both Merge and Insertion sort. An Array is first partitioned via Merge Sort, and if the size of a sub-array falls below some value, it uses insertion sort. Finally, the sub-arrays are combined into a sorted array. 

After testing numerous values for the size when insertion sort is called, it seems like 32 is the ideal size, though might need to test it more
