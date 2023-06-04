import sys

sys.setrecursionlimit(10 ** 5)
readline = sys.stdin.readline


def dfs_cnt(row, col, cnt):
    visited.add((row, col))
    for v in fv_list:
        ar, ac = row + v[0], col + v[1]
        if 0 < ar <= N and 0 < ac <= M and info_list[ar][ac] and (ar, ac)not in visited:
            cnt += dfs_cnt(ar, ac, 1)

    info_list[row][col] = 0
    return cnt


# 인접행렬방식 사용
N, M, K = map(int, readline().rstrip().split())
info_list = [[0] * (M + 1) for _ in range(N + 1)]
fv_list = ((-1, 0), (1, 0), (0, -1), (0, 1))
visited = set()

for _ in range(K):
    r, c = map(int, readline().rstrip().split())
    info_list[r][c] = 1

res = 0
for n in range(1, N+1):
    for m in range(1, M+1):
        if info_list[n][m]:
            res = max(res, dfs_cnt(n, m, 1))

print(res)
