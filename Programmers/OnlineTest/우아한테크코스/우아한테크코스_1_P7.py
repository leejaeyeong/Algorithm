def is_overlap(cryptogram):
    for index in range(len(cryptogram)-1):
        if cryptogram[index]==cryptogram[index+1]:
            return True
    return False

def find_overlap_index(cryptogram):
    index_list=set()
    for index in range(len(cryptogram)-1):
        if cryptogram[index]==cryptogram[index+1]:
            index_list.add(index)
            index_list.add(index+1)
    return list(index_list)

def solution(cryptogram):
    answer=''
    if is_overlap(cryptogram):
        remove_list=find_overlap_index(cryptogram)
        for index, word in enumerate(cryptogram):
            if index not in remove_list:
                answer+=word
        return solution(answer)
    return cryptogram
    
print(solution('browoanoommnaon'))