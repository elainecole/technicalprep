# 1.2 Check Permutation 
# 7/11/20

def check_permutation(a, b):
    alphabet_a = {letter: 0 for letter in set('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    alphabet_b = {letter: 0 for letter in set('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    # if not same length, can't be permutations
    if (len(a) != len(b)):
        return False
    # go through string a
    for c in a: 
        # capitalize it if valid
        if c.isalpha():
            c = c.capitalize()
            # add # of char in array 
            alphabet_a[c] += 1
    # go through string b
    for c in b: 
        # capitalize it if valid
        if c.isalpha():
            c = c.capitalize()
            # add # of char in array 
            alphabet_b[c] += 1
    for c in alphabet_a:
        # if not same # of ea char
        if alphabet_a[c] != alphabet_b[c]:
            return False
    # have gotten through entire array: permutation
    return True
            

ex_1 = "racecar"
ex_2 = "carrace"
ex_3 = "carraces"
ex_4 = "car"
ex_5 = "rat"
ex_6 = "tar"

print(ex_1 + ", " + ex_2 + ": " + str(check_permutation(ex_1, ex_2)))
print(ex_1 + ", " + ex_3 + ": " + str(check_permutation(ex_1, ex_3)))
print(ex_4 + ", " + ex_5 + ": " + str(check_permutation(ex_4, ex_5)))
print(ex_5 + ", " + ex_6 + ": " + str(check_permutation(ex_5, ex_6)))

