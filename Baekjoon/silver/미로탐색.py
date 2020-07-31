# BFS
import sys
import collections

control=((-1,0),(1,0),(0,-1),(0,1)) # 상하좌우
que=collections.deque([[0,0]])
que_dist=collections.deque([1])
minimun_len=10000000
answer=0

n,m=map(int,input().split())
maze=[[int(x) for x in sys.stdin.readline().rstrip()] for _ in range(n)]
visited=[[False]*100 for _ in range(100)]

def check(y,x):
    if y>=n or y<0 or x>=m or x<0 or maze[y][x]==0: # 맵에서 벗어나거나 벽인 경우
        return False
    return True

while len(que)>0:
    y,x=que.popleft()
    dist=que_dist.popleft()

    if visited[y][x]:
        continue
    visited[y][x]=True

    if y==n-1 and x==m-1:
        answer=dist
        break
    
    for i in range(4):
        new_x=x+control[i][0]
        new_y=y+control[i][1]
        
        if check(new_y,new_x): 
            que.append([new_y,new_x]) # 탐색 경로에 추가 
            que_dist.append(dist+1)
print(answer)