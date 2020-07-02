# 그냥 list 쓰면 더 간단..
import collections
def solution(cacheSize, cities):
    answer = 0
    cities = [str.upper(x) for x in cities]
    cache_list = collections.deque([])
    for i in cities :
      if i in cache_list :
        answer += 1
        for j in range(cache_list.index(i),len(cache_list)-1,1) :
          cache_list[j] = cache_list[j+1]
        cache_list.pop()
        cache_list.appendleft(i)
        continue
      answer += 5
      # 캐시 교환하는 로직
      if len(cache_list) < cacheSize :
        cache_list.appendleft(i)
      else :
        if len(cache_list) != 0 :
          cache_list.pop()
          cache_list.appendleft(i)
    return answer

print(solution(3,['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA']))# 50
print(solution(3,	['Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul']))	#21
print(solution(2,	['Jeju', 'Pangyo', 'NewYork', 'newyork']))	#16
print(solution(0,	['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA']))	#25
