import sys
readline = sys.stdin.readline

N = int(readline().rstrip())
cranes = sorted(list(map(int, readline().rstrip().split())), reverse=True)
M = int(readline().rstrip())
boxes = sorted(list(map(int, readline().rstrip().split())), reverse=True)

if boxes[0] > cranes[0]:
    print(-1)
    exit()

res = 0
while boxes:
    for c in cranes:
        for b in boxes:
            if c >= b:
                boxes.remove(b)
                break
    res += 1
print(res)
