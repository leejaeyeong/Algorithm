import collections

def solution(bridge_length, weight, truck_weights):
    truck = collections.deque(truck_weights)
    time = 0

    ing = collections.deque([])
    ingTime = collections.deque([])
    
    #print(solution(2,10,[7,4,5,6])) 

    ing.append(truck.popleft())
    ingTime.append(1)
    while True :
        time = time + 1
        
        ing_c = 0
        for i in truck :
            if weight-sum(ing)-i >= 0 :
                time = time + 1
                ing_c = ing_c + 1
                ing.append(i)
                ingTime.append(time)
            else :
                break

        
        for i in range(ing_c) :
            del truck[0]

        ing_c = 0
        if len(ing) != 0 :
            if time - ingTime[0] >= bridge_length :
                ing.popleft()
                ingTime.popleft()

                for i in truck :
                    if weight-sum(ing)-i >= 0 :
                        ing_c = ing_c + 1
                        ing.append(i)
                        ingTime.append(time)
                    else :
                         break
                
                for i in range(ing_c) :
                    del truck[0]

            else :
                continue
        
        if len(ing) == 0 and len(ingTime) == 0 and len(truck) == 0:
            return time