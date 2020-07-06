"""소문자로만 구성된 문자열 목록이 있을 때, 모든 문자열에 공통으로 등장하는 문자를 알파벳 순으로 출력하시오.
만약 특정 문자가 여러 번 등장하면 등장한 만큼 출력되어야 한다. 예를들어 4개의 문자열에 a가 각각
3, 3, 6, 5번 등장하였다면 답에 a가 3번 출력되어야 한다."""

n = int(input())
for i in range(n):
    x = int(input())
    strings = [s for s in input().split(' ')]
    answer = ''
    for j in range(len(strings[0])):
        cnt = 9999
        target = strings[0][j]
        for k in range(1,len(strings)):
            if target not in strings[k]:
                break
            else :
                val = strings[k].count(target) 
                if val < cnt:
                    cnt = val
                if k == len(strings)-1:
                    if target not in answer:
                        answer += target*cnt
    print(answer)
            
