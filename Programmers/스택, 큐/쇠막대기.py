def solution(arr):
    bar = [] 
    total = 0
    for i in range(len(arr)) :
        if arr[i] == '(' :
            bar.append(i)
        elif len(bar) != 0 and arr[i] == ')' :
            bar.pop()
            total = total + len(bar) if arr[i-1] == '(' else  total + 1
    return total