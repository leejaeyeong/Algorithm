def solution(n):
    fa, fb, sum = 0, 1, 0
    for i in range(n-1) :
        sum = fa + fb
        fa = fb
        fb = sum
    return sum % 1234567

# Çò°¥¸®³×