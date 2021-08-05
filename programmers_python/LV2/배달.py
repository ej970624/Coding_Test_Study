def solution(N, road, K):
    answer = 1 #1번 마을은 무조건 가능하므로
    
    if N == 1: #마을이 하나면 1리턴
        return answer

    linked = [[] for i in range(N + 1)] #인덱스에 해당하는 마을이랑 연결된 마을의 정보를 저장하는 리스트
    time = [500001 for i in range(N + 1)] #인덱스 마을에 걸리는 시간
    time[1] = 0

    for i in road:
        linked[i[0]].append([i[0], i[1], i[2]])
        linked[i[1]].append([i[1], i[0], i[2]])

    que = linked[1] #1번 마을 연결정보를 que에 저장
    while que:
        key = que.pop(0) #하나씩 꺼내보면서
        if time[key[1]] > time[key[0]] + key[2]: #저장되어있는 시간보다 이번 마을을 거쳐오는 시간이 더 짧으면
            time[key[1]] = time[key[0]] + key[2] #time 갱신
            for i in linked[key[1]]: #갱신됐으니 해당 마을이랑 연결된 정보 다시 que에 저장
                que.append(i)

    for i in range(2, N+1):
        if time[i] <= K:
            answer += 1

    return answer
