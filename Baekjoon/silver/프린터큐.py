import collections
n=int(input())
for i in range(n):
    c,l=map(int,input().split())
    order_state=collections.deque(list(map(int,input().split())))
    target=order_state[l]
    answer=0
    if target==max(order_state):
        print(1)
        continue
    
    for idx,j in enumerate(list(order_state)[l:]):
        if j>=target and idx!=l:
            answer+=1
    for idx,j in enumerate(list(order_state)[:l]):
        if j>=target and idx!=l:
            answer+=1
    print(answer)



    