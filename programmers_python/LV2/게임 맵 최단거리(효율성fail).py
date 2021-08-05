def solution(maps):
    answer = 0
    que = [[0, 0]]

    while que:
        key = que
        que = []
        answer += 1

        for i in key:
            maps[i[0]][i[1]] = -1
            if i == [len(maps)-1, len(maps[0])-1]:
                return answer

            if i[0] != 0:
                if maps[i[0]-1][i[1]] == 1:
                    que.append([i[0]-1, i[1]])
            if i[1] != 0:
                if maps[i[0]][i[1]-1] == 1:
                    que.append([i[0], i[1]-1])
            if i[0] != len(maps)-1:
                if maps[i[0]+1][i[1]] == 1:
                    que.append([i[0]+1, i[1]])
            if i[1] != len(maps[0])-1:
                if maps[i[0]][i[1]+1] == 1:
                    que.append([i[0], i[1]+1])

    return -1
