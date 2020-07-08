def solution(numbers, hand):
  hand=hand[0].upper()
  keypad = {1:(0,0),2:(0,1),3:(0,2),
            4:(1,0),5:(1,1),6:(1,2),
            7:(2,0),8:(2,1),9:(2,2),
            '*':(3,0),0:(3,1),'#':(3,2)}
  left_keypad=[1,4,7,'*']
  right_keypad=[3,6,9,'#']
  left_position='*'
  right_position='#'
  answer=''
  for i in numbers:
    if i in left_keypad:
      left_position=i
      answer+='L'
    elif i in right_keypad:
      right_position=i
      answer+='R'
    else:
      target_x, target_y = keypad[i][0], keypad[i][1]
      left_x, left_y = keypad[left_position][0], keypad[left_position][1]
      right_x, right_y = keypad[right_position][0], keypad[right_position][1]

      if abs(target_x-left_x) + abs(target_y-left_y) < abs(target_x-right_x) + abs(target_y-right_y):
        answer+='L'
        left_position=i
      elif abs(target_x-left_x) + abs(target_y-left_y) > abs(target_x-right_x) + abs(target_y-right_y):
        answer+='R'
        right_position=i
      else:
        if hand == 'R':
          answer+='R'
          right_position=i
        else:
          answer+='L'
          left_position=i
  return answer

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5],'right')) # "LRLLLRLLRRL"
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2],'left')) # "LRLLRRLLLRR"
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0],'right')) # "LLRLLRLLRL"
print(solution([2,2,1,2],'left')) #LLLL