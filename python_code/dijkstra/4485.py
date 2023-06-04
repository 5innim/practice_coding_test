import sys
import heapq

readline = sys.stdin.readline
INF = 1e9


def dijkstra(n, e_list):
    q = [(0, 0, 0)]
    visited = set()
    distances = [[INF] * n for _ in range(n)]
    distances[0][0] = 0
    while q:
        d, r, c = heapq.heappop(q)
        if (r, c) in visited:
            continue
        visited.add((r, c))
        for v in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            n_r, n_c = r + v[0], c + v[1]
            if 0 <= n_r < n and 0 <= n_c < n:
                if distances[n_r][n_c] > d + e_list[n_r][n_c]:
                    heapq.heappush(q, (d + e_list[n_r][n_c], n_r, n_c))
                    distances[n_r][n_c] = d + e_list[n_r][n_c]
    return distances[n - 1][n - 1] + e_list[0][0]


cnt = 1
while True:
    N = int(readline().rstrip())
    if N == 0:
        break
    edges = [list(map(int, readline().rstrip().split())) for _ in range(N)]
    print("Problem " + str(cnt) + ": " + str(dijkstra(N, edges)))
    cnt += 1
