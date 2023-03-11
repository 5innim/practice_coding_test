import sys
import heapq

read = sys.stdin.readline
INF = 1e9

n = int(read().rstrip())
m = int(read().rstrip())
edges = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, read().rstrip().split())
    edges[a].append((c, b))

s, d = map(int, read().rstrip().split())

q = [(0, s)]
visited = set()
distances = [INF] * (n + 1)
distances[s] = 0
routes = [[] for _ in range(n + 1)]
routes[s].append(s)
while q:
    w, t = heapq.heappop(q)
    if t in visited:
        continue
    visited.add(t)
    for n_w, n_t in edges[t]:
        if distances[n_t] >= w + n_w:
            distances[n_t] = w + n_w
            heapq.heappush(q, (w + n_w, n_t))
            routes[n_t] = routes[t] + [n_t]


print(distances[d])
print(len(routes[d]))
print(" ".join(map(str, routes[d])))



