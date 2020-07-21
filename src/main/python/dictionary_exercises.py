# https://www.w3resource.com/python-exercises/dictionary/
# 7/11/20

dict = {0: "cat", 10: "dog", 12: "hamster", 5: "squirrel", 23: "ferret"}

# 0. Write a Python script to sort (ascending and descending) a dictionary by key.
def sort_dict_by_key(s, dict):
    if s != "ascending" and s != "descending":
        # bad value
        return("error: did not receive \'ascending\' or \'descending\'")
    else: 
        dict_items = dict.items()
        if s == "ascending":
            sorted_items = sorted(dict_items)
            return sorted_items
        else: 
            # s == "descending": 
            sorted_items = sorted(dict_items, reverse = True)
            return sorted_items



# 1. Write a Python script to sort (ascending and descending) a dictionary by value.

def dictionary_value(x): 
    return x[1]

def sort_dict_by_value(s, dict):
    if s != "ascending" and s != "descending":
            # bad value
            return("error: did not receive \'ascending\' or \'descending\'")
    else: 
        dict_items = dict.items()
        if s == "ascending":
            sorted_items = sorted(dict_items, key = dictionary_value)
            return sorted_items
        else: 
            # s == "descending": 
            sorted_items = sorted(dict_items, key = dictionary_value, reverse = True)
            return sorted_items



# 2. Write a Python script to add a key to a dictionary.
def add_key_to_dict(k, dict): 
    dict[k] = "chinchilla"
    return dict


# 3. Write a Python script to concatenate following dictionaries to create a new one.
dic1 = {1:10, 2:20}
dic2 = {3:30, 4:40}
dic3 = {5:50,6:60}

def concatenate_dictionaries(list_dict = [dic1, dic2, dic3]):
    dict_output = {}
    # for each dictionary
    for d in list_dict: 
        dict_output.update(d)
    return dict_output


if __name__ == '__main__':
    # ascending test
    expected_output_one = [(0, 'cat'), (5, 'squirrel'), (10, 'dog'), (12, 'hamster'), (23, 'ferret')]
    actual_output_one = sort_dict_by_key('ascending', dict)
    assert actual_output_one == expected_output_one

    # descending test
    expected_output_two = [(23, 'ferret'), (12, 'hamster'), (10, 'dog'), (5, 'squirrel'), (0, 'cat')]
    actual_output_two = sort_dict_by_key('descending', dict)
    assert actual_output_two == expected_output_two

    print(add_key_to_dict(42, dict))

    print(sort_dict_by_value('ascending', dict))
    print(sort_dict_by_value('descending', dict))
    print(sort_dict_by_value('4', dict))

    print(concatenate_dictionaries())