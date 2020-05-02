# 크레인 인형뽑기 게임
def solution(board, moves) :
    pocket = [] 
    cnt = 0
    for i in moves :
        for j in range(len(board)) :
            if board[j][i-1] == 0 :
                continue
            pocket.append(board[j][i-1])
            board[j][i-1] = 0 
            if len(pocket) > 1 and  pocket[-1] == pocket[-2]:
                cnt += 2
                pocket.pop()
                pocket.pop()
            break
    return cnt