import math
def solution(n):
    cnt = 0
    for i in range(1,math.ceil(n/2)+1,1) :
        sum = 0
        for j in range(i,math.ceil(n/2)+1,1) :
            sum = sum + j
            if sum == n : cnt = cnt + 1 
            elif sum > n : break
    return cnt + 1