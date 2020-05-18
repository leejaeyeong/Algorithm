def solution(dirs):
    positions = dict()
    currentPosition = [0,0]

    def movePostion(k) :
        position = str(currentPosition[0])+','+str(currentPosition[1])
        if k == 'U' and abs(currentPosition[1] + 1) <= 5 :
            if str(currentPosition[0])+','+str(currentPosition[1]+1) in positions.keys() :
                if 'D' in positions[str(currentPosition[0])+','+str(currentPosition[1]+1)] :
                    currentPosition[1] = currentPosition[1] + 1
                    return False
            if position in positions.keys() :
                if 'U' in positions[position] :
                    currentPosition[1] = currentPosition[1] + 1
                    return False
                else :
                    positions[position] += 'U'
            else :
                positions[position] = 'U'
            currentPosition[1] = currentPosition[1] + 1
            return True
        elif k == 'D' and abs(currentPosition[1] - 1) <= 5 :
            if str(currentPosition[0])+','+str(currentPosition[1]-1) in positions.keys() :
                if 'U' in positions[str(currentPosition[0])+','+str(currentPosition[1]-1)] :
                    currentPosition[1] = currentPosition[1] - 1
                    return False
            if position in positions.keys() :
                if 'D' in positions[position] :
                    currentPosition[1] = currentPosition[1] - 1
                    return False
                else :
                    positions[position] += 'D'
            else :
                positions[position] = 'D'
            currentPosition[1] = currentPosition[1] - 1
            return True
        elif k == 'L' and abs(currentPosition[0] - 1) <= 5 :
            if str(currentPosition[0]-1)+','+str(currentPosition[1]) in positions.keys() :
                if 'R' in positions[str(currentPosition[0]-1)+','+str(currentPosition[1])] :
                    currentPosition[0] = currentPosition[0] - 1 
                    return False
            if position in positions.keys() :
                if 'L' in positions[position] :
                    currentPosition[0] = currentPosition[0] - 1 
                    return False
                else :
                    positions[position] += 'L'
            else :
                positions[position] = 'L'
            currentPosition[0] = currentPosition[0] - 1 
            return True
        elif k == 'R' and abs(currentPosition[0] + 1) <= 5 :
            if str(currentPosition[0]+1)+','+str(currentPosition[1]) in positions.keys() :
                if 'L' in positions[str(currentPosition[0]+1)+','+str(currentPosition[1])] :
                    currentPosition[0] = currentPosition[0] + 1 
                    return False
            if position in positions.keys() :
                if 'R' in positions[position] :
                    currentPosition[0] = currentPosition[0] + 1 
                    return False
                else :
                    positions[position] += 'R'
            else :
                positions[position] = 'R'
            currentPosition[0] = currentPosition[0] + 1 
            return True
        return False

    firstStepCnt = 0
    for i in dirs :
        if movePostion(i) == True :
            firstStepCnt += 1
    return firstStepCnt

print(solution('ULURRDLLU'))
print(solution('LULLLLLLU'))
print(solution('LURDLURDLURDLURDRULD'))
print(solution('RRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUULU'))