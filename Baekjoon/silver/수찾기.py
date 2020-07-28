n=int(input())
nlist=list(map(int,input().split()))
m=int(input())
mlist=list(map(int,input().split()))

def quick_sort(arr) :
    if len(arr) <= 1 : 
        return arr
    pivot = arr[len(arr)//2]
    less_arr, equal_arr, big_arr = [], [], []
    for i in arr :
        if i < pivot :
            less_arr.append(i)
        elif i > pivot :
            big_arr.append(i)
        else :
            equal_arr.append(i)
    return quick_sort(less_arr) + equal_arr + quick_sort(big_arr)

def isIn(m,nlist): # 이진탐색
    start,end=0,len(nlist)-1
    while start<=end:
        idx=(start+end)//2
        if target==nlist[idx]:
            return True
        elif target>nlist[idx]:
            start=idx+1
        else:
            end=idx-1
    return False

nlist=quick_sort(nlist)
for target in mlist:
    print(1) if isIn(target,nlist) else print(0)
