import sys
import heapq
readline = sys.stdin.readline

N, M = map(int, readline().rstrip().split())
map_list = [list(map(int, list(readline().rstrip()))) for _ in range(M)]
INF = 1e9
check_list = [[INF]*N for _ in range(M)]
check_list[0][0] = 0
heap = [(0, 0, 0)]
visited = set()

while heap:
    d, m, n = heapq.heappop(heap)
    if (m, n) in visited:
        continue
    visited.add((m, n))

    for v in ((-1, 0), (0, -1), (1, 0), (0, 1)):
        n_m, n_n = v[0] + m, v[1] + n
        if 0 <= n_m < M and 0 <= n_n < N:
            if check_list[n_m][n_n] > d + map_list[n_m][n_n]:
                heapq.heappush(heap, (d + map_list[n_m][n_n], n_m, n_n))
                check_list[n_m][n_n] = d + map_list[n_m][n_n]

print(check_list[M-1][N-1])




