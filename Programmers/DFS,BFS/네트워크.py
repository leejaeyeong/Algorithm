from collections import deque
def bfs(computers, check, idx): # list 함수로 넘기면 깊은 복사
    dq=deque([idx])
    
    # 처리되는 check 인덱스는 같은 네트워크를 의미함
    while(len(dq)>0):
        curIndex=dq.popleft()
        check[curIndex]=True
        for k in range(len(check)):
            if check[k]==False and computers[curIndex][k]==1: 
                dq.append(k)
    
def solution(n, computers):
    answer=0
    check=[False]*n
    for i in range(0,n):
        if check[i]==False: 
            bfs(computers, check, i) 
            answer+=1 #
    return answer
