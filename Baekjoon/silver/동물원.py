n=int(input())
mod=9901
dp=[[0,0,0] for i in range(n+1)]
dp[1][0]=1
dp[1][1]=1
dp[1][2]=1

for i in range(2,n+1):
    dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod
    dp[i][1] = (dp[i-1][0]+dp[i-1][2])%mod
    dp[i][2] = (dp[i-1][0]+dp[i-1][1])%mod

print((dp[n][0]+dp[n][1]+dp[n][2])%mod)