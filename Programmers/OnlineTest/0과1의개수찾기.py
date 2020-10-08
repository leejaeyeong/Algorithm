def allSame(arr,result):
    base=arr[0][0]    
    rows=len(arr)
    cols=len(arr[0])
    maxArrCnt,minArrCnt = rows*cols,0
    totalCnt=0
    for i in arr:
        totalCnt+=sum(i)

    if totalCnt==maxArrCnt or totalCnt==minArrCnt:
        result.append(0) if base==0 else result.append(1)
        return 
    
    temp1,temp2,temp3,temp4=[],[],[],[]
    temps=[temp1,temp2,temp3,temp4]

    for i in range(rows//2):
        sub1=[]
        sub2=[]
        for j in range(cols//2):
            sub1.append(arr[i][j])
        for j in range(cols//2,cols):
            sub2.append(arr[i][j])
        temp1.append(sub1)
        temp2.append(sub2)

    for i in range(rows//2,rows):
        sub1=[]
        sub2=[]
        for j in range(cols//2):
            sub1.append(arr[i][j])
        for j in range(cols//2,cols):
            sub2.append(arr[i][j])
        temp3.append(sub1)
        temp4.append(sub2)
    
    for i in temps:
        allSame(i,result)

def solution(arr):
    zero_one_list=[]
    allSame(arr,zero_one_list)
    return [zero_one_list.count(0),zero_one_list.count(1)]

print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))
print(solution([[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]))