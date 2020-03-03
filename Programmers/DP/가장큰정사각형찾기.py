""" 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. 
(단, 정사각형이란 축에 평행한 정사각형을 말합니다.) """

def solution(board):

    width = len(board[0])
    height = len(board)

    for x in range(1,height) :
        for y in range(1,width) :
            if board[x][y] == 1 :
                board[x][y] = min(board[x-1][y-1],board[x][y-1],board[x-1][y]) + 1

    maxVal = 0
    for i in range(height) :
        for j in range(width) :
            if maxVal < board[i][j] :
                maxVal = board[i][j]

    return maxVal**2


print(solution([[1,1,1,1],[1,1,1,1],[1,1,1,1],[0,1,1,0]]))