def calculate(left_num,right_num,op):
    left_num,right_num=int(left_num),int(right_num)
    if op=='+':
        return left_num+right_num
    elif op=='-':
        return left_num-right_num
    return left_num*right_num

def solution(s, op):
    answer=[]
    for pivot in range(1,len(s)):
        left_words,right_words='',''
        for index, word in enumerate(s):
            if index<pivot:
                left_words+=word
            else:
                right_words+=word
        answer.append(calculate(left_words,right_words,op))
    return answer

print(solution('1234','+'))
print(solution('987987','-'))
print(solution('31402','*'))