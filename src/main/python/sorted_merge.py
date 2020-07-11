# 10.1 Sorted Merge
# 6/25/20

# sorted_merge: array A, B
def sorted_merge(a, b): 
    a.extend(b)
    mergesort(a)

# mergesort: array A
def mergesort(a):
    if len(a) >1:  
        mid = len(a) // 2
        L = a[:mid]
        R = a[mid:]

        mergesort(L)
        mergesort(R)

        i = j = k = 0

        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                a[k] = L[i]
                i += 1
            else: 
                a[k] = R[j]
                j += 1
            k +=1

        while i < len(L):
            a[k] = L[i]
            i += 1
            k += 1
        
        while j < len(R):
            a[k] = R[j]
            j += 1
            k += 1
    

a = [1, 2, 3, 4, 5]
b = [2, 4, 6, 8]
print("array A is: ", a) 
print("array B is: ", b) 
sorted_merge(a, b)
print("Sorted merge array is: ", a) 
