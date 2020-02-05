def solution(s)
    len_s = len(s) 
    s = s.split(' ')
    x = 
    for i in range(len(s)) 
        if i  0 
            x = x + ' '
        for j in range(len(s[i])) 
            if j % 2 == 0 
                x = x + str(s[i][j]).upper()
            else 
                x = x + str(s[i][j]).lower()
    for i in range(len_s - len(x)) 
        x = x + ' '
    return x