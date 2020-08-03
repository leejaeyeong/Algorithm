import sys
sys.setrecursionlimit(10**8)
def is_inside_yard(y,x):
    if y>=0 and y<r and x>=0 and x<c:
        if yard[y][x]!='#':
            return True
    return False

def check_yard(y,x):
    visited[y][x]=True
    if yard[y][x]=='v':
        global wolf
        wolf=wolf+1
    elif yard[y][x]=='o':
        global sheep
        sheep=sheep+1

    for i in control:
        _y=y+i[0]
        _x=x+i[1]
        if is_inside_yard(_y,_x) and visited[_y][_x]==False:
            check_yard(_y,_x)
    
control=((-1,0),(1,0),(0,-1),(0,1))
r,c=map(int,input().split())
yard=[sys.stdin.readline() for _ in range(r)]
visited=[[False]*c for _ in range(r)]
live_wolf,live_sheep=0,0

for i in range(r): 
    for j in range(c):
        if yard[i][j]!='#' and visited[i][j]==False:
            wolf,sheep=0,0
            check_yard(i,j)
            if wolf>=sheep:
                live_wolf+=wolf
            else:
                live_sheep+=sheep
print(live_sheep,live_wolf)