import sys

def bfs(i, j, house, check, n):
    stack = [[i, j]]
    cnt = 0

    while stack:
        [x, y] = stack.pop()
        if check[x][y] == 1:
            continue
        check[x][y] = 1
        cnt += 1

        if x != 0:
            if house[x-1][y] == 1 and check[x-1][y] == 0:
                stack.append([x-1, y])
        if x != n-1:
            if house[x+1][y] == 1 and check[x+1][y] == 0:
                stack.append([x+1, y])
        if y != 0:
            if house[x][y-1] == 1 and check[x][y-1] == 0:
                stack.append([x, y-1])
        if y != n-1:
            if house[x][y+1] == 1 and check[x][y+1] == 0:
                stack.append([x, y+1])

    return cnt

n = int(sys.stdin.readline())
answer = []
house = []
check = [[0 for i in range(n)] for j in range(n)]

for i in range(n):
    house.append(list(map(int, sys.stdin.readline().strip())))

for i in range(n):
    for j in range(n):
        if house[i][j] == 1 and check[i][j] == 0:
            answer.append(bfs(i, j, house, check, n))

answer.sort()
print(len(answer))
for i in answer:
    print(i)
