def solution(penter, pexit, pescape, data):
    answer=''
    print(len(data)//len(penter))
    for i in range(len(data)//len(penter)):
        divided_data=data[i*len(penter):(i+1)*len(penter)]
        if divided_data in [penter, pexit, pescape]:
            answer+=pescape+divided_data
        else:
            answer+=divided_data
    return penter+answer+pexit

print(solution("1100","0010","1001","1101100100101111001111000000"))
print(solution("10","11","00","00011011"))