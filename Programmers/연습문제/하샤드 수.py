def solution(x):
    tx = str(x)
    sum = 0
    for i in range(len(tx)) :
        sum = sum + int(tx[i])
    return True if x % sum == 0 else False