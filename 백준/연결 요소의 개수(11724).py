import sys

n, m = map(int, sys.stdin.readline().split())
line = [[i] for i in range(n + 1)]
check = [0 for i in range(n + 1)]
cnt = 0

for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    line[u].append(v)
    line[v].append(u)

stack = line[1]
while True:
    x = stack.pop()
    check[x] = 1

    for i in line[x]:
        if i not in stack and check[i] == 0:
            stack.append(i)

    if len(stack) == 0:
        cnt += 1
        flag = False
        for i in range(1, n+1):
            if check[i] == 0:
                stack = line[i]
                flag = True
                break
        if flag is False:
            break

print(cnt)
