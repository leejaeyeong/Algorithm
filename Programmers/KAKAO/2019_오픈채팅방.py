def solution(record):
    answer = []
    ahash = {}

    for i in record :
        i = i.split()
        if i[0] != 'Leave' and i[1] not in ahash.keys() :
            ahash[i[1]] = i[2]
    
    for i in record :
        i = i.split()
        if i[0] == 'Enter' or i[0] == 'Change' and i[1] in ahash.keys() :
            ahash[i[1]] = i[2]
    
    for i in record :
        i = i.split()
        if i[0] == 'Enter' :
            answer.append(ahash[i[1]]+'���� ���Խ��ϴ�.')
        elif i[0] == 'Leave' :
            answer.append(ahash[i[1]]+'���� �������ϴ�.')

    return answer