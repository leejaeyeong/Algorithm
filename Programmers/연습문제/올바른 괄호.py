def solution(s):
    stack = []
    for i in s :
        if i == '(' :
            stack.append(i)
        else :
            try :
                stack.pop()
            except :
                return False
    if len(stack) == 0:
        return True
    else :
        return False