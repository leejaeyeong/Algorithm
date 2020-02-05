def solution(s):
    state = False
    x = ''
    for i in range(len(s)) :
        if state == False and s[i] != ' ':
            x = x + str.upper(s[i])
            state = True
        elif state == True and s[i] != ' ' :
            x = x + str.lower(s[i])
        elif s[i] == ' ' :
            x = x + ' '
            state = False
    return x