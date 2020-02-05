def solution(s):
    stack = []
    for i in range(len(s)) :
        if len(stack) == 0 :
            stack.append(s[i]) 
        else :
            stack.pop() if stack[len(stack)-1] == s[i] else stack.append(s[i])
    return 1 if len(stack) == 0 else 0

# Stack으로 해결