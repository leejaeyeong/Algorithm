import string
def solution(s):
    lower_dictionary=string.ascii_lowercase
    upper_dictionary=string.ascii_uppercase # 26
    answer=''
    for i in s:
        if i==' ':
            answer+=' '
        elif i.islower():
            answer+=lower_dictionary[25-lower_dictionary.index(i)]
        elif i.isupper():
            answer+=upper_dictionary[25-upper_dictionary.index(i)]
    return answer
print(solution('I love you'))