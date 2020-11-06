import string
def solution(n):
    answer=0
    for num in range(1,n+1):
        for check in str(num):
            if check=='3' or check=='6' or check=='9':
                answer+=1
    return answer


print(solution(13))
print(solution(33))