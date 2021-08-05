def solution(n, edge):
    linked = [[] for i in range(n+1)]
    num = [-1 for i in range(n+1)]
    num[0] = 0
    num[1] = 0
    check = [0 for i in range(n+1)]
    check[0] = 1
    
    for [i, j] in edge:
        linked[i].append(j)
        linked[j].append(i)
     
    que = [1]
    
    while 0 in check:
        target = que.pop(0)
        if check[target] == 0:
            for i in linked[target]:
                if i in que or check[i] == 1:
                    continue
                que.append(i)
                if num[i] == -1:
                    num[i] = num[target] + 1
            check[target] = 1
    
    return num.count(max(num))
