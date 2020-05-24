def solution(total_sp, skills):
    # 키 값의 형태로 선행, 상위스킬 표현
    skillsRelations = dict()
    skills.sort()
    for i in skills :
        if i[0] in skillsRelations.keys() :
            skillsRelations[i[0]].append(i[1])
        else :
            skillsRelations[i[0]] = [i[1]]

    point = int(pow(total_sp,1/len(skillsRelations))) # 스킬트리 말단에 부여되는 스킬 포인트 


    skillpoints = dict() # 스킬 별 스킬 포인트 저장 자료구조

    # 하위 스킬 포인트 지정
    for skill in skillsRelations.values() :
        for i in skill :
            if i not in skillsRelations.keys() :
                skillpoints[i] = point
    
    
    while len(skillpoints) != len(skills) + 1 :
        for key in skillsRelations.keys() :
            pt = 0
            for val in skillsRelations[key] :
                if val in skillpoints.keys() :
                    pt += skillpoints[val]
                    state = True
                else :
                    state = False
                    break
            if state == True :
                skillpoints[key] = pt

    answer = []
    for i in sorted(skillpoints.items()) :
        answer.append(i[1])
    return answer


print(solution(121,	[[1, 2], [1, 3], [3, 6], [3, 4], [3, 5]]))	#[44, 11, 33, 11, 11, 11]

