""" 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

예를들면, 문자열 s가 abcdcba이면 7을 return하고 abacde이면 3을 return합니다. """

def checkPelindrome(s,types) :
    answer = 0 
    for i in range(1, len(s)-1) :
        cnt = 0
        
        if s[i] != s[i+1] and types == 'even' :
            continue
        else :
            for j in range(i+1,len(s)) :
                if types == 'even' :
                    front, back = j+1, 2*i - j
                else :
                    front, back = j, 2*i - j
                # 기준 문자를 제외한 나머지 문자 대칭 비교 
                if front != len(s) and back != -1 :
                    if s[front] == s[back] :
                        cnt += 1
                    else :
                        break
                else :
                    break
            if cnt > answer :
                answer = cnt
    return answer
    

def solution(s):
    x = checkPelindrome(s,'odd')
    y = checkPelindrome(s,'even')
    if len(s) == 1 or len(s) == 0 : return 1
    if x == 0 and y == 0 : return 1
    return x*2+1 if x > y else y*2+2
    


# test case 
print(solution('xabcdcbax'),9)
print(solution('abacde'),3)
print(solution('abccba'),6) 
print(solution('abcxxcba'),8) 
print(solution('abccb'),4)
print(solution('xabcdcbaxaaaaaaxxaaaaaa'),14)
print(solution('xabcdcbax'),9)
print(solution(''),1)

print(solution('abcde'),1)



