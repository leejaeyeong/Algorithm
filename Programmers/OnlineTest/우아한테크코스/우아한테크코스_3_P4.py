def find_target_location(target_num,board):
    for y in range(len(board)):
        for x in range(len(board[y])):
            if target_num==board[y][x]:
                return y,x
def reduce_row_distance(n,current_y,target_y):
    if current_y==target_y:
        return 0
    dy=min(abs(target_y-(current_y+1)%n),abs(target_y-(current_y-1)%n))
    return abs(target_y-dy)
    
def reudce_col_distance(n,current_x,target_x):
    if current_x==target_x:
        return 0
    dx=min(abs(target_x-(current_x+1)%n),abs(target_x-(current_x-1)%n))
    return abs(target_x-dx)

def solution(n, board):
    answer=0
    target_num=1
    current_y,current_x=0,0
    while target_num<=n*n:
        target_y,target_x=find_target_location(target_num,board)
        answer+=reduce_row_distance(n,current_y,target_y)
        answer+=reudce_col_distance(n,current_x,target_x)
        answer+=1
        current_y=target_y
        current_x=target_x
        target_num+=1
    return answer
        
    # 현재 위치 행 기준 +- 해보고 절댓값이 가까워지는 곳
    # 현재 위치 열 기준 +- 해보고 절댓값이 가까워지는 곳
    # 하나만 기준으로 잡고가면 되구나 

print(solution(3,[[3, 5, 6], [9, 2, 7], [4, 1, 8]]))
print(solution(2,[[2, 3], [4, 1]]))
print(solution(4,[[11, 9, 8, 12], [2, 15, 4, 14], [1, 10, 16, 3], [13, 7, 5, 6]]))