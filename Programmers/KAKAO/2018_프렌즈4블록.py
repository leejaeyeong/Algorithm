""" 블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 프렌즈4블록.
같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다. """

def solution(m, n, board):
    bombedBlock = 0
    board = [list(i) for i in board]
    
    # 2x2 형태의 블록 조합이 있는지 스캔하여 좌표 리스트 반환
    def scanBoard() :
        bombList = [] 
        for i in range(1,len(board)) :
            for j in range(1,len(board[i])) :
                if board[i][j] != '-' and board[i][j] == board[i-1][j] and board[i][j] == board[i-1][j-1] and board[i][j] == board[i][j-1] :
                    bombList.append([i,j])
        return bombList
    
    # 터지는 블록의 중복을 없애고 board 업데이트
    def bomb(bombList) :
        block = []
        for i in bombList :
            for j in range(0,-2,-1) :
                for k in range(0,-2,-1) :
                    blockPoint = [i[0]+k,i[1]+j]
                    if blockPoint not in block : 
                        block.append([i[0]+k,i[1]+j])
        
        return len(block), updateBoard(block)


    def updateBoard(removeBlock) :
        for i in removeBlock :
            board[i[0]][i[1]] = '-'

        # 블록이 내려오는 것 구현

        # 반시계 방향 90도 회전
        temp_board = [[board[i][j] for i in reversed(range(m))] for j in range(n)]
        
        # 사라진 블록을 삭제하여 위에 있는 블록의 index을 당겨옴
        for i in range(len(temp_board)) :
            for j in range(len(temp_board[i])) :
                if temp_board[i][j] == '-' :
                    temp_board[i].remove('-')
                    temp_board[i].append('-')
                        
        # 시계방향 90도 회전 (원래 form)
        temp_board = [[temp_board[i][j] for i in range(n)] for j in reversed(range(m))]

        return temp_board

    while len(scanBoard()) > 0 :
        bombedBlock += bomb(scanBoard())[0]
        board = bomb(scanBoard())[1]
    return bombedBlock

print(solution(4,5,['CCBDE', 'AAADE', 'AAABF', 'CCBBF']))
print(solution(6,6,['TTTANT', 'RRFACC', 'RRRFCC', 'TRRRAA', 'TTMMMF', 'TMMTTJ']))