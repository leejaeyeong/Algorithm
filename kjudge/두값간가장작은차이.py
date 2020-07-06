# 일련의 정수 목록이 있을 때, 이 목록에서 두 개 값 간 차이가 가장 작은 차이

n = int(input())

for i in range(n):
    x = input()
    nums = [int(x) for x in input().split(' ')]
    min_num = 999999
    for j in range(len(nums)-1):
        for k in range(j+1,len(nums)):
            if nums[j] >= 0 and nums[k] >= 0:
                temp = max(nums[j],nums[k]) - min(nums[j],nums[k])
            elif nums[j] >= 0 and nums[k] < 0 or nums[j] < 0 and nums[k] >= 0:
                temp = max(nums[j],nums[k]) - min(nums[j],nums[k])
            elif nums[j] < 0 and nums[k] < 0:
                temp = abs(max(nums[j],nums[k])) - abs(min(nums[j],nums[k]))
            
            if temp < min_num:
                min_num = temp
    print(min_num)