def solution(dirs):
    positions = dict()
    currentPosition = [0,0]

    def movePostion(k) :
        position = str(currentPosition[0])+','+str(currentPosition[1])
        upPosition = str(currentPosition[0])+','+str(currentPosition[1]+1)
        downPosition = str(currentPosition[0])+','+str(currentPosition[1]-1)
        leftPosition = str(currentPosition[0]-1)+','+str(currentPosition[1])
        rightPosition = str(currentPosition[0]+1)+','+str(currentPosition[1])

        if k == 'U' and abs(currentPosition[1] + 1) <= 5 :
            currentPosition[1] = currentPosition[1] + 1
            if upPosition in positions.keys() and 'D' in positions[upPosition] :
                return False
            elif position in positions.keys() :
                if 'U' in positions[position] :
                    return False
                positions[position] += 'U'
            else :
                positions[position] = 'U'
            return True

        elif k == 'D' and abs(currentPosition[1] - 1) <= 5 :
            currentPosition[1] = currentPosition[1] - 1
            if downPosition in positions.keys() and 'U' in positions[downPosition] :
                return False
            if position in positions.keys() :
                if 'D' in positions[position] :
                    return False
                positions[position] += 'D'
            else :
                positions[position] = 'D'
            return True

        elif k == 'L' and abs(currentPosition[0] - 1) <= 5 :
            currentPosition[0] = currentPosition[0] - 1 
            if leftPosition in positions.keys() and 'R' in positions[leftPosition] :
                return False
            if position in positions.keys() :
                if 'L' in positions[position] :
                    return False
                positions[position] += 'L'
            else :
                positions[position] = 'L'
            return True

        elif k == 'R' and abs(currentPosition[0] + 1) <= 5 :
            currentPosition[0] = currentPosition[0] + 1 
            if rightPosition in positions.keys() and 'L' in positions[rightPosition] :
                return False
            if position in positions.keys() :
                if 'R' in positions[position] :
                    return False
                positions[position] += 'R'
            else :
                positions[position] = 'R'
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