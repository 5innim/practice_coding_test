import sys
from collections import deque
#F: 가장 높은 층
#S: 시작 층
#G: 목표 층
#U: 위로 이동
#D: 아래로 이동
#bfs: 인접행렬로 구현시 O(n^2), 인접리스트로 구현시 O(V+E)
#해당 문제는 노드가 연결되어 있는지 여부를 확인할 필요 없으니 O(V+E)
readline = sys.stdin.readline
F, S, G, U, D = map(int, readline().rstrip().split())
visited = [0]*(F+1)
visited[S] = 1
bfsq = deque([(S, 0)])
enable = -1
while(bfsq):
    s, c = bfsq.popleft()
    if s==G:
        enable = c
        break
    u = s+U
    d = s-D
    if u<=F and not visited[u]:
        bfsq.append((u, c+1))
        visited[u] = 1
    if d>=1 and not visited[d]:
        bfsq.append((d, c+1))
        visited[d] = 1

print("use the stairs" if enable==-1 else enable)



