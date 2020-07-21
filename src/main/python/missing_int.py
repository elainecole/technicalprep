# 10.7 Missing Int
# 7/16/20

# 4 bill divided by 32
bit_mask = [0] * 4

def mark_int(i): 
    # set appropriate index in bit mask 
    index = int((i - 1) / 32)
    # set appropriate bit within index
    bit_num = i % 32
    # find int
    # mark bit
    print("bit mask: " + str(bit_mask) + " index: " + str(index) + " bit num: " + str(bit_num))

    bit_mask[index] = bit_mask[index] | (1 << (bit_num - 1))

def missing_int(input): 
    # go through input file once, marking bit for each number found
    for i in input: 
        mark_int(i)
    # find the 0 within bit mask -> output number associated 
    print(bit_mask)
    
    index = 0
    while index < len(bit_mask):
        if bit_mask[index] != 0xfffffffff:
            bit_index = 1
            while bit_index < 33: 
                if (bit_mask[index] & (1 << (bit_index - 1))) == 0: 
                    # know bit_index and index
                    print("bit mask: " + str(bit_mask) + " index: " + str(index) + " bit num: " + str(bit_index))
                    print("index " + str(bit_mask[index]))
                    return index * 32 + bit_index
                bit_index += 1
        index += 1

input = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14]
print(missing_int(input))