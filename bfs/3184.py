import sys
from collections import deque

readline = sys.stdin.readline


def bfs(row, col):
    global v, o
    v_cnt = 0
    o_cnt = 0
    q = deque([(row, col)])
    visited.add((row, col))
    while q:
        tr, tc = q.popleft()
        if field[tr][tc] == 'v':
            v_cnt += 1
        elif field[tr][tc] == 'o':
            o_cnt += 1
        for fv in fv_tuple:
            nr, nc = tr + fv[0], tc + fv[1]
            if (nr < 0 or nr >= R) or (nc < 0 or nc >= C) or (nr, nc) in visited or field[nr][nc] == '#':
                continue
            q.append((nr, nc))
            visited.add((nr, nc))
    if o_cnt > v_cnt:
        o += o_cnt
    else:
        v += v_cnt


R, C = map(int, readline().rstrip().split())
field = [list(readline().rstrip()) for _ in range(R)]
fv_tuple = ((-1, 0), (1, 0), (0, -1), (0, 1))

visited = set()
v = 0
o = 0
for r in range(R):
    for c in range(C):
        if field[r][c] != '#' and (r, c) not in visited:
            bfs(r, c)
print(o, v)
