import sys
from collections import deque

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

check_list = [[0, 0] for _ in range(100001)]
check_list[N][0] = 1
check_list[N][1] = 1
q = deque([(N, 1)])

while q:
    l, d = q.popleft()
    a, b, c = l - 1, l + 1, 2 * l
    for l_n in (a, b, c):
        if not (0 <= l_n <= 100000):
            continue
        if check_list[l_n][0] == 0:
            check_list[l_n][0] = d + 1
            check_list[l_n][1] = check_list[l][1]
            q.append((l_n, d + 1))
        elif check_list[l_n][0] == d + 1:
            check_list[l_n][1] += check_list[l][1]

print(check_list[K][0] - 1)
print(check_list[K][1])
