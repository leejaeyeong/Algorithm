def solution(s):
    convert_cnt=0
    zero_cnt=0
    while s != '1':
        convert_cnt+=1
        zero_cnt+=s.count('0')
        step1='1'*(len(s)-s.count('0'))
        s = bin(len(step1))[2:]
    return [convert_cnt,zero_cnt]

print(solution("110010101001"))
print(solution("01110"))
print(solution("1111111"))