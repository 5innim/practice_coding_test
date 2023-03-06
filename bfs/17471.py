import sys
from collections import deque
from itertools import combinations

readline = sys.stdin.readline

def bfs(t_s, s):
    t = tuple(t_s)
    r = 0
    checked = [0] * (N + 1)
    q = deque([t[0]])
    checked[t[0]] = 1
    while q:
        t_n = q.popleft()
        r += populations[t_n]
        for n_n in info_list[t_n]:
            if checked[n_n] == 0 and n_n in t_s:
                q.append(n_n)
                checked[n_n] = 1

    return r if sum(checked) == s else -1


N = int(readline().rstrip())
populations = [0] + list(map(int, readline().rstrip().split()))
info_list = [[]]

for _ in range(N):
    info_list.append(list(map(int, readline().rstrip().split()))[1:])

res = -1

for n in range(1, N // 2 + 1):
    for c in combinations([i for i in range(1, N + 1)], n):
        a = bfs(set(c), n)
        b = bfs(set([i for i in range(1, N + 1)]) - set(c), N - n)
        if a != -1 and b != -1:
            if res == -1:
                res = abs(a - b)
            else:
                res = min(res, abs(a - b))

print(res)
