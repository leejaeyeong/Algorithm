import numpy as np
def solution(A, B):
    x = np.array(A)
    y = np.array(B)
    return (x*y).tolist()

# np 안쓰고 풀어보기