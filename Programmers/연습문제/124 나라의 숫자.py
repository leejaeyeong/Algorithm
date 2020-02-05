def solution(n):
    answer = ''
    while True :
        if n % 3 == 0 :
            n = n // 3 - 1
            answer = str(4) + answer 
        else :
            answer = str(n % 3) + answer 
            n = n // 3 
        if n == 0 :
            break
    return answer