''' 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 
2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 
구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 '''
# 인덱스를 이용한 방법
def solution(people, limit):
    people.sort()
    escapeCnt, light, heavy = 0, 0, len(people)-1
    while light < heavy :
        if people[light] + people[heavy] <= limit :
            light += 1
            heavy -= 1 
            escapeCnt += 1
        else :
            heavy -= 1 
    return len(people) - escapeCnt 


print(solution([70,50,80,50],100))
print(solution([70,80,50],100))


# list del 삭제 연산 후 list 재조정 시간으로 인해 효율성 1번 시간초과 
''' def solution(people, limit):
    people.sort()
    cnt = 0
    while len(people) > 1 :
        if people[0] + people[-1] <= limit :
            del people[0]
            del people[-1]
            cnt += 1
        else :
            del people[-1]
            cnt += 1
    return cnt + len(people)   '''




# dequeue를 이용해 삭제를 처리한 경우
# list의 pop(), leftpop()이 list의 처음 또는 마지막 값이기 때문에 재조정이 따로 없는듯하다. 
''' import collections
def solution(people, limit):
    people = collections.deque(sorted(people))
    cnt = 0
    while len(people) > 1 :
        if people[0] + people[-1] <= limit :
            people.popleft()
            people.pop()
            cnt += 1
        else :
            people.pop()
            cnt += 1
    return cnt + len(people) '''