n=int(input())
nums=list(map(int,input().split()))
sosu=set(range(2,1001))
for i in range(2,1001):
    if i in sosu:
        sosu-=set(range(2*i,1001,i))
cnt=0
for i in nums:
    if i in sosu:
        cnt+=1
print(cnt)