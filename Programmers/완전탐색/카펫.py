def solution(brown, red):
    for i in range(3,red+3) :
        for j in range(3,brown) :
            if red == (i - 2) * (j - 2) and brown + red == j*i:
                return [j,i]

# for 범위 수정