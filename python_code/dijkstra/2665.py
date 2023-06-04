import sys
import heapq

read = sys.stdin.readline
INF = 1e9

n = int(read().rstrip())
r_map = [list(map(int, list(read().rstrip()))) for _ in range(n)]

q = [(0, 0, 0)]
visited = set()
distances = [[INF] * n for _ in range(n)]
distances[0][0] = 0

while q:
    d, r, c = heapq.heappop(q)
    if (r, c) in visited:
        continue
    visited.add((r, c))
    for v in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        n_r, n_c = r + v[0], c + v[1]
        if not (0 <= n_r < n and 0 <= n_c < n):
            continue
        w = 1 if r_map[n_r][n_c] == 0 else 0
        if distances[n_r][n_c] > d + w:
            distances[n_r][n_c] = d + w
            heapq.heappush(q, (d + w, n_r, n_c))

print(distances[n - 1][n - 1])
