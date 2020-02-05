def solution(s):
    s = list(map(int,s.split(' ')))
    return ''.join(str(min(s))+' '+str(max(s)))