import sys
import heapq

readline = sys.stdin.readline

N = int(readline().rstrip())

assignments = [tuple(map(int, readline().rstrip().split())) for _ in range(N)]

assignments.sort(key=lambda x: (x[0], -x[1]))

cnt = 1
done = list()
for a in assignments:
    if cnt <= a[0]:
        heapq.heappush(done, a[1])
        cnt += 1
    else:
        if done[0] < a[1]:
            heapq.heappop(done)
            heapq.heappush(done, a[1])

print(sum(done))
