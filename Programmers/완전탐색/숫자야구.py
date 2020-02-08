""" 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 
그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃

예를 들어, 아래의 경우가 있으면
A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 
가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
 """
def solution(baseball):
    posible = []
    # 유효한 범위는 중복 x, 1~9
    for i in range(123,987+1) :
        if str(i)[0] == str(i)[1] or str(i)[0] == str(i)[2] or str(i)[1] == str(i)[2] or str(i)[0] == '0' or str(i)[1] == '0' or str(i)[2] == '0' :
            continue
        else :
            posible.append(str(i))
    
    cnt = 0 
    # 가능한 모든 경우를 정답으로 가정하고
    # 문제에서 주어지는 num으로 strike, ball이 일치하는지 확인 
    for i in posible :
        flag = True 
        for j in baseball :
            predictNum = str(j[0])
            strike, ball = 0, 0 
            for k in range(3) :
                if i[k] == predictNum[k] :
                    strike += 1
                elif i.find(predictNum[k]) != -1 :
                    ball += 1
            if strike != j[1] or ball != j[2] :
                flag = False
                break
        if flag :
            cnt += 1
    return cnt


print(solution([[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]))

