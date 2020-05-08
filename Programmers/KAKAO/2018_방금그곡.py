""" 라디오를 자주 듣는 네오는 라디오에서 방금 나왔던 음악이 무슨 음악인지 궁금해질 때가 많다. 그럴 때 네오는 다음 포털의 '방금그곡' 서비스를 이용하곤 한다. 
방금그곡에서는 TV, 라디오 등에서 나온 음악에 관해 제목 등의 정보를 제공하는 서비스이다.

네오는 자신이 기억한 멜로디를 가지고 방금그곡을 이용해 음악을 찾는다. 
그런데 라디오 방송에서는 한 음악을 반복해서 재생할 때도 있어서 네오가 기억하고 있는 멜로디는 음악 끝부분과 처음 부분이 이어서 재생된 멜로디일 수도 있다. 
반대로, 한 음악을 중간에 끊을 경우 원본 음악에는 네오가 기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다. 그렇기 때문에 네오는 기억한 
멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교하려고 한다. 다음과 같은 가정을 할 때 네오가 찾으려는 음악의 제목을 구하여라. """

def solution(m, musicinfos):
    title = dict()
    music = []

    def changeFormat(melody) :
        melody = melody.replace('C#','c').replace('D#','d').replace('F#','f').replace('G#','g').replace('A#','a')
        return melody
    
    for i in musicinfos :
        i = i.split(',')
        startMinute = int(i[0].split(':')[0])*60 + int(i[0].split(':')[1])
        endMinute = int(i[1].split(':')[0])*60 + int(i[1].split(':')[1])
        runningMinute =  endMinute - startMinute
        
        i[3] = changeFormat(i[3])
        melody = ''
        for j in range(runningMinute) :
            melody = melody + i[3][j%len(i[3])]
        
        music.append(melody)
        title[melody] = i[2]

    answer = []
    for i in music :
        if changeFormat(m) in i :
            answer.append([i,len(i)])

    if len(answer) == 0 :
        return "(None)"
    maxAnswerLen = -1
    check = ''
    for i in answer :
        if maxAnswerLen < i[1] :
            maxAnswerLen = i[1]
            check = i[0]
    return title[check]


        

print(solution('ABCDEFG',['12:00,12:14,HELLO,CDEFGAB', '13:00,13:05,WORLD,ABCDEF']))
print(solution('CC#BCC#BCC#BCC#B',['03:00,03:30,FOO,CC#B', '04:00,04:08,BAR,CC#BCC#BCC#B']))
print(solution('ABC',['12:00,12:14,HELLO,C#DEFGAB', '13:00,13:05,WORLD,ABCDEF']))

# C, C#, D, D#, E, F, F#, G, G#, A, A#, B

# 각 음은 1분에 1개씩 재생된다. 

#  음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 

# 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.

# 조건 여러개 일치 시 재생된 시간이 제일 긴음악 제목 반환

# 없을 때는 none