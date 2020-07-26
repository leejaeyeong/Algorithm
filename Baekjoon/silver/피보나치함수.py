# 재귀함수로 구하면 시간 초과 
""" def fibonacci(n,call_cnt):
    if n==0:
        call_cnt[0]+=1
        return
    elif n==1:
        call_cnt[1]+=1
        return
    else:
        fibonacci(n-1,call_cnt)
        fibonacci(n-2,call_cnt)

N=int(input())
for i in range(N):
    call_cnt=[0,0]
    n=int(input())
    fibonacci(n,call_cnt)
    print(call_cnt[0], call_cnt[1]) """
# dp로 값 구해놓고 규칙성 찾기
dp=[0,1,1]
for i in range(3,41):
    dp.append(dp[-1]+dp[-2])
N=int(input())
for i in range(N):
    n=int(input())
    print(1,0) if n==0 else print(dp[n-1],dp[n])