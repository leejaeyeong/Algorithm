def solution(arr, divisor):
    answer = []
    for i in range(len(arr)) :
        if arr[i] % divisor == 0 :
            answer.append(arr[i])
    answer.append(-1) if len(answer) == 0 else answer.sort()
    return answer