from collections import deque
def check(state,direction):
    global score
    if direction=='front':
        for i in range(3): # 0 만듦
            if state[i]==0:
                state[i]=state[i+1]
                state[i+1]=0
        for i in range(3,0,-1): # 오른쪽 기준 0
            if state[i-1]==0:
                state[i-1]=state[i]
                state[i]=0
        for i in range(3): # 합침
            if state[i]==state[i+1]:
                state[i]+=state[i+1]
                score+=state[i]
                for j in range(i+1,3):
                    state[j]=state[j+1]
                    state[j+1]=0
    else:
        for i in range(3,0,-1): # 오른쪽 기준 0
            if state[i]==0:
                state[i]+=state[i-1]
                state[i-1]=0
        for i in range(3): # 왼쪽 기준 0
            if state[i+1]==0:
                state[i+1]=state[i]
                state[i]=0
        for i in range(3,0,-1): # 합침
            if state[i]==state[i-1]:
                state[i]+=state[i-1]
                state[i-1]=0
                score+=state[i]
                for j in range(i-1,0,-1):
                    state[j]=state[j-1]
                    state[j-1]=0
    return state

def update_puzzle(key,num,y,x):
    direction='front' if key=='L' or key=='U' else 'back'
    if key in 'LR':
        for i in range(4):
            update=check([x for x in puzzle[i]],direction)
            for j in range(4):
                puzzle[i][j]=update[j]
    elif key in 'UD':
        for i in range(4):
            update=check([puzzle[j][i] for j in range(4)],direction)
            for j in range(4):
                puzzle[j][i]=update[j]
    puzzle[y][x]=num

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