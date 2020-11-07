def solution(grades, weights, threshold):
    grade_map={'A+':10,'A0':9,'B+':8,'B0':7,'C+':6,'C0':5,'D+':4,'D0':3,'F':0}
    user_score=0
    for index, grade in enumerate(grades):
        user_score+=grade_map[grade]*weights[index]
    return user_score-threshold

print(solution(["A+","D+","F","C0"]	,[2,5,10,3],50))
print(solution(["B+","A0","C+"]	,[6,7,8],200))