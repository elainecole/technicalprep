# 10.8 Find Duplicates 
# 7/18/20

def find_dups(arr): 
    for i in range(1, len(arr)):
        if arr[i] == arr[i - 1]:        
            print(arr[i], end =" ") 
    print()

# merge sort
def merge_sort(arr): 
    if len(arr) > 1: 
        mid = len(arr) // 2 # Finding the mid of the array 
        L = arr[:mid] # Dividing the array elements  
        R = arr[mid:] # into 2 halves 
  
        merge_sort(L) # Sorting the first half 
        merge_sort(R) # Sorting the second half 
  
        i = j = k = 0
          
        # Copy data to temp arrays L[] and R[] 
        while i < len(L) and j < len(R): 
            if L[i] < R[j]: 
                arr[k] = L[i] 
                i += 1
            else: 
                arr[k] = R[j] 
                j += 1
            k += 1
          
        # Checking if any element was left 
        while i < len(L): 
            arr[k] = L[i] 
            i += 1
            k += 1
          
        while j < len(R): 
            arr[k] = R[j] 
            j += 1
            k += 1
  
# Code to print the list 
def printList(arr): 
    for i in range(len(arr)):         
        print(arr[i], end =" ") 
    print() 
  
# book solution: 
# use bit vector with 32000 bits where each bit represents one integer 
bit_mask = [0] * 4

def mark_bit(i, bit_mask): 
    # set appropriate index in bit mask 
    index = int((i - 1) / 32)
    # set appropriate bit within index
    bit_num = i % 32
    # find int
    # mark bit
    print("bit mask: " + str(bit_mask) + " index: " + str(index) + " bit num: " + str(bit_num))

    bit_mask[index] = bit_mask[index] | (1 << (bit_num - 1))

def find_duplicates(input): 
    global bit_mask

    # go through input file once, marking bit for each number found
    for i in input: 
        mark_bit(i, bit_mask)
    # find the 0 within bit mask -> output number associated 
    print(bit_mask)
    index = 0
    while index < len(bit_mask):
        if bit_mask[index] != 0xfffffffff:
            bit_index = 1
            while bit_index < 33: 
                if (bit_mask[index] & (1 << (bit_index - 1))) == 0: 
                    # know bit_index and index
                    print("bit mask: " + str(bit_mask) + " index: " + str(index) + " bit num: " + str(bit_index))
                    print("index " + str(bit_mask[index]))
                    return index * 32 + bit_index
                bit_index += 1
        index += 1
    


# driver code to test the above code 
if __name__ == '__main__': 
    arr = [12, 11, 3, 6, 3, 3, 13, 5, 6, 7]  
    print ("Given array is", end ="\n")  
    printList(arr) 
    merge_sort(arr) 
    print("Sorted array is: ", end ="\n") 
    printList(arr) 
    find_dups(arr)
    arr = [12, 11, 3, 6, 3, 3, 13, 5, 6, 7]  
    find_duplicates(arr)
    printList(arr)
