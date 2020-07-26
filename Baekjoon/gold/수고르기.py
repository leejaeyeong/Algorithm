# 투 포인터 문제
n,m=map(int,input().split()) 
li=[int(input()) for _ in range(n)]
li.sort()
front,back=0,0
answer=2000000001
while front!=len(li):
    val=li[back]-li[front]
    if val<=m and back != len(li)-1:
        back+=1
    else:
        front+=1
    if val>=m:
        answer=min(answer,val)
print(answer)