"""
정수 배열의 값들이 계속 증가하거나 계속 감소하면 이 배열을 증가/감소 배열이라한다.
i<=j에 대해 A[i]<=A[j]이면 증가 배열, 그 반대면 감소 배열이라한다. 주어진 배열이 증가 또는 감소 배열인지 판단하라
증가/감소 true, 증가/감소가 아니면 false
"""

n = int(input())

for i in range(n):
    nums = [int(x) for x in input().split(' ')]
    increase_state, decrease_state = True, True
    for j in range(len(nums)-1):
        if nums[j] <= nums[j+1]:
            continue
        else:
            increase_state = False
            break
    if increase_state:
        print(True)
        continue

    for j in range(len(nums)-1):
        if nums[j] >= nums[j+1]:
            continue
        else:
            decrease_state = False
            break

    print(True) if decrease_state else print(False)
        
        