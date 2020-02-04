def solution(n, lost, reserve):     # 다시 풀어보자
    c = 0   
    lost1 = [x for x in lost if x not in reserve]
    reserve = [x for x in reserve if x not in lost]

    for i in range(1, n+1) :
        if i in lost1 :
            if i-1 != 0 and i-1 in reserve : 
                x = reserve.index(i-1)
            elif i+1 in reserve :
                x = reserve.index(i+1)
            
            if i+1 in reserve and reserve.index(i+1) != -1 or i-1 in reserve and reserve.index(i-1) != -1 :
                c = c + 1
                del reserve[x]
        else :
            c = c + 1
    return c