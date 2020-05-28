def DFS(y,x)  :
    for i in range(y) :
        if y == prev_y[i] or x == prev_x[i] or abs(x-prev_x[i]) == abs(y-prev_y[i]):
            return 0

    if y == N-1 :
        return 1

    prev_y[y] = y
    prev_x[y] = x
    
    r = 0
    for i in range(N) :
        r += DFS(y+1,i)
    return r
    
prev_x = [0]*15
prev_y = [0]*15
N = int(input())
r = 0
for i in range(N) :
    r += DFS(0,i)
print(r)