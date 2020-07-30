import collections
import sys
queue=collections.deque()
n=int(input())
queue_length=0 # len(queue) 보다 push할때 +1, pop할때 -1로 queue size 갱신
for i in range(n):
    command=sys.stdin.readline().split() # python 입력은 sys로
    if command[0]=='push':
        queue.append(command[1])
        queue_length+=1
    elif command[0]=='pop':
        if queue_length==0:
            print(-1)
        else:
            print(queue.popleft())
            queue_length-=1
    elif command[0]=='size':
        print(queue_length)
    elif command[0]=='empty':
        print(1) if queue_length==0 else print(0)
    elif command[0]=='front':
        if queue_length==0:
            print(-1)
        else:
            print(queue[0])
    elif command[0]=='back':
        if queue_length==0:
            print(-1)
        else:
            print(queue[-1])