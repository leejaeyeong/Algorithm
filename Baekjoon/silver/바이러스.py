import sys
virus_map=dict()
com=int(input())
for i in range(1,com+1):
    virus_map[i]=[]
n=int(input())

for i in range(n):
    key,val=map(int,sys.stdin.readline().split())
    virus_map[key].append(val)
    virus_map[val].append(key)
virused_com=[]
virus_candidate=virus_map[1]

while len(virus_candidate)>0:
    computer=virus_candidate.pop()
    if computer in virused_com:
        continue
    virused_com.append(computer)
    virus_candidate.extend(virus_map[computer])

print(len(virused_com)-1) if 1 in virused_com else print(len(virused_com))