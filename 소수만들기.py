from itertools import combinations
def solution(nums):
    c = list(map(sum,combinations(nums,3)))
    
    n = 3000
    num = set([x for x in range(2,n+1)])
    for i in range(2,n+1) :
        if i in num :
            num -= set([x for x in range(2*i,n+1,i)])
    ans = 0
    for i in c :
        if i in num :
            ans += 1
    return ans

print(solution([1,2,7,6,4,100,19,156]))
print(solution([1,2,3,4]))