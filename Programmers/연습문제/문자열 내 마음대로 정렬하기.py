def solution(strings, n):
    answer = []
    rule = []
    sortArr = []

    for i in range(len(strings)) :
        rule.append(strings[i][n])

    rule = list(set(rule))
    rule.sort()

   
    for i in range(len(rule)) :
        for j in range(len(strings)) :
            if rule[i] == strings[j][n] :
                sortArr.append(strings[j])
        sortArr.sort()
        for k in range(len(sortArr)) :
            answer.append(sortArr[0])
            del sortArr[0]

    return answer