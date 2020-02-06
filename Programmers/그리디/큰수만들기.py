""" 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 
return 하도록 solution 함수를 완성하세요. """

# 순서대로 list에 값을 추가하고 list에 최근 값 보다 큰 값이 추가될 경우 기존 값을 pop


def solution(n,k):
    answer = [n[0]]
    cnt =  0
    for i in range(1,len(n)) :
        bAlreadyAppend = False

        while answer[-1] < n[i] :
            answer.pop()
            cnt += 1
            if cnt == k :
                answer.append(n[i])
                return ''.join(answer) + n[i+1:]
            if len(answer) == 0 or answer[-1] >= n[i]:
                answer.append(n[i])
                bAlreadyAppend = True
                break

        # while 내에서 append 됐을 경우 생략
        if not bAlreadyAppend :
            answer.append(n[i])
        
        # 모든 항목을 처리한 후 answer 길이가 일치하지 않을 경우 
        if i == len(n)-1 and len(answer) != len(n) - k :
            for j in range(len(answer) - len(n) + k) : answer.pop()

    return ''.join(answer)


print(solution('1010',2)) # 11
print(solution('1111',2)) # 11 
print(solution('1924',2)) # 94
print(solution('1231234',3)) # 3234
print(solution('4177252841',4)) #  775841             
        

# 다른 사람 풀이 
""" def solution(number, k):
    stack = [number[0]]
    for num in number[1:]:
        # stack이 없을 때, 더 큰 값이 추가 될 때, 삭제 횟수가 남아있을 때를 한 번에 비교
        while len(stack) > 0 and stack[-1] < num and k > 0:
            k -= 1
            stack.pop()
        stack.append(num)
    if k != 0:
        stack = stack[:-k]
    return ''.join(stack) """

            



