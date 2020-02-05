def solution(n, m):
    answer = []
    small = min(m,n)
    bigger = max(m,n)
    # 최대공약수
    while True :
        if small == 1 :
            answer.append(1)
            break
        else :
            if m % small == 0 and n % small == 0 :
                answer.append(small)
                break 
            else :
                small = small - 1
    # 최소공배수
    while True :
        if bigger == m*n :
            answer.append(bigger)
            break
        else :
            if bigger % n == 0 and bigger % m == 0 :
                answer.append(bigger)
                break
            else :
                bigger = bigger + 1
            
    return answer