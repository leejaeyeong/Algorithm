def solution(skill, skill_trees):
    answer = len(skill_trees)

    for i in skill_trees :
        valid = []
        for j in range(len(skill)) :
            valid.append(i.find(skill[j]))
        #print(i,'ÀÇ À¯È¿ÇÑ ½ºÅ³Àº',valid)

        preSkill = valid[0]
        for j in range(1,len(valid)) :
            if valid[j] > preSkill :
                preSkill = valid[j]
            else :
                #print('¸ØÃã')
                answer = answer - 1
                break
            if preSkill == -1 and valid[j] > -1 :
                answer = answer - 1
                break
                
        
    return answer