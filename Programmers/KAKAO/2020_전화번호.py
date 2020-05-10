def solution(numbers, hand):
    leftPosition = ['1','4','7','*']
    rightPosition = ['3','6','9','#']
    middlePostion = ['2','5','8','0']
    priviousLeftHand = '*'
    priviousRightHand = '#'
    answer = ''
    numbers = [str(x) for x in numbers]

    for i in numbers :
        if i in leftPosition :
            priviousLeftHand = i
            answer = answer + 'L'
        elif i in rightPosition :
            priviousRightHand = i
            answer = answer + 'R'
        else :
            if priviousLeftHand == i :
                answer = answer + 'L'
            elif priviousRightHand == i :
                answer = answer + 'R'
            else :  # 더 짧은 거리 계산
                length = middlePostion.index(i)
                if priviousLeftHand in leftPosition :
                    l_length = leftPosition.index(priviousLeftHand)
                    l_length = l_length + 1 if l_length >= length else -1
                else :
                    l_length = middlePostion.index(priviousLeftHand)
                l_distance = abs(length - l_length)

                if priviousRightHand in rightPosition :
                    r_length = rightPosition.index(priviousRightHand)
                    r_length = r_length + 1 if r_length >= length else -1
                else :
                    r_length = middlePostion.index(priviousRightHand)
                r_distance = abs(length - r_length)

                if r_distance > l_distance :
                    answer = answer + 'L'
                    priviousLeftHand = i 
                elif r_distance < l_distance :
                    answer = answer + 'R'
                    priviousRightHand = i
                else :
                    if hand == 'right' :
                        answer = answer + 'R'
                        priviousRightHand = i
                    else :
                        answer = answer + 'L'
                        priviousLeftHand = i
    return answer

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5],"right"),"\nLRLLLRLLRRL(정답)")
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2],"left"),"\nLRLLRRLLLRR(정답)")
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0],"right"),"\nLLRLLRLLRL(정답)")  