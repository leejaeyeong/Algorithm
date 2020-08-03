import sys
c,p=map(int,input().split())
base=list(map(int,input().split()))
answer=0
if p==1: 
    answer+=c
    for i in range(c-3):
        if base[i]==base[i+1] and base[i+1]==base[i+2] and base[i+2]==base[i+3]:
            answer+=1
elif p==2: 
    for i in range(c-1):
        if base[i]==base[i+1]:
            answer+=1
elif p==3:
    for i in range(c-2):
        if base[i]==base[i+1] and base[i+1]==base[i+2]-1:
            answer+=1
    for i in range(c-1):
        if base[i]==base[i+1]+1:
            answer+=1
elif p==4:
    for i in range(c-2):
        if base[i]==base[i+1]+1 and base[i+1]==base[i+2]:
            answer+=1
    for i in range(c-1):
        if base[i]+1==base[i+1]:
            answer+=1
elif p==5:
    for i in range(c-2):
        if base[i]==base[i+1] and base[i+1]==base[i+2]:
            answer+=1
        elif base[i]==base[i+2] and base[i+1]+1==base[i]:
            answer+=1
    for i in range(c-1):
        if base[i]+1==base[i+1]:
            answer+=1
        elif base[i]==base[i+1]+1:
            answer+=1
elif p==6:
    for i in range(c-2):
        if base[i]==base[i+1] and base[i]==base[i+2]:
            answer+=1
        if base[i]+1==base[i+1] and base[i+1]==base[i+2]:
            answer+=1
    
    for i in range(c-1):
        if base[i]-2==base[i+1]:
            answer+=1
        elif base[i]==base[i+1]:
            answer+=1
elif p==7:
    for i in range(c-2):
        if base[i]==base[i+1] and base[i]==base[i+2]:
            answer+=1
        elif base[i]==base[i+1] and base[i]==base[i+2]+1:
            answer+=1
    for i in range(c-1):
        if base[i]+2==base[i+1]:
            answer+=1
        elif base[i]==base[i+1]:
            answer+=1 

print(answer)