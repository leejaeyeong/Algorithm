rows, cols = map(int,input().split())
arr = [[0 for col in range(cols)] for row in range(rows)] # 5x5 배열 생성

startRow, endRow = 0, rows
startCol, endCol = 0, cols
i, j = 0,0
cnt=0
for num in range(1,rows*cols+1) :
    if rows==2 or cols==2:
        break
    arr[i][j] = num 
    if i == startRow and j + 1 != endCol and arr[i][j+1] == 0 :
        j += 1
        if j + 1 == endCol :
            startRow += 1
            cnt+=1
    elif j == endCol-1 and i + 1 != endRow and arr[i+1][j] == 0 :
        i += 1
        if i + 1 == endRow :
            endCol -= 1
            cnt+=1
    elif i == endRow-1 and  j - 1 >= startCol and arr[i][j-1] == 0 :
        j -= 1
        if j - 1 < startCol :
            endRow -= 1
            cnt+=1
    elif j == startCol and i - 1 >= startRow and arr[i-1][j] == 0 :
        i -= 1
        if i - 1 <  startRow :
            startCol += 1
            cnt+=1
if rows==2 or cols==2:
    print(2)
else:
    print(cnt-1)

#for i in arr :
 #   print(i)