def solution(n):
    numBinaryOne = bin(n)[2:].count('1')

    while True :
        n = n + 1
        if numBinaryOne == bin(n)[2:].count('1') :
            return n