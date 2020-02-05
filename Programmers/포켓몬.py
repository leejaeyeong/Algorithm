import math
def solution(nums):
    answer = []
    N = math.ceil(len(nums) / 2)
    for i in range(len(nums)) :
        if nums[i] not in answer :
            answer.append(nums[i])
    
    if len(answer) == N :
        return N 
    elif len(answer) < N :
        return len(answer)
    return N