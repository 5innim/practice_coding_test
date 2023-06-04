import sys

readline = sys.stdin.readline


def bfs(r, c):
    global res
    if info_list[r][c] == "-":
        while c < M and info_list[r][c] == "-":
            visited.add((r, c))
            c += 1
        res += 1
    else:
        while r < N and info_list[r][c] == "|":
            visited.add((r, c))
            r += 1
        res += 1


N, M = map(int, readline().rstrip().split())
info_list = [list(readline().rstrip()) for _ in range(N)]

visited = set()
res = 0

for n in range(N):
    for m in range(M):
        if (n, m) not in visited:
            bfs(n, m)

print(res)
