import sys
import heapq

readline = sys.stdin.readline

INF = 1e9
N, M, K, X = map(int, readline().rstrip().split())

edges = [[] for _ in range(N)]
for _ in range(M):
    A, B = map(int, readline().rstrip().split())
    edges[A - 1].append(B - 1)

q = [(0, X - 1)]
visited = set()
distances = [1e9] * N
distances[X - 1] = 0

while q:
    d, n = heapq.heappop(q)
    if n in visited:
        continue
    visited.add(n)
    for n_n in edges[n]:
        if distances[n_n] > d + 1:
            heapq.heappush(q, (d + 1, n_n))
            distances[n_n] = d + 1

flag = True
for i in range(N):
    if distances[i] == K:
        flag = False
        print(i + 1)

if flag:
    print(-1)
