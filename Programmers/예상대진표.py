def solution(n,a,b):
  answer = 0
  while(a>0) :
    answer += 1
    a = (a+1)//2
    b = (b+1)//2
    if a==b:
      return answer
  return answer