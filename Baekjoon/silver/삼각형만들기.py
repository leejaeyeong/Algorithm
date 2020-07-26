def check_triangle(a,b,c):
    return a+b+c if a<b+c else -1 # 삼각형 조건
    
n=int(input())
candidate=[]
for i in range(n):
    candidate.append(int(input()))
candidate.sort(reverse=True)

for i in range(2,len(candidate)):
    answer=check_triangle(candidate[i-2],candidate[i-1],candidate[i])
    if answer!=-1:
        break
print(answer)