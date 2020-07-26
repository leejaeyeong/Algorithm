def toggle(arr,row,col):
    for i in range(row,row+3):
        for j in range(col,col+3):
            arr[i][j]='1' if arr[i][j]=='0' else '0'

def is_equal(arr1,arr2):
    for i in range(n):
        for j in range(m):
            if arr1[i][j]!=arr2[i][j]:
                return False
    return True

n,m=map(int,input().split())
arr1,arr2=[],[]
for i in range(n):
    arr1.append(list(input()))
for i in range(n):
    arr2.append(list(input()))

cnt=0
for row in range(n-2):
    for col in range(m-2):
        if arr1[row][col]!=arr2[row][col]:
            cnt+=1
            toggle(arr1,row,col)
print(cnt) if is_equal(arr1,arr2) else print(-1)