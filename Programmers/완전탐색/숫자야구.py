def solution(baseball):
    posible = []
    for i in range(123,987+1) :
        if str(i)[0] == str(i)[1] or str(i)[0] == str(i)[2] or str(i)[1] == str(i)[2] or str(i)[0] == '0' or str(i)[1] == '0' or str(i)[2] == '0' :
            continue
        else :
            posible.append(str(i))
    
    cnt = 0 
    for i in posible :
        flag = True 
        for j in baseball :
            predictNum = str(j[0])
            strike, ball = 0, 0 
            for k in range(3) :
                if i[k] == predictNum[k] :
                    strike += 1
                elif i.find(predictNum[k]) != -1 :
                    ball += 1
            if strike != j[1] or ball != j[2] :
                flag = False
                break
        if flag :
            cnt += 1
    return cnt


    
print(solution([[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]))

