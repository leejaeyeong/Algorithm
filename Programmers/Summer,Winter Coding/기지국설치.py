def solution(n, stations, w):
    deActivateApart = []
    deActivateApart.append(stations[0]-w-1)
    deActivateApart.append(n-(stations[-1] + w))
    
    for i in range(len(stations)-1) :
        deActivateApart.append((stations[i+1]-w-1) - (stations[i]+w))
        
    answer = 0
    for i in deActivateApart :
        if i <= 0 :
            continue
        a,b = divmod(i,w*2+1)
        answer += a
        if b != 0 : answer += 1
    return answer

print(solution(100,[5,15,66,77],1))
print(solution(11,[4, 11],1))
print(solution(16,[9],2))