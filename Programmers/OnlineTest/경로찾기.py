graph_map = [('A', 'B', 1), ('A', 'C', 2), ('A', 'F', 4),
             ('B', 'D', 2), ('B', 'E', 1),
             ('C', 'D', 2),
             ('D', 'G', 1), ('D', 'K', 2),
             ('E', 'H', 1),
             ('F', 'G', 3),
             ('G', 'H', 1), ('G', 'I', 2), ('G', 'J', 3),
             ('H', 'J', 1), ('H', 'K', 2),
             ('I', 'J', 2)]

routes = []
distances = []

# 그래프의 노드를 탐색하면서 거리값을 계산하는 함수
def search_node(origin, dest, distance, route):
    if origin == dest:  # 출발지와 목적지가 같은 경우 현재까지 거리를 리스트에 추가
        global distances
        global routes
        distances.append(distance)
        routes.append(route+origin)
        return

    for node_info in graph_map:
        if node_info[1] == dest:  # 목적지로 가는 경로가 있으면 / 0:출발지, 1:목적지, 2:거리
            new_distance = distance+node_info[2]  # 거리 값 갱신
            new_route = route+node_info[1]
            search_node(origin, node_info[0], new_distance, new_route)  # 경로 변경 후 이어서 탐색

def solution(origin, dest):
    search_node(origin, dest, 0, '')
    if len(distances) == 0:
      return [-1]
    answer = {}
    for i in range(len(routes)):
      answer[routes[i][::-1]] = distances[i]
    return [i[1] for i in sorted(answer.items())]

#print(solution('C', 'D'))
print(solution('A', 'D'))
