def solution(money, expected, actual):
    betting_money=100
    for index, expect in enumerate(expected):
        if money<=betting_money:
            betting_money=money
        
        if expect==actual[index]:
            money+=betting_money
            betting_money=100
        else:
            money-=betting_money
            betting_money*=2
            
        if money==0:
            return money
    return money


print(solution(1000,['H', 'T', 'H', 'T', 'H', 'T', 'H'],['T', 'T', 'H', 'H', 'T', 'T', 'H']))
print(solution(1200,['T', 'T', 'H', 'H', 'H'],['H', 'H', 'T', 'H', 'T']))
print(solution(1500,['H', 'H', 'H', 'T', 'H'],['T', 'T', 'T', 'H', 'T']	))