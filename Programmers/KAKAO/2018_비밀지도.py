def solution(n, arr1, arr2):
    answer = []
    for i in range(n) :
        arr1[i] = '0'*(n-len(bin(arr1[i])[2:])) + (bin(arr1[i])[2:])
        arr2[i] = '0'*(n-len(bin(arr2[i])[2:])) + (bin(arr2[i])[2:])
    for i in range(n) :
        decoding = ''
        for j in range(n) :
            decoding = decoding + '#' if arr1[i][j] == '1' or arr2[i][j] == '1' else decoding + ' '
        answer.append(decoding)
    return answer