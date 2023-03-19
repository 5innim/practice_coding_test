import sys
from collections import deque
read = sys.stdin.readline

K = int(read().rstrip())
res = deque([])
for _ in range(K):
    a = int(read().rstrip())
    if a == 0:
        res.pop()
    else:
        res.append(a)
print(sum(res))