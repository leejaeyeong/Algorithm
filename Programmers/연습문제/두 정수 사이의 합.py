def solution(a, b):
    answer = 0
    liter = answer + a if a < b else answer + b
    for i in range(abs(a-b)+1) :
        answer = answer + liter
        liter = liter + 1
    
    return answer