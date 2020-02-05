# 시간 복잡도를 더 줄여야
def solution(n,stages) :
    unsuccess = []
    x =  1
    for i in range(1,n+1) :
        total,fail = 0,0
        for j in stages :
            if j >= i :
                if j == i :
                    fail = fail + 1
                total = total + 1
        unsuccess.append(0) if total == 0 else unsuccess.append(fail/total)

    answer = []
    for j in range(n) :
        idx = unsuccess.index(max(unsuccess))+1
        answer.append(idx)
        unsuccess[idx-1] = -1
    return answer