from queue import PriorityQueue

def dijkstra(road,N):
    INF = 987654321
    dist = [INF for i in range(N+1)] # 마을의 거리 정보 리스트
    
    road.sort()
   
    pq = PriorityQueue()
    # 1번 마을은 최소 거리가 0임을 의미
    pq.put([1,0]) # 거리, 마을 번호
    dist[1] = 0
    while not pq.empty():
        here,cost = pq.get()
        # 비용이 더 크면 처리할 최소가 아님
        if cost > dist[here]: 
            continue
        for i in range(len(road)):
            if road[i][0] == here: 
                target = road[i][1]
            elif road[i][1] == here: 
                target = road[i][0]
            else : 
                continue

            nextCost = road[i][2]+cost
            if nextCost < dist[target]:
                dist[target] = nextCost
                pq.put([target,nextCost])
    return dist

def solution(N, road, K):
    answer = 0
    dist = dijkstra(road,N)
    for d in dist:
        if d <= K:
            answer+=1
    return answer

    
print(solution(5,[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]],3)) # 4
print(solution(6,[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]],4)) # 4