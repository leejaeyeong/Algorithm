def solution(A,B):
    A.sort()
    B.sort()
    return sum([A[i]*B[len(B)-i-1] for i in range(len(A))])