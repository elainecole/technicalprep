# Permutations with Dups
# 6/25/20

def permsWithoutDups(s, list):
    for letter in s:
        # if list is empty, put letter into list
        if not list:
            list.append(letter)
        # else: 
        else: 
        #   for each value in list
            listIt = list[:]
            for perm in listIt: 
        #       put letter at in-betweens
        #       for loop to prepend, append, and middle(s)
                i = 0
                while i < len(perm) + 1: 
                    if i == 0: 
                        newString = letter + perm
                        list.append(newString)
                    elif i == len(perm):
                        newString = perm + letter
                        list.append(newString)
                        list.remove(perm)
                    else: 
                        sub1 = perm[0:i]
                        sub2 = perm[i:len(perm)]
                        newString = sub1 + letter + sub2
                        list.append(newString)
                    i += 1
        print(list)

s = ["a", "b", "c", "d"]
it = iter(s)
list = []
permsWithoutDups(it, list)