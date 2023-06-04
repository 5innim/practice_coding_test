import sys
import heapq

read = sys.stdin.readline
INF = 1e9


def dijkstra(s):
    q = [(0, s)]
    visited = set()
    distances = [INF] * (n + 1)
    distances[s] = 0
    while q:
        d, t = heapq.heappop(q)
        if t in visited:
            continue
        visited.add(t)
        for n_t, n_d in edges[t]:
            if distances[n_t] > d + n_d:
                distances[n_t] = d + n_d
                heapq.heappush(q, (d + n_d, n_t))

    res = 0
    for i in range(1, n + 1):
        if distances[i] <= m:
            res += item_nums[i]
    return res


n, m, r = map(int, read().rstrip().split())
item_nums = [0] + list(map(int, read().rstrip().split()))
edges = [[] for _ in range(n + 1)]

for _ in range(r):
    a, b, l = map(int, read().rstrip().split())
    edges[a].append((b, l))
    edges[b].append((a, l))

result = 0
for j in range(1, n + 1):
    result = max(result, dijkstra(j))
print(result)