from itertools import permutations
n,m=map(int,input().split())
permute=list(map(int,input().split()))
candidate=set(list(permutations(permute,m)))
answer=[]
for case in candidate:
    state=False
    for idx in range(len(case)-1):
        if case[idx]>case[idx+1]:
            state=True
            break
    if not state:
        answer.append(case)
answer.sort()
for i in answer:
    for j in i:
        print(j,end=' ')
    print()
     