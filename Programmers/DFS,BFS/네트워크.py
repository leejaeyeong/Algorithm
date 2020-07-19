from collections import deque
def bfs(computers, check, idx, n): # list 함수로 넘기면 깊은 복사
    dq=deque([idx])
    
    while(len(dq)>0):
        curIndex=dq.popleft()
        check[curIndex]=True
        for k in range(0,n):
            if check[k] ==False and computers[curIndex][k]==1: 
                dq.append(k)
    
def solution(n, computers):
    answer=0
    check=[False for _ in range(0,n)]
    for i in range(0,n):
        if check[i]==False:
            bfs(computers, check, i, n)
            answer+=1
    return answer