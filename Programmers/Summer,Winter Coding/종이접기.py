import collections
def solution(n):
    
    prevStep = '0'
    step = 1

    while step != n :
        step += 1
        answer = collections.deque([0])
        prevStep = prevStep[-1::-1]
        for i in prevStep :
            answer.appendleft(int(i))
            answer.append(abs(int(i)-1))
        prevStep = ''.join([str(x) for x in answer])
    return list(answer)