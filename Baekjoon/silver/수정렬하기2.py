# https://www.acmicpc.net/board/view/31887
import sys
import heapq
def heap_sort(nums):
    heap=[]
    for i in nums:
        heapq.heappush(heap,i)
    answer=[]
    while heap:
        answer.append(heapq.heappop(heap))
    return answer

n=int(input())
nums=[int(sys.stdin.readline()) for i in range(n)]
nums=heap_sort(nums)
[print(num) for num in nums]