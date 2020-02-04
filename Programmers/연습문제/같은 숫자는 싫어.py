def solution(arr):
    answer = []
    sv = arr[0]
    for i in range(len(arr)-1) :
        if arr[i+1] != sv :
            answer.append(sv)
            sv = arr[i+1]
        if i == len(arr)-2 :
            answer.append(sv)
    return answer