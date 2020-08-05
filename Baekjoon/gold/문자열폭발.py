s=input()
bomb_s=input()
bomb_len=len(bomb_s)
answer=[]

for i in s:
    answer.append(i)
    if len(answer)>=bomb_len:
        if answer[-1]==bomb_s[-1]:
            compare_s=''.join(answer[-bomb_len:])
            if compare_s==bomb_s:
                for j in range(bomb_len):
                    answer.pop()
print(''.join(answer)) if len(answer)!=0 else print('FRULA')