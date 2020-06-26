# 1.1 Is Unique 
# 6/26/20 

def is_unique(s):
    a = 0
    while a < len(s): 
        print(s[a])
        b = a + 1
        while b < len(s): 
            if s[a] == s[b]: 
                print("not unique")
                return 
            b += 1
        a += 1
    print("unique")

is_unique("abscdf")