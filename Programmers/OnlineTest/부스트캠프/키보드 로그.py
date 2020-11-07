keyboard = [["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"],
            ["Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"],
            ["A", "S", "D", "F", "G", "H", "J", "K", "L", ";"],
            ["Z", "X", "C", "V", "B", "N", "M", ",", ".", "?"]]

def get_key_location(val): # 찾는 값의 좌표를 알려주는 함수
    for i in range(len(keyboard)):
        for j in range(len(keyboard[i])):
            if keyboard[i][j]==val:
                return [i,j]

def solution(word):
    current_location=[0,0] # 시작 좌표
    answer = ''
    for i in word:
        key_location=get_key_location(i)
        # 최근 위치와 타겟 좌표사이의 거리 값 계산
        distance_y,distance_x=abs(key_location[0]-current_location[0]),abs(key_location[1]-current_location[1])

        # 거리 차가 없을 경우 현재 위치가 타겟
        if distance_y==0 and distance_x==0:
            answer+='@'
            continue
        if key_location[0]>current_location[0]:
            answer+='_'*distance_y
        elif key_location[0]<current_location[0]:
            answer+='^'*distance_y

        if key_location[1]<current_location[1]:
            answer+='<'*distance_x
        elif key_location[1]>current_location[1]:
            answer+='>'*distance_x

        answer+='@'
        # 최근 위치 갱신
        current_location[0]=key_location[0] 
        current_location[1]=key_location[1]
    return answer