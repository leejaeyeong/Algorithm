def solution(a, b):
    day  = ["THU","FRI", "SAT","SUN", "MON", "TUE", "WED"]
    count = [31,29,31,30,31,30,31,31,30,31,30,31]
    sum = 0
    if a == 1 :
        sum = b 
    else :
        for i in range(a-1) :
            sum = sum + count[i]
        sum = sum + b
    
    sum = sum % 7

        
    answer = day[sum]
    return answer