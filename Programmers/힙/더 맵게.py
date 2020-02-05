import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0 

    while True :
        if scoville[0] < K and len(scoville) > 1:
            minVal = heapq.heappop(scoville)
            minnVal = heapq.heappop(scoville)
            heapq.heappush(scoville, minVal + 2*minnVal)
            cnt = cnt + 1
        elif scoville[0] >= K :
            return cnt
        else : return -1