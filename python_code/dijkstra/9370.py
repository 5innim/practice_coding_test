import sys
import heapq

read = sys.stdin.readline
INF = 1e9


def dijkstra(e_list, s_node, num, g_node, h_node):
    q = [(0, s_node, False)]
    visited = set()
    distances = [[INF, False] for _ in range(num + 1)]
    distances[s_node][0] = 0
    while q:
        cost, target, flag = heapq.heappop(q)
        if target in visited:
            continue
        visited.add(target)
        if flag:
            distances[target][1] = True
        for n_target, n_cost in e_list[target]:
            if distances[n_target][0] > cost + n_cost:
                distances[n_target][0] = cost + n_cost
                if flag or (n_target == g_node and target == h_node) or (n_target == h_node and target == g_node):
                    heapq.heappush(q, (cost + n_cost, n_target, True))
                else:
                    heapq.heappush(q, (cost + n_cost, n_target, False))
    return distances


T = int(read().rstrip())
for _ in range(T):
    n, m, t = map(int, read().rstrip().split())
    s, g, h = map(int, read().rstrip().split())
    edges = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, d = map(int, read().rstrip().split())
        if (a == g and b == h) or (a == h and b == g):
            edges[a].append((b, d - 0.1))
            edges[b].append((a, d - 0.1))
        else:
            edges[a].append((b, d))
            edges[b].append((a, d))
    destinations = []
    for _ in range(t):
        heapq.heappush(destinations, int(read().rstrip()))
    res_distances = dijkstra(edges, s, n, g, h)
    res = []
    while destinations:
        p = heapq.heappop(destinations)
        if res_distances[p][1]:
            res.append(p)
    print(" ".join(map(str, res)))