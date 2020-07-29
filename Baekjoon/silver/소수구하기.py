m,n=map(int,input().split())
sosu=set(range(2,n+1))
for i in range(2,n+1):
    if i in sosu:
        sosu-=set(range(2*i,n+1,i))
answer=[]

for i in sosu:
    if i>=m and i<=n:
        answer.append(i)
for i in answer:
    print(i)