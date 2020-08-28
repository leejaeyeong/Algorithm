def solution(n, times):
    # times.sort()  
    left, right = 1, max(times)*n # 심사완료 최소 시간 ~ 최대 시간
    answer=0

    while left <= right:
        mid=(left+right)//2 
        complete=0
        for i in times:
            complete+=mid//i # 심사관 마다 해당 시간에 심사완료할 수 있는 사람 수 
            if complete>=n:
                break
        if complete>=n:
            answer=mid
            right=mid-1
        else:
            left=mid+1
    return answer
    
print(solution(6,[7,10]))