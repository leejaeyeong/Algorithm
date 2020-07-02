# 정확성 100, 효율성 73.8, 합계 91.3
def solution(cookie):
  max_cookie = sum(cookie)//2
  cookie_sum = [sum(cookie[0:i+1]) for i in range(len(cookie))]
  answer = 0
  for i in range(len(cookie)-1) :
    for j in range(i+1) :
      f_son = cookie_sum[i]
      if i != j :
        f_son -= cookie_sum[j]
      
      if f_son > max_cookie or f_son < answer :
        continue
      if f_son > cookie_sum[-1] - cookie_sum[j] :
        break
      
      for k in range(i+1,len(cookie)) : 
        s_son = cookie_sum[k] - cookie_sum[i]

        if f_son < s_son or s_son > max_cookie:
          break
        elif f_son == s_son :
          answer = max(f_son,answer)
          if answer == max_cookie :
            return answer
  return answer 

print(solution([1,1,2,3])) # 3
print(solution([1,2,4,5])) # 0
print(solution([3,3,3,3]))
print(solution([3,3,3,3,3,3]))

