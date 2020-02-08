def solution(arr):
    arr.sort(reverse=True)
    x = 1
    while True :
        for i in range(1,len(arr)) :
            if arr[0] * x % arr[i] != 0 :
                x += 1
                break
            elif i == len(arr) - 1 :
                return arr[0] * x
        

    
print(solution([2,6,8,14]))
print(solution([1,2,3]))