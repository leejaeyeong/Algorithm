def solution(d, budget):
    d.sort()
    sum = 0
    answer = 0
    for i in range(len(d)) :
        sum = sum + d[i]
        
        if budget < sum :
            break 
        else :
            answer = answer + 1
    
    return answer