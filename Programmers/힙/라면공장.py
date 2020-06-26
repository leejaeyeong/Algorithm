""" 라면 공장에서는 하루에 밀가루를 1톤씩 사용합니다. 원래 밀가루를 공급받던 공장의 고장으로 앞으로 
k일 이후에야 밀가루를 공급받을 수 있기 때문에 해외 공장에서 밀가루를 수입해야 합니다.

해외 공장에서는 향후 밀가루를 공급할 수 있는 날짜와 수량을 알려주었고, 라면 공장에서는 
운송비를 줄이기 위해 최소한의 횟수로 밀가루를 공급받고 싶습니다.

현재 공장에 남아있는 밀가루 수량 stock, 밀가루 공급 일정(dates)과 해당 시점에 공급 가능한 
밀가루 수량(supplies), 원래 공장으로부터 공급받을 수 있는 시점 k가 주어질 때, 밀가루가 떨어지지 않고 
공장을 운영하기 위해서 최소한 몇 번 해외 공장으로부터 밀가루를 공급받아야 하는지를 return 하도록 solution 함수를 완성하세요. """

import collections
def solution(stock, dates, supplies, k):
  dates = collections.deque(dates)
  supplies = collections.deque(supplies)
  answer = 0
  li = []
  while stock < k:
    while len(dates) > 0 and dates[0] <= stock: 
        dates.popleft()
        li.append(supplies.popleft())

    confirmed_supply = max(li)
    li.remove(confirmed_supply)
    stock += confirmed_supply
    answer += 1

  return answer

print(solution(4,[4,10,15],[20,5,10],30))