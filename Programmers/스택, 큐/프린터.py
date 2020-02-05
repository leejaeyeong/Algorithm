import collections

def solution(priorities, location):
    d = 0 
    priorities = collections.deque(priorities)
    
    while(True) :
        target = priorities.popleft()
        location = location - 1
        if len(priorities) == 0 :
            return d + 1
        elif target >= max(priorities) :
            d = d + 1
            if location == -1 :
                return d
        else :
            priorities.append(target)
            if location == -1 :
                location = len(priorities)-1