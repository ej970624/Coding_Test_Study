def solution(places):
    answer = []
    # 맨해튼 거리 = |r1-r2|+|c1-c2|

    for i in range(len(places)):
        for j in range(len(places[i])):
            if 'POP' in places[i][j] or 'PP' in places[i][j]:
                answer.append(0)
                break
            for k in range(len(places[i][j])):
                if places[i][j][k:k + 2] == 'PO' and k != len(places[i][j])-1:
                    if j != 0:
                        if places[i][j-1][k + 1] == 'P':
                            answer.append(0)
                            break
                    if j != len(places[i]) - 1:
                        if places[i][j+1][k + 1] == 'P':
                            answer.append(0)
                            break
                if places[i][j][k:k + 2] == 'OP':
                    if j != 0:
                        if places[i][j-1][k] == 'P':
                            answer.append(0)
                            break
                    if j != len(places[i]) - 1:
                        if places[i][j+1][k] == 'P':
                            answer.append(0)
                            break
                if j < 3:
                    if places[i][j][k] + places[i][j + 1][k] + places[i][j + 2][k] == 'POP':
                        answer.append(0)
                        break
                if j < 4:
                    if places[i][j][k] + places[i][j + 1][k] == 'PP':
                        answer.append(0)
                        break
            if len(answer) == i+1:
                break
        if len(answer) < i+1:
            answer.append(1)

    return answer
