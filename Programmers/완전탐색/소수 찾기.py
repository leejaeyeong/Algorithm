import itertools
def solution(numbers):
    
    all = []
    max = int('1'+'0'*len(numbers))

    sosu = set(range(2,max+1)) 
    
    # 아리스토테네스 체를 이용해 배수를 삭제
    for i in range(2,max+1) :
        if i in sosu :
            sosu -= set(range(2*i,max+1,i))
    
    sosu = list(sosu)
    
    # 모든 가능한 문자 추출
    for i in range(1,len(numbers)+1) :
        all.append(list(map(''.join, itertools.permutations(numbers,i))))
    
    for i in range(len(all)) :
        all[i] = list(map(int,all[i]))

    cnt = 0
    x = []
    #중복 제거를 위함
    for i in range(len(all)) :
        all[i] = list(set(all[i]))
        for j in range(len(all[i])) :
            x.append(all[i][j])
    x = list(set(x))
    
    # 소수 목록 안에 있을 경우 카운트 증가
    for i in x :
        if i in sosu :
            cnt = cnt + 1
    return cnt