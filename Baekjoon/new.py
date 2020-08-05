s=input()
bomb_s=input()

while bomb_s in s:
    idx=s.index(bomb_s)
    s=s[:idx]+s[idx+len(bomb_s)-1:]
print(s)