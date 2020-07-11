# 10.3 Search in Rotated Array
# 6/27/20

def search_in_rotated_array(e, arr): 
    # get first, last, and middle of array 
    first = 0
    last = len(arr) - 1
    middle = len(arr) // 2
    # find upper and lower bounds
    # find lower bound via first
    if arr[first] < e: 
        # first is lower
        lower = first
        # find upper: 
        upper = -1
        # check middle
        while upper < lower:
            middle = (first + last) // 2
            if middle == first or middle == last: 
                return -1
            # case 1: first < middle < e
            if arr[first] < arr[middle] and arr[middle] < e: 
                # new lower, still need upper
                lower = middle
                first = middle
            # case 2: first < e < middle
            elif e < arr[middle]: 
                # found upper
                upper = middle
            # case 3: middle < first < e
            elif arr[middle] < arr[first]: 
                # upper is somewhere between middle and first
                last = middle
                # repeat cases
            # case 4: middle = e
            elif e == arr[middle]: 
                return middle
            else: 
                return -1
        if upper == lower: 
            # won't succeed in binary search
            return -1
    else: 
        # first not lower; right side
        upper = last
        # find lower 
        lower = upper + 1
        # repeatedly until upper = lower or find upper
        while lower > upper: 
            middle = (first + last) // 2
            if middle == first or middle == last: 
                return -1
            # case 1: middle < e < last
            if arr[middle] < e and e < arr[last]:
                # found lower
                lower = middle
            # case 2: e < middle < last
            elif e < arr[middle] and arr[middle] < arr[last]: 
                # found better upper, still need lower
                upper = middle
                last = middle
            # case 3: e < last < middle
            elif e < arr[last] and arr[last] < arr[middle]:
                # lower somewhere between middle and upper
                first = middle
                # repeat cases
            # case 4: e = middle
            elif e == arr[middle]: 
                return middle
            else: 
                return -1
        if upper == lower: 
            # won't succeed in binary search
            return -1

    print(lower)
    print(upper)
    # binary search on upper / lower 

a = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14]
print(search_in_rotated_array(20, a))