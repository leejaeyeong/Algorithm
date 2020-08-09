def isbalanced(s): # 균형 잡힌 문자열인 경우 
    check=0
    for i in s:
        if i=='(':
            check+=1
        else:
            check-=1
    if check==0:
        return True
    return False

def is_correct(s): # 올바른 문자열인ㄱ ㅕㅇ우 
    stack=[s[0]]
    for i in range(1,len(s)):
        if len(stack)==0 or s[i]=='(':
            stack.append(s[i])
        else:
            stack.pop()
    if len(stack)==0: 
        return True
    return False


def solution(p):
    answer=''
    u=''
    v=''
    if len(p)==0:
        return p
    
    for i in range(2,len(p)+1,2):
        if isbalanced(p[:i]):
            u=p[:i]
            v=p[i:]
            break
    
    if is_correct(u):
        answer+=u+solution(v)
    else:
        answer+='('+solution(v)+')'
        for c in u[1:-1]:
            if c=='(':
                answer+=')'
            else:
                answer+='('
    return answer

print(solution('(()())()'))
print(solution(')('))
print(solution('()))((()'))

