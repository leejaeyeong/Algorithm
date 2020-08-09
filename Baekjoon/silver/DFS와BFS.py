import sys
from collections import deque

def dfs(s):
    if visited[s]:
        print(s,end=' ')
    for node in graph[s]:
        if not visited[node]:
            visited[node]=True
            dfs(node)

def bfs():
    print()
    visited=[False]*(n+1)
    que=deque([s])
    visited[s]=True
    while len(que)>0:
        node=que.popleft()
        print(node, end=' ')
        for i in graph[node]:
            if not visited[i]:
                visited[i]=True
                que.append(i)

n,m,s=map(int,sys.stdin.readline().rstrip().split())
graph=dict()
for i in range(1,n+1):
    graph[i]=[]

for i in range(1,m+1):
    u,v=map(int,sys.stdin.readline().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1,n+1):
    graph[i].sort()

visited=[False]*(n+1)
visited[s]=True

dfs(s)
bfs()

    