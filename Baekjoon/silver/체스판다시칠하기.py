import sys
n,m=map(int,input().split())
board=[sys.stdin.readline().rstrip() for _ in range(n)]
answer=64

def check(board):
    b_check='BWBWBWBW'
    w_check='WBWBWBWB'
    w_cnt,b_cnt=0,0
    for i in range(len(board)):
        for j in range(len(board[i])):
            if i%2==0:
                if board[i][j]!=b_check[j]:
                    b_cnt+=1
                if board[i][j]!=w_check[j]:
                    w_cnt+=1
            else:
                if board[i][j]!=w_check[j]:
                    b_cnt+=1
                if board[i][j]!=b_check[j]:
                    w_cnt+=1
    return min(w_cnt,b_cnt)

for i in range(len(board)-7):
    for j in range(len(board[i])-7):
        temp_board=[]
        for k in range(i,i+8):
            row=''
            for l in range(j,j+8):
                row+=board[k][l]
            temp_board.append(row)
        answer=min(answer,check(temp_board))
print(answer)