import sys
import heapq
from collections import deque

read = sys.stdin.readline

T = int(read().rstrip())
for _ in range(T):
    N, M = map(int, read().rstrip().split())
    n_list = list(map(int, read().rstrip().split()))
    q = deque(n_list)
    heap = list(map(lambda x: -x, n_list))
    heapq.heapify(heap)
    res = 0
    flag = True
    while heap and flag:
        t = -(heapq.heappop(heap))
        while 1:
            if q[0] == t:
                q.popleft()
                res += 1
                if M == 0:
                    flag = False
                M -= 1
                break
            else:
                a = q[0]
                q.popleft()
                q.append(a)
                if M == 0:
                    M = len(q) - 1
                else:
                    M -= 1
    print(res)

