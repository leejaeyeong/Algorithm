def solution(n):
    n3=convert(n,3)
    reversed_n3=n3[::-1]
    n10=int(reversed_n3,3)
    return n10

def convert(n,base):
    T='0123456789ABCDEF'
    q,r=divmod(n,base)
    if q==0:
        return T[r]
    else:
        return convert(q,base) + T[r]

print(solution(45))