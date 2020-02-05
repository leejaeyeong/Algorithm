def solution(s, n):
    x = ""
    for i in range(len(s)) :
        asc = ord(s[i])
        if asc not in range(65,91) and asc not in range(97,123) :
            x = x + " "
            continue 
        elif asc in range(65,91) and asc+n > 90 :
            asc = asc + n - 26
            x = x + chr(asc)
        elif asc in range(97,123) and asc+n > 122 :
            asc = asc + n - 26
            x = x + chr(asc)
        else :
            asc = asc + n
            x = x + chr(asc)

    return x