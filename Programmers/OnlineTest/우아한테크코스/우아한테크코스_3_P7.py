def solution(n, horizontal):
    maps = [[0 for _ in range(n)] for _ in range(n)]
    already_right_step=False
    already_bottom_step=False
    is_upwards=False
    val=0
    y,x=0,0
    for i in range(n*n-1):
        if (y==0 or y==n-1) and not already_right_step:
            already_right_step=True
            x+=1
            val+=1
        elif (y==0 or y==n-1) and already_right_step:
            if y==0:
                y+=1
                x-=1
                is_upwards=False
            elif y==n-1:
                y-=1
                x+=1
                is_upwards=True
            val+=2
            already_right_step=False
        elif (x==0 or x==n-1) and not already_bottom_step:
            already_bottom_step=True
            y+=1
            val+=1
        elif (x==0 or x==n-1) and already_bottom_step:
            if x==0:
                y-=1
                x+=1
                is_upwards=True
            elif x==n-1:
                y+=1
                x-=1
                is_upwards=False
            val+=2
            already_bottom_step=False
        elif is_upwards:
                y-=1
                x+=1
                val+=2
        elif not is_upwards:
                x-=1
                y+=1
                val+=2
        maps[y][x]=val

    if horizontal:
        return maps
    maps=[[maps[i][j] for i in range(len(maps[j]))] for j in reversed(range(len(maps)))]
    rotaed_map=[]
    for i in range(len(maps)-1,-1,-1):
        rotaed_map.append(maps[i])
    return rotaed_map

print(solution(4,True))
#print(solution(5,True))