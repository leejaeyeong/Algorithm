n,k = map(int,input().split())
arr=[1+i for i in range(n)]
answer=[]
idx=0
for _ in range(n):
    idx+=k-1
    if idx>=len(arr):
        idx=idx%len(arr)
    answer.append(arr.pop(idx))
print('<'+', '.join([str(x) for x in answer])+'>')

# prev_idx=0
# k_idx=0
# while len(answer) != n:
#     if arr[prev_idx] !=0:
#         prev_idx+=1
#         k_idx+=1
#         if k_idx == k:
#             k_idx=0
#             answer.append(arr[prev_idx-1])
#             arr[prev_idx-1]=0
#     else:
#         prev_idx+=1

#     if prev_idx == n:
#         prev_idx=0 
# print('<'+', '.join([str(x) for x in answer])+'>')