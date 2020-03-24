def solution(w,h):
    min_val,max_val = min(w,h), max(w,h)
    gcd = 0
    #최대 공약수 구하기
    for i in range(min_val,0,-1) :
        if max_val % i == 0 and min_val % i == 0 : 
           gcd = i 
           break
    
    # 전체 사각형에서 잘린 사격형을 빼줌
    block = w*h
    wholeHeigt = h
    w = w // gcd
    h = h // gcd 
    for i in range(0,wholeHeigt,h) :
        block += -w-h+1

    return block
    

    



# w, h
print(solution(8,12)) # 80