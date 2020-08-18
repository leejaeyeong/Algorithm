import sys
from collections import deque
def bfs(direction):
    que=deque([(r,c)])
    answer=0

    while len(que)>0:
        y,x=que.popleft()
        if room[y][x]==0:
            room[y][x]=2
            answer+=1
            
        for dr in range(4):
            ndirection=(direction+3-dr) % 4 # 새로운 방향 적용
            ny=y+dy[ndirection]
            nx=x+dx[ndirection]

            if ny<0 or ny>=n or nx<0 or nx>=m or room[ny][nx]!=0:
                continue
            que.append((ny,nx))
            direction=ndirection
            break
        
        if len(que)==0: # 4방향 모두 체크 후 후진
            ndirection=direction 
            ny=y+dy[(ndirection+2)%4] 
            nx=x+dx[(ndirection+2)%4]
            
            if ny<0 or ny>=n or nx<0 or nx>=m or room[ny][nx]==1:
                break

            que.append((ny,nx))
            
    return answer
    
n,m=map(int,sys.stdin.readline().rstrip().split())
# (북 0), (동 1), (남 2), (서 3)
r,c,direction=map(int,sys.stdin.readline().rstrip().split())
room=[list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
dy=(-1,0,1,0)
dx=(0,1,0,-1)
print(bfs(direction))
