def solution(p):
    answer = []
    for i in range(len(p)-1) :
        c = 0
        for j in range(i+1,len(p)) :
            if p[i] <= p[j] :
                c = c + 1
            else :
                answer.append(c+1)
                break
            if j == len(p) - 1:
                answer.append(c)
                break
    answer.append(0)
    return answer