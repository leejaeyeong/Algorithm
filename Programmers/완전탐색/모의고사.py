def solution(answers):
    G1,G2,G3 = [1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5] 
    p1, p2, p3 = 0,0,0
    
    for i in range(len(answers)) :
        if answers[i] == G1[i % len(G1)] :
            p1 = p1 + 1
        if answers[i] == G2[i % len(G2)] :
            p2= p2 + 1
        if answers[i] == G3[i % len(G3)] :
            p3= p3 + 1
            
    point = [p1,p2,p3]
    fivot = max(point)
    rs = []
    for i in range(len(point)) :
        if fivot == point[i] :
            rs.append(i+1)
    return rs