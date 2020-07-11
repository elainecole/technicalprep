# 7/10/20
# hackerrank: https://www.hackerrank.com/challenges/words-score/problem

def is_vowel(letter):
    return letter in ['a', 'e', 'i', 'o', 'u', 'y']

def old_score_words(words):
    score = 0
    for word in words:
        num_vowels = 0
        for letter in word:
            if is_vowel(letter):
                num_vowels += 1
        if num_vowels % 2 == 0:
            score += 2
        else:
            ++score
    return score

def score_words(words):
    score = 0
    i = 0
    num_vowels = 0  

    while i < len(words):
        if words[i].isspace() == True or (i + 1) == len(words):
            print("space")
            print("vowels is " + str(num_vowels))
            if num_vowels % 2 == 0: 
                score += 2
            else: 
                score += 1
            print("score now " + str(score))
            num_vowels = 0

        print('Char: ' + words[i])
        if is_vowel(words[i]): 
            print("is a vowel")
            num_vowels += 1
        print("vowels now " + str(num_vowels))
        i += 1
    return score

print(score_words("hacker book"))

