import sys
sys.setrecursionlimit(10**8)
n,m=map(int,input().split())
graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)
def dfs(v):
    visited[v]=True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)
for i in range(m):
    u,v=map(int,sys.stdin.readline().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)
cnt=0
for i in range(1,n+1):
    if not visited[i]:
        dfs(i)
        cnt+=1
print(cnt)