def solution(citations) :
    if set(citations) == {0} : return 0 

    citations.sort()
    for i in range(len(citations)) :
        if citations[i] >= len(citations) - i :
            return len(citations) - i