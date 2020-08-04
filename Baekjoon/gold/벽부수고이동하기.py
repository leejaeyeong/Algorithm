import sys
from collections import deque
input = sys.stdin.readline
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
def bfs():
    q = deque()
    q.append([0, 0, 1])
    visit = [[[0] * 2 for i in range(m)] for i in range(n)]
    visit[0][0][1] = 1
    while q:
        a, b, w = q.popleft() # y축, x축, crash여부 
        if a == n - 1 and b == m - 1:
            return visit[a][b][w]
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0 <= x < n and 0 <= y < m:
                if maze[x][y] == 1 and w == 1: # 탐색하려는 위치가 벽이고 벽을 아직 안 부순 상태라면
                    visit[x][y][0] = visit[a][b][1] + 1 # 벽을 부순 위치에 대해 거리값을 1 늘려주고 q에 새로 탐색할 위치 + 벽을 부순 상태 변수 0 append
                    q.append([x, y, 0])
                elif maze[x][y] == 0 and visit[x][y][w] == 0: # 탐색 위치가 0(길)이고, visit[x][y][w]==0 인경우 거리 갱신안된것이므로 미방문
                    visit[x][y][w] = visit[a][b][w] + 1
                    q.append([x, y, w])
    return -1
n, m = map(int, input().split())
maze = []
for i in range(n):
    maze.append(list(map(int, list(input().strip()))))
print(bfs())


# https://www.acmicpc.net/board/view/27386
# 시간초과 코드 
""" def is_inside_maze(y,x): # y좌표, x좌표가 미로를 벗어났는지 확인
    if y>=0 and y<r and x>=0 and x<c:
        return True
    return False
dirs=((-1,0),(1,0),(0,-1),(0,1)) # 상하좌우
r,c=map(int,input().split())
maze=[sys.stdin.readline().rstrip() for _ in range(r)] # 미로
visited=[[False]*c for _ in range(r)] # 방문 여부 2차원 리스트
location=collections.deque([[0,0,1,False]]) # queue에 들어있는 요소는 순서대로 y좌표, x좌표, 거리, 벽을 부술 수 있는지 여부
while location:
    y,x,dist,destroyed=location.popleft()
    
    if visited[y][x]: # 이미 방문을 했으면 다음 좌표로
        continue
    if not destroyed: # 벽을 안 부순 상태의 경로만 방문 처리를 하여, 벽을 부순 상태의 경로와 중복해서 visited 체크하는 일이 없도록함
        visited[y][x]=True
    
    if y==r-1 and x==c-1:
        visited[y][x]=True
        print(dist)
        break
    for i in dirs:
        _y=y+i[0]
        _x=x+i[1]
        if is_inside_maze(_y,_x) and not visited[_y][_x] : # 상하좌우가 유효한 좌표이고, 과거에 방문을 안한경우
            if maze[_y][_x]=='0': # 벽이 아니여서 탐색 가능한 경우
                location.append([_y,_x,dist+1,destroyed])
            elif maze[_y][_x]=='1' and not destroyed: # 벽을 부수고 탐색하는 경우 
                location.append([_y,_x,dist+1,True])
if not visited[r-1][c-1]:
    print(-1) """