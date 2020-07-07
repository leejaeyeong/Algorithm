# 다시 풀어보기
def solution(s):
  nums='0123456789'
  elements=[]
  state = False
  temp=''
  s=[i for i in s[1:len(s)-1]]

  convert_x_state = False
  for i in range(len(s)):
    if s[i] == '{':
      convert_x_state=True
    elif s[i] == '}':
      convert_x_state=False
    elif convert_x_state and s[i] == ',':
      s[i]='x'

  for i in range(s.count(',')):
    s.remove(',')

  for i in range(len(s)):
    if s[i]=='x':
      s[i]=','
  
  sub=[]
  for i in range(len(s)):
    if s[i]=='{':
      state=True
    elif s[i] =='}':
      state=False
      sub.append(int(temp))
      elements.append(sub)
      temp=''
      sub=[]
    elif state:
      if s[i] in nums:
        temp+=s[i]
      elif s[i] == ',':
        sub.append(int(temp))
        temp=''

  elements.sort(key=len)
  answer=[elements[0][0]]
  
  for i in range(1,len(elements)):
    for j in range(len(elements[i])):
      if elements[i][j] not in answer:
        answer.append(elements[i][j])
        break
  return answer

  
print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))
print(solution("{{20,111},{111}}"))
print(solution("{{123}}"))
print(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))



"""
def solution(s):
    answer = []

    s1 = s.lstrip('{').rstrip('}').split('},{')

    new_s = []
    for i in s1:
        new_s.append(i.split(','))

    new_s.sort(key = len)

    for i in new_s:
        for j in range(len(i)):
            if int(i[j]) not in answer:
                answer.append(int(i[j]))

    return answer
"""