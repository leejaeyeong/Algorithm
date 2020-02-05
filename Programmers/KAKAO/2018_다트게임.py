def solution(dartResult):
    bonus = {'S':1, 'D':2, 'T':3}
    num = ['0','1','2','3','4','5','6','7','8','9','10']
    score = []
    state = False
    for i in dartResult :
        end = len(score)-1
        if i in num :
            if i == '1' :
                score.append(int(i))
                state = True
            elif i == '0' :
                if end != -1 and score[end] == 1 and state :
                    score[end] = 10
                else :
                    score.append(int(i))
                state = False
            else :
                score.append(int(i))
                state = False

        elif i in bonus.keys() :
            score[end] = pow(score[end],bonus[i])
        elif i == '*' :
            score[end] = score[end] * 2
            if end != 0 :
                score[end-1] = score[end-1] * 2
        elif i == '#' :
            score[end] = -score[end]
    return sum(score)