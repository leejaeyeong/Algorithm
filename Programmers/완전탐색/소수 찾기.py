import itertools
def solution(numbers):
    
    all = []
    max = int('1'+'0'*len(numbers))

    sosu = set(range(2,max+1)) 
    
    # �Ƹ������׳׽� ü�� �̿��� ����� ����
    for i in range(2,max+1) :
        if i in sosu :
            sosu -= set(range(2*i,max+1,i))
    
    sosu = list(sosu)
    
    # ��� ������ ���� ����
    for i in range(1,len(numbers)+1) :
        all.append(list(map(''.join, itertools.permutations(numbers,i))))
    
    for i in range(len(all)) :
        all[i] = list(map(int,all[i]))

    cnt = 0
    x = []
    #�ߺ� ���Ÿ� ����
    for i in range(len(all)) :
        all[i] = list(set(all[i]))
        for j in range(len(all[i])) :
            x.append(all[i][j])
    x = list(set(x))
    
    # �Ҽ� ��� �ȿ� ���� ��� ī��Ʈ ����
    for i in x :
        if i in sosu :
            cnt = cnt + 1
    return cnt