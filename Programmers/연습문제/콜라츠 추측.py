def solution(num):
    
    exit = 0
    cnt = 0
    if num == 1 : return 0
    for i in range(500) :
        if num % 2 == 0 :
            num = num // 2
        else :
            num = 3 * num + 1
        
        if num == 1 :
            exit = True
            cnt = i + 1
            break
    return cnt if exit == True else -1