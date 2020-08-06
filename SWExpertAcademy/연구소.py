import sys
import itertools
import copy

def bfs(y,x):
    for i in range(4):
        ny=y+dy[i]
        nx=x+dx[i]
        if 0 <= ny < n and 0 <= nx < m:
            if laboratory_test[ny][nx]==0:
                if not visited[ny][nx]:
                    visited[ny][nx]=True
                    laboratory_test[ny][nx]=2
                    bfs(ny,nx) 

n,m=map(int,input().split())
laboratory=[list(map(int,sys.stdin.readline().split())) for i in range(n)]
location=[]
dy=(-1,1,0,0)
dx=(0,0,-1,1)
max_safety_area=0

for i in range(len(laboratory)):
    for j in range(len(laboratory[i])):
        if laboratory[i][j]==0:
            location.append((i,j))
candidate=list(itertools.combinations(location,3))

for i in candidate:
    laboratory_test=copy.deepcopy(laboratory)
    visited=[[False]*m for _ in range(n)]
    safety_area=0
    
    for j in i: # 세 개의 벽을 만든다
        laboratory_test[j[0]][j[1]]=1
 
    for y in range(len(laboratory_test)):
        for x in range(len(laboratory_test[y])):
            if laboratory_test[y][x]==2: # 바이러스이면 
                if not visited[y][x]:
                    visited[y][x]=True
                    bfs(y,x)

    for y in range(len(laboratory_test)):
        for x in range(len(laboratory_test[y])):
            if laboratory_test[y][x]==0:
                safety_area+=1
    max_safety_area=max(max_safety_area,safety_area)

print(max_safety_area)
