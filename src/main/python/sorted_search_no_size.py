# 10.4 Sorted Search, No Size
# 6/27/20

# Listy data structure w/ no size method

# given sorted list
def sorted_search(l, x):
    # ID lower bound at start
    lower = 0
    # jump to biggest pwr 2 (^^32) to get upper upper bound
    upper = 2^32
    # double the index (binary search) to get upper if not big enough
    # if out of bound, jump instead half that much (middle)
    while list[upper] == -1: 
        upper = upper / 2
    # if in bounds and < x, jump half until > x and in bounds
    while list[upper] < x: 
        upper += upper / 2
        if list[upper] == -1: 

    # if in bounds and > x, have upper bound; binary search 
    binary_search(x, lower, upper, l)


def binary_search(x, lower, upper, l):
