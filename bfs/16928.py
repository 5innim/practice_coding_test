import sys
from collections import deque

read = sys.stdin.readline
N, M = map(int, read().rstrip().split())
edges = [0] * 101
for _ in range(N+M):
    a, b = map(int, read().rstrip().split())
    edges[a] = b

q = deque([[1, 0]])
visited = [False] * 101
visited[1] = True
flag = True
res = 0
while q and flag:
    if edges[q[0][0]] != 0:
        if edges[q[0][0]] == 100:
            res = q[0][1]
            break
        q[0][0] = edges[q[0][0]]
        visited[edges[q[0][0]]] = True
        continue
    d, c = q.popleft()
    for i in range(1, 7):
        n_d = d + i
        if 1 <= n_d < 100 and not visited[n_d]:
            visited[n_d] = True
            q.append([n_d, c + 1])
        elif n_d == 100:
            res = c + 1
            flag = False

print(res)

