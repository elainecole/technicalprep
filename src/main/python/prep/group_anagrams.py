# 10.2 Group Anagrams
# 6/27/20

def group_anagrams(strings): 
    str_dict = {}
    # for each string in []
    for word in strings: 
        # check if is anagram of prev strings viewed
        anagram = False
        for k, v in str_dict.items():
            # if anagram
            if is_anagram(word, k):
                # add to existing []
                v.append(word)
                anagram = True
                str_dict[k] = v
                break
        # if not anagram
        if not anagram: 
            # make new [] and add to it 
            str_dict[word] = [word]
    # combine all [] and return
    sorted_strings = []
    for k, v in str_dict.items():
        for w in v:
            sorted_strings.append(w)
    return sorted_strings


def is_anagram(a, b): 
    alphabet_a = {letter: 0 for letter in set('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    alphabet_b = {letter: 0 for letter in set('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    if len(a) != len(b): 
        return False
    for c in a: 
        c = c.capitalize()
        alphabet_a[c] += 1
    for c in b: 
        c = c.capitalize()
        alphabet_b[c] += 1
    for letter in alphabet_a: 
        if alphabet_a[letter] != alphabet_b[letter]:
            return False
    return True

print(group_anagrams(["cat", "tar", "bat", "act", "rat", "art"]))