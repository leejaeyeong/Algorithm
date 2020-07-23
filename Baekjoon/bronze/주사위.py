s=list(map(int,input().split()))
result=[0]*(s[0]+s[1]+s[2]+1)
for i in range(1,s[0]+1):
    for j in range(1,s[1]+1):
        for k in range(1,s[2]+1):
            result[i+j+k]+=1
print(result.index(max(result)))