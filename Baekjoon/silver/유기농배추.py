import sys
sys.setrecursionlimit(10**8)

def is_inside_ground(y,x): # x,y 좌표가 유효 범위를 벗어났는지 확인
    if y>=0 and y<r and x>=0 and x<c:
        return True
    return False

def check_ground(y,x): # 방문 체크
    visited[y][x]=True
    for i in control:
        _y=y+i[0]
        _x=x+i[1]
        if is_inside_ground(_y,_x) and visited[_y][_x]==False and ground[_y][_x]==1: # 과거에 방문을 안했고 배추가 있는 경우
            check_ground(_y,_x)

control=((-1,0),(1,0),(0,-1),(0,1))            
T=int(input())
for i in range(T):
    c,r,n=map(int,sys.stdin.readline().split())
    ground=[[0]*c for i in range(r)]
    visited=[[False]*c for i in range(r)]
    for j in range(n):
        x,y=map(int,(input().split()))
        ground[y][x]=1
    cnt=0
    for j in range(len(ground)):
        for k in range(len(ground[j])):
            if visited[j][k]==False and ground[j][k]==1:
                check_ground(j,k)
                cnt+=1
    print(cnt)