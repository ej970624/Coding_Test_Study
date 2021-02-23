def solution(m, n, puddles):
    
    lst = [[1 for i in range(m)] for j in range(n)] #처음에 1로 초기화
    
    if [] not in puddles: #물웅덩이가 1개 이상 있다면
        for [c, r] in puddles:
            if r == 1 and c < m: #가로 첫째줄에 물웅덩이 있으면 웅덩이 오른쪽은 갈 수 없기 때문에 0으로 바꿔줌
                for i in range(c, m):
                    lst[0][i] = 0
            if c == 1 and r < n: #세로 첫째줄에 물웅덩이 있으면 웅덩이 아래쪽은 갈 수 없기 때문에 0으로 바꿔줌
                for i in range(r, n):
                    lst[i][0] = 0
            lst[r-1][c-1] = 0 #웅덩이 부분도 0으로
        
    for i in range(1, n):
        for j in range(1, m): #가로, 세로 두번째부터 돌면서 위, 왼쪽 더한 값을 넣어줌(해당 부분에 올 수 있는 경우의 수임)
            if lst[i][j] == 0: #웅덩이면 패스
                continue
            lst[i][j] = lst[i-1][j] + lst[i][j-1]
            
    
    return lst[n-1][m-1] % 1000000007 #리스트의 학교 부분 값이 최종적으로 모든 경우의 수
