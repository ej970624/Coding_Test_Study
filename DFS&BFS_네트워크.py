def solution(n, computers):
    answer = 0

    global visit
    global check
    visit = [[] for i in range(n)] #연결되어 있는 번호만 저장하는 리스트
    check = [0 for i in range(n)] #체크 리스트

    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                visit[i].append(j) 

    for i in visit:
        for j in i:
            if check[j] == 0: #안왔던 곳이면
                answer += 1 
                check[j] = 1
                function(j) #포함된 값들도 모두 체크

    return answer + check.count(0)

def function(i):
    for j in visit[i]:
        if check[j] == 0:
            check[j] = 1
            function(j)
