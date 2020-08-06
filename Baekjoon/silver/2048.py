from collections import deque
def move_puzzle(state,direction):
    global score
    if direction=='front': # 왼쪽, 위쪽으로 퍼즐을 이동하는 경우
        for i in range(3): # 이동 방향으로 당겨오기
            if state[i]==0:
                state[i],state[i+1]=state[i+1],state[i]
        for i in range(3,0,-1): # 이동 방향으로 밀어주기
            if state[i-1]==0:
                state[i],state[i-1]=state[i-1],state[i]
        for i in range(3): # 합치고 공백 없애주기
            if state[i]==state[i+1]:
                state[i]*=2
                state[i+1]=0
                score+=state[i]
                for j in range(i+1,3):
                    state[j],state[j+1]=state[j+1],state[j]
    else: # 오른쪽, 아래쪽으로 퍼즐을 이동하는 경우
        for i in range(3,0,-1): # 이동 방향으로 당겨오기
            if state[i]==0:
                state[i],state[i-1]=state[i-1],state[i]
        for i in range(3): # 이동 방향으로 밀어주기
            if state[i+1]==0:
                state[i],state[i+1]=state[i+1],state[i]
        for i in range(3,0,-1): # 합치고 공백 없애주기
            if state[i]==state[i-1]:
                state[i]*=2
                state[i-1]=0
                score+=state[i]
                for j in range(i-1,0,-1):
                    state[j],state[j-1]=state[j-1],state[j]
    return state

def update_puzzle(key,num,y,x):
    direction='front' if key=='L' or key=='U' else 'back'
    if key in 'LR':
        for i in range(4):
            update=move_puzzle([x for x in puzzle[i]],direction) # 퍼즐의 행단위 처리
            for j in range(4): # 이동된 퍼즐 반영
                puzzle[i][j]=update[j]
    elif key in 'UD':
        for i in range(4):
            update=move_puzzle([puzzle[j][i] for j in range(4)],direction) # 퍼즐의 열단위 처리
            for j in range(4): # 이동된 퍼즐 반영
                puzzle[j][i]=update[j]
    puzzle[y][x]=num # 새로 추가된 퍼즐 조각

# input
score=int(input())
controls=input()
puzzle_init=list(map(int,input().split()))[::-1]

# init
puzzle=[[0 for col in range(4)] for row in range(4)]
puzzle=[[puzzle_init.pop() for col in range(4)] for row in range(4)]
controls=list(map(''.join, zip(*[iter(controls)]*4)))
controls=deque(controls)

while len(controls)>0:
    key,num,y,x=controls.popleft()
    update_puzzle(key,int(num),int(y),int(x))
print(score)