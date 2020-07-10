def solution(files):
    nums='0123456789'
    head_ends=[]
    temp=[]
    for i in range(len(files)):
      for j in range(len(files[i])):
        if files[i][j] in nums:
          head_ends.append(j)
          break
        if j == len(files[i])-1:
          head_ends.append(len(files[i]))
    
    # head 영역
    for i in range(len(files)):
      temp.append([files[i][:head_ends[i]]])

    for i in range(len(files)):
      for j in range(len(files[i]),head_ends[i],-1):
        # number 영역 
        if files[i][head_ends[i]:j].isdigit():
          temp[i].append(files[i][head_ends[i]:j])
          # tail 영역 
          if j != len(files[i]):
            temp[i].append(files[i][j:len(files[i])])
          break

    files=sorted(temp,key=lambda x : (x[0].lower(),int(x[1]))) if len(temp[0])>=2 else sorted(temp,key=lambda x : (x[0].lower()))
    return [''.join([j for j in i]) for i in files ]

print(solution(['img12000.png', 'img0000.png', 'img02.png', 'img1.png', 'IMG01.GIF', 'img2.JPG']))
print(solution(['img12.png', 'img10.png', 'img02.png', 'img1.png', 'IMG01.GIF', 'img2.JPG']))
print(solution(['F-5 Freedom Fighter', 'B-50 Superfortress', 'A-10 Thunderbolt II', 'F-14 Tomcat']))
print(solution(['f-1.txt','f-212.txt','f-01.txt','f-0011.txt','f-10021.txt']))
print(solution(['F.txt','F','s','ssf','a0','s']))