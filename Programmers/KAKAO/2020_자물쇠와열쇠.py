import copy
def solution(key, lock):
  def create_lock_map(size) :
    arr = []
    for i in range(size):
      row = []
      for j in range(size):
        if i < M-1  or i >= N+M-1 or j < M-1 or j >= N+M-1:
          row.append(3)
        else :
          row.append(lock[i-M+1][j-M+1])
      arr.append(row)
    return arr 

  def rotate_map(key) :
    rotatedArr_90 = [[key[i][j] for i in reversed(range(len(key[j])))] for j in range(len(key))] # 90도 회전
    rotatedArr_180 = [[key[j][i] for i in reversed(range(len(key[j])))] for j in reversed(range(len(key)))] # 180도 회전
    rotatedArr_270 = [[key[i][j] for i in range(len(key[j]))] for j in reversed(range(len(key)))] # 270도 회전
    return key, rotatedArr_90, rotatedArr_180, rotatedArr_270
  
  def unlock_check(rotated_keys,i,j):
    lock_start = M-1
    lock_end = N+M-2

    for key in rotated_keys :


        
    return False

  M=len(key) # key
  N=len(lock) # lock
  size=2*M+N-2
  lock_map=create_lock_map(size)
  
  for i in lock_map :
    print(i)
  rotated_keys=rotate_map(key)
  
  lock_state = False

  for i in range(n+m-1):
    for j in range(n+m-1):
      if unlock_check(rotated_keys,i,j):
        return True
  return False

    
  
  



print(solution([[0, 0, 0], [1, 0, 0],[0, 1, 1]],[[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
print(solution([[0, 0], [1, 0]],[[1, 1, 1], [1, 1, 0], [1, 0, 1]]))