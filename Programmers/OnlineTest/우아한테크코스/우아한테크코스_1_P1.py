# 오만, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원

def solution(money):
    answer=[]
    target=[10,50,100,500,1000,5000,10000,50000]
    while len(target)!=0:
        t=target.pop()
        answer.append(money//t)
        money-=(money//t)*t
    answer.append(money%10)
    return answer

print(solution(50237))
print(solution(15000))
print(solution(990000))