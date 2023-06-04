import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())
plus = []
minus = []
max_num = 0
for l in list(map(int, read().rstrip().split())):
    if l < 0:
        minus.append(-l)
        max_num = max(max_num, -l)
    else:
        plus.append(l)
        max_num = max(max_num, l)
minus.sort()
plus.sort()
res = 0

for i in range(len(plus)-1, -1, -M):
    res += 2*plus[i]

for i in range(len(minus)-1, -1, -M):
    res += 2*minus[i]

res -= max_num

print(res)