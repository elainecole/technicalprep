# 1.4 Palindrome Permutation
# 6/26/20

def palindrome_perm(s):
    alphabet = {letter: 0 for letter in set('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    letter_len = 0
    for c in s:
        if c.isalpha():
            c = c.capitalize()
            letter_len += 1
            alphabet[c] += 1
    if letter_len % 2 == 0:
        for letter in alphabet:
            if alphabet[letter] % 2 > 0:
                return [s, False]
        return [s, True]
    else:
        num_odd = 0
        for letter in alphabet:
            if (alphabet[letter] % 2 > 0):
                num_odd += 1
        # one val in alphabet is odd, all others even
        if num_odd > 1:
            return [s, False]
        return [s, True]

print(palindrome_perm("racecar"))
print(palindrome_perm("taco cat"))
print(palindrome_perm("raceca r$"))
print(palindrome_perm("Arthur"))
print(palindrome_perm("carcare"))