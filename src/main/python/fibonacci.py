def fib(n): 
    a, b = 0, 1
    while a < n: 
        print(a)
        a, b = b, a + b

i = 256*256
print('the value of i is ', i)

x = int(input('Please enter integer: '))
if x < 0: 
    x = 0
    print('negative x changed to zero')
elif x == 0: 
    print('zero')
elif x == 1: 
    print('one')
else: 
    print('more')
    fib(x)
    
def fib2(n): 
    result = []
    a, b = 0, 1
    while a < n: 
        result.append(a)
        a, b = b, a + b
    return result

f100 = fib2(100)
print(f100)