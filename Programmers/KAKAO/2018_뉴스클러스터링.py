import string
def solution(str1, str2):
    
    alphabet = string.ascii_letters[:26]

    str1, str2 = str.lower(str1), str.lower(str2)
    str1Array, str2Array = [],[]

    for i in range(len(str1)-1) :
        if str1[i] in alphabet and str1[i+1] in alphabet :
            str1Array.append(str1[i]+str1[i+1])

    for i in range(len(str2)-1) :
        if str2[i] in alphabet and str2[i+1] in alphabet :
            str2Array.append(str2[i]+str2[i+1])

    intersectionCnt, unionCnt = 0, 0
    alreadyProcess = []
    # 교집합, 합집합 구하기 
    for i in str1Array :
        if i not in alreadyProcess :
            str1Count = str1Array.count(i)
            str2Count = str2Array.count(i)
            unionCnt += max(str1Count, str2Count)
            if str2Count != 0 :
                intersectionCnt += min(str1Count, str2Count)
            alreadyProcess.append(i)
                
    # 합집합 구하기
    for i in str2Array :
        if i not in alreadyProcess :
            unionCnt += str2Array.count(i)
            alreadyProcess.append(i)

    if unionCnt == 0 :
        return 65536
    return int((intersectionCnt / unionCnt)*65536)


print(solution('FRANCE','french'),16384) #
print(solution('handshake','shake hands'),65536) #
print(solution('aa1+aa2','AAAA12'),43690) #
print(solution('E=M*C^2','e=m*c^2'),65536) #

	
	


