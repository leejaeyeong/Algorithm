n=int(input())
in_=[]
for i in range(n):
    in_.append(int(input()))
stack=[]
result=[]
num=1
state=False
for i in in_:
    while num<=i:
        stack.append(num)
        result.append('+')
        num+=1
    if stack.pop() != i:
        print('NO')
        state=True
        break
    else:
        result.append('-')

if not state:
    [print(x,end='\n') for x in result]
    

