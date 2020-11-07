def solution(n):
    answer=[]
    maps=[[0 for _ in range(n)] for _ in range(n)]
    y,x=-1,0
    number=1
    for i in range(n):
        for _ in range(i,n):
            if i%3==0:
                y+=1
            elif i%3==1:
                x+=1
            elif i%3==2:
                y-=1
                x-=1
            maps[y][x]=number
            number+=1
    for x in maps:
        answer.extend(x)
    return [x for x in answer if x!=0]
            
        

        

print(solution(4))
print(solution(5))
print(solution(6))