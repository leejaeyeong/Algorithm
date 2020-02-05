def solution(h)
    h.reverse()
    answer = [0]len(h)
    for i in range(len(h)-1) 
        for j in range(i+1,len(h)) 
            if h[i]  h[j] 
                answer[i] = len(h)-j
                break
    return answer[-1]