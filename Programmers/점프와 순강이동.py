def solution(n):
    ans = 0

    while(n!=0) :
        v, r = divmod(n,2)
        ans += r
        n = v
    return ans

print(solution(6))
print(solution(7))
print(solution(8))
print(solution(9))
print(solution(10))