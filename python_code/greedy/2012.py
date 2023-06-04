import sys
readline = sys.stdin.readline

N = int(readline().rstrip())
expected_grades = [int(readline().rstrip()) for _ in range(N)]

expected_grades.sort()
res = 0
for i in range(1, N+1):
    res += abs(i - expected_grades[i-1])

print(res)

