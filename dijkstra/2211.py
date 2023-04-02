import sys
import heapq
read = sys.stdin.readline

INF = 1e9

N, M = map(int, read().rstrip().split())
edges = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B, C = map(int, read().rstrip().split())
    edges[A].append((B, C))
    edges[B].append((A, C))

heap = [[0, 1, (0, 0)]]
distances = [INF] * (N + 1)
distances[1] = 0
visited = set()
res = set()
while heap:
    c, a, s = heapq.heappop(heap)
    if a in visited:
        continue
    visited.add(a)
    res.add(s)
    for n_a, n_c in edges[a]:
        if distances[n_a] > c + n_c:
            distances[n_a] = c + n_c
            heapq.heappush(heap, (c + n_c, n_a, (a, n_a)))
res_l = list(res - {(0, 0)})
print(len(res_l))
for r_a, r_b in res_l:
    print(" ".join([str(r_a), str(r_b)]))


