import itertools
import copy

def solution(expression):
    operatorAll = ['*','+','-']
    operator = []
    largeResult = -1
    for i in operatorAll :
        if i in expression :
            operator.append(i)
    p = list(itertools.permutations(operator, len(operator)))
    sperator = []
    nums = '0123456789'
    num = ''
    for i in range(len(expression)) :
        if expression[i] in nums :
            num += expression[i]
        else :
            sperator.append(num)
            sperator.append(expression[i])
            num = ''
    if num != '' :
        sperator.append(num)

    for i in p : # 우선 순위 조합
        temp_sperator = copy.deepcopy(sperator)
        for j in i : # 처리할 연산자 
            while j in temp_sperator :
                idx = temp_sperator.index(j)
                if j == '*' :
                    temp_sperator[idx-1] = str(int(temp_sperator[idx-1])*int(temp_sperator[idx+1]))
                elif j == '+' :
                    temp_sperator[idx-1] = str(int(temp_sperator[idx-1])+int(temp_sperator[idx+1]))
                else :
                    temp_sperator[idx-1] = str(int(temp_sperator[idx-1])-int(temp_sperator[idx+1]))
                
                del temp_sperator[idx]
                del temp_sperator[idx]
        if largeResult < abs(int(temp_sperator[0])) :
            largeResult = abs(int(temp_sperator[0]))

    return largeResult
            
print(solution("100-200*300-500+20"))
print(solution("50+555"))