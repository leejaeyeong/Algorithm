def solution(n):
    n = [str(x) for x in str(n)] 
    return int(''.join(sorted(n,reverse=True)))