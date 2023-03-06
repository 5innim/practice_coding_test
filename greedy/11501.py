import sys
readline = sys.stdin.readline

T = int(readline().rstrip())
for _ in range(T):
    N = int(readline().rstrip())
    nums = list(map(int, readline().rstrip().split()))
    max_num = nums[-1]
    res = 0
    for i in range(len(nums)-2, -1, -1):
        if max_num < nums[i]:
            max_num = nums[i]
        else:
            res += max_num - nums[i]

    print(res)


