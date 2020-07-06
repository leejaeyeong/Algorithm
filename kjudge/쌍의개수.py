# 일련의 정수가 주어졌을 때, 두 쌍의 합이 주어진 값이 되는 쌍의 수를 찾아라.

n = int(input())

for i in range(n):
    cnt=0
    target=int(input().split(' ')[0])
    nums=[int(x) for x in input().split(' ')]
    for j in range(len(nums)-1):
        for k in range(j+1,len(nums)):
            if nums[j] + nums[k] == target:
                cnt+=1
    print(cnt)

