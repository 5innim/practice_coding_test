import sys
import heapq
read = sys.stdin.readline
INF = 1e9

T = int(read().rstrip())
for _ in range(T):
    n, d, c = map(int, read().rstrip().split())
    edges = [[] for _ in range(n + 1)]

    for _ in range(d):
        a, b, s = map(int, read().rstrip().split())
        edges[b].append((a, s))

    q = [(0, c)]
    distances = [INF] * (n + 1)
    distances[c] = 0
    visited = set()
    while q:
        distance, target = heapq.heappop(q)
        if target in visited:
            continue
        visited.add(target)
        for n_target, n_distance in edges[target]:
            if distances[n_target] > distance + n_distance:
                distances[n_target] = distance + n_distance
                heapq.heappush(q, (distance + n_distance, n_target))
    res = []
    for dis in distances:
        if dis < INF:
            res.append(dis)
    print(" ".join(map(str, [len(res), max(res)])))

