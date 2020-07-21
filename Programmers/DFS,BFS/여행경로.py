from collections import defaultdict 

def dfs(graph, N, key, footprint):
    print(footprint) # 이동 경로 출력

    if len(footprint) == N + 1: # 모든 경로를 거치면 return
        return footprint

    for idx, country in enumerate(graph[key]):
        # 도착한 경로를 graph에서 삭제
        graph[key].pop(idx)
        tmp = footprint[:]
        tmp.append(country)

        ret = dfs(graph, N, country, tmp) # 갱신된 경로로 이동 경로 확인
        
        graph[key].insert(idx, country)

        if ret:
          return ret

def solution(tickets):
    answer = []

    graph = defaultdict(list)

    N = len(tickets)
    for ticket in tickets: # 출발지 별로 dict 정리
        graph[ticket[0]].append(ticket[1])
        graph[ticket[0]].sort()

    answer = dfs(graph, N, "ICN", ["ICN"])
    return answer

x=[['ICN','BOO' ], [ 'ICN', 'COO' ], [ 'COO', 'DOO' ], ['DOO', 'COO'], [ 'BOO', 'DOO'] ,['DOO', 'BOO'], ['BOO', 'ICN' ], ['COO', 'BOO']]
print(solution(x))