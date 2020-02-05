import math
def solution(n):
    n = list(map(int,str(math.sqrt(n)).split('.')))
    return -1 if n[1] != 0 else pow(n[0] + 1,2)