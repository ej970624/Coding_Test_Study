def solution(m, n, board):
    answer = 0

    for i in range(m):
        board[i] = list(board[i]) #문자열을 리스트로 바꿔줌

    while True:
        idx = []
        for i in range(m - 1):
            for j in range(n - 1):
                if board[i][j] == 0: #제거된 블록자리는 0이므로 0이면 패스
                    continue
                if board[i][j] == board[i + 1][j] and board[i][j] == board[i][j + 1] and board[i][j] == board[i + 1][j + 1]: #네모구역 찾으면 모두 인덱스 추가
                    if [i, j] not in idx:
                        idx.append([i, j])
                    if [i + 1, j] not in idx:
                        idx.append([i + 1, j])
                    if [i, j + 1] not in idx:
                        idx.append([i, j + 1])
                    if [i + 1, j + 1] not in idx:
                        idx.append([i + 1, j + 1])

        if len(idx) == 0: #제거될 블록이 없다면 break
            break

        for i in idx:
            board[i[0]][i[1]] = 0 #제거할 블록들은 0으로 바꾸고
            answer += 1 #제거된 블록의 개수 추가함

        for i in range(1, m):
            for j in range(n):
                if board[i][j] == 0: #제거된 자리는 위에서 한칸씩 내려와야 함
                    for k in range(i, 0, -1):
                        board[k][j] = board[k - 1][j]
                        board[k - 1][j] = 0

    return answer
