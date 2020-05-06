""" 튜브가 활동하는 코딩 동아리에서는 전통적으로 해오는 게임이 있다. 이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.

1. 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
2. 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다 """

def solution(n, t, m, p):
    fo = {'10':'A','11':'B','12':'C','13':'D','14':'E','15':'F'}
    ls = ['0']
    num = 1
    while len(ls) <= t*m :
        temp = []
        x = num
        while x >= n :
            temp.append(x % n)
            x = x // n
        temp.append(x)
        temp.reverse()
        for i in temp : 
            ls.append(str(i))
        
        num += 1

    result = ''
    for i in range(p-1,t*m,m) :
        if len(ls[i]) > 1 :
            result = result + fo[ls[i]]
        else :
            result = result + ls[i]
    return result

print(solution(16,	16,	2,	1),	'\n02468ACE11111111')
print(solution(16,	16,	2,	2),	'\n13579BDF01234567')
print(solution(2, 4, 2,	1),'\n0111')

