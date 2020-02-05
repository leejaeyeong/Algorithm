from collections import Counter
def solution(clothes):
    kindList = Counter([kind for name, kind in clothes])
    value = 1
    for i in kindList.values() :
        value = value*(i+1)
    return value - 1