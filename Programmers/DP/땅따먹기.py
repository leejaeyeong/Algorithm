def solution(land):
    dp = [[0 for col in range(4)] for row in range(100001)]

    for i in range(4) :
        dp[0][i] = land[0][i]       # 첫 행 초기값
    for i in range(len(land)) : 
        for j in range(4) :
            for k in range(4) :
                if j != k :
                    dp[i][j] = max(dp[i][j], land[i][j] + dp[i-1][k])

    return max(dp[len(land)-1])