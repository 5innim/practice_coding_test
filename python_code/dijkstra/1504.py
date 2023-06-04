import sys
import heapq

readline = sys.stdin.readline


def dijkstra(s, d):
    q = [(0, s)]
    flag = False
    distances = [INF] * N
    distances[s] = 0
    visited = set()
    while q:
        w, t = heapq.heappop(q)
        if t in visited:
            continue
        elif t == d:
            flag = True
            break
        visited.add(t)
        for n_t in range(N):
            if 1 <= e_info[t][n_t] <= 1000 and distances[n_t] > w + e_info[t][n_t]:
                heapq.heappush(q, (w + e_info[t][n_t], n_t))
                distances[n_t] = w + e_info[t][n_t]

    return distances[d] if flag else -1


N, E = map(int, readline().rstrip().split())
INF = 1e9
e_info = [[INF] * N for _ in range(N)]
for n in range(N):
    e_info[n][n] = 0
for _ in range(E):
    a, b, c = map(int, readline().rstrip().split())
    e_info[a - 1][b - 1] = c
    e_info[b - 1][a - 1] = c

v1, v2 = map(int, readline().rstrip().split())

a1, a2, a3 = dijkstra(0, v1 - 1), dijkstra(v1 - 1, v2 - 1), dijkstra(v2 - 1, N - 1)
b1, b2, b3 = dijkstra(0, v2 - 1), dijkstra(v2 - 1, v1 - 1), dijkstra(v1 - 1, N - 1)

res_a = -1
res_b = -1

if a1 != -1 and a2 != -1 and a3 != -1:
    res_a = a1 + a2 + a3
if b1 != -1 and b2 != -1 and b3 != -1:
    res_b = b1 + b2 + b3

if res_a != -1 and res_b != -1:
    print(min(res_a, res_b))
elif res_a != -1 and res_b == -1:
    print(res_a)
elif res_a == -1 and res_b != -1:
    print(res_b)
else:
    print(-1)