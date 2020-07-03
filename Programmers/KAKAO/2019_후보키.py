import itertools
def get_attr_combi_unique(relation) :
  unique_list = []
  for col in range(1,len(relation[0])+1):
    comb_attributes = itertools.combinations([i for i in range(len(relation[0]))],col) # column 조합 생성
  
    # all_attr_list = [tuple(item[index] for index in check_comb) for item in relation] 
    for attr_idx in list(comb_attributes):
      tuples = []
      for i in relation :
        row = []
        for idx in attr_idx :
          row.append(i[idx])
        tuples.append(tuple(row)) # set으로 중복 제거를 위해 tuple 자료구조 사용

      if len(set(tuples)) == len(relation): # 원래 릴레이션의 튜플과 수가 같으면
        unique_list.append(set(attr_idx))
  return unique_list

def get_attr_combi_minimum(unique_list) :
  # list[:]는 list의 모든 원소를 포함하고 있는 list를 객체를 반환(깊은 복사)
  for item1 in unique_list[:]:
    for item2 in unique_list[:]:
      if item1 != item2:
        if item2 & item1 == item1 : unique_list.remove(item2)
  return unique_list

def solution(relation):
  return len(get_attr_combi_minimum(get_attr_combi_unique(relation))) # 유일성, 최소성을 만족하는 후보키 개수

print(solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]))
