def recur(i, max_num):
    if i < max_num:
        i += 1
        return recur(i, max_num)
    print(i)

recur(0, 10)