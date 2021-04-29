import sys

def dfs(x, y, cabbage):
    if [x + 1, y] in cabbage:
        cabbage.remove([x + 1, y])
        dfs(x + 1, y, cabbage)
    if [x, y + 1] in cabbage:
        cabbage.remove([x, y + 1])
        dfs(x, y + 1, cabbage)
    if [x - 1, y] in cabbage:
        cabbage.remove([x - 1, y])
        dfs(x - 1, y, cabbage)
    if [x, y - 1] in cabbage:
        cabbage.remove([x, y - 1])
        dfs(x, y - 1, cabbage)
    return

sys.setrecursionlimit(10000) #이거 안쓰면 RecursionError 뜸
t = int(sys.stdin.readline())
answer = []
while t > 0:
    m, n, k = map(int, sys.stdin.readline().split())
    cabbage = []
    cnt = 0

    for i in range(k):
        x, y = map(int, sys.stdin.readline().split())
        cabbage.append([x, y])

    while cabbage:
        [x, y] = cabbage.pop()
        cnt += 1

        dfs(x, y, cabbage)

    answer.append(cnt)
    t -= 1

for i in answer:
    print(i)
