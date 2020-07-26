import itertools
arr=[]
while True:
    case=list(map(int,input().split()))
    if len(case)==1:
        break
    case=case[1:]
    combination=list(itertools.combinations(case,6)) # 순열 구현
    for combi in combination:
        for val in combi:
            print(val,end=' ')
        print()
    print()