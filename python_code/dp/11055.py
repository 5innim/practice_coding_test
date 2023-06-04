import sys

read = sys.stdin.readline
sys.setrecursionlimit(10 ** 5)


def check(s):
    for i in range(s + 1, N):
        if A[s] < A[i]:
            if check_list[s] + A[i] > check_list[i]:
                check_list[i] = check_list[s] + A[i]
                check(i)
            else:
                continue
        else:
            continue


N = int(read().rstrip())
A = list(map(int, read().rstrip().split()))
check_list = [0] * N
for n in range(N):
    if check_list[n]:
        continue
    check_list[n] = A[n]
    check(n)

print(max(check_list))

