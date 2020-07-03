# 풀이 1
def solution(N, stages):
    fail_rates = []
    for i in range(1,N+1) :
      unsucceeded, arived = 0, 0
      for j in stages :
        if j >= i : # 스테이지에 도달
          arived += 1
          if j == i : # 스테이지 클리어 못함
            unsucceeded += 1
      fail_rates.append(0) if arived == 0 else fail_rates.append(unsucceeded/arived)
    
    answer = []
    for j in range(N) :
      idx = fail_rates.index(max(fail_rates))
      answer.append(idx+1)
      fail_rates[idx] = -1
    return answer

# 풀이 2
def solution2(N, stages):
    fail_rates = {}
    for i in range(1,N+1) :
      unsucceeded, arived = 0, 0
      for j in stages :
        if j >= i : # 스테이지에 도달
          arived += 1
          if j == i : # 스테이지 클리어 못함
            unsucceeded += 1
      fail_rates[i] = 0 if arived == 0 else  unsucceeded/arived
    
    return sorted(fail_rates,key=lambda x: fail_rates[x], reverse=True)
    # 또는 return sorted(fail_rates,key=fail_rates.get, reverse=True)


print(solution(5,	[2, 1, 2, 6, 2, 4, 3, 3]))	#[3,4,2,1,5]
print(solution(4,	[4,4,4,4,4]))	#[4,1,2,3]