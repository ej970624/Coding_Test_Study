def solution(triangle):
        
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j != 0 and j != len(triangle[i])-1: #중간 인덱스일 경우에는 올 수 있는 두가지의 경우 중 큰 값을 더함
                big = triangle[i-1][j] if triangle[i-1][j] > triangle[i-1][j-1] else triangle[i-1][j-1]
                triangle[i][j] += big
            else:
                if j == 0: #첫번째 인덱스는 윗줄의 첫 인덱스
                    triangle[i][j] += triangle[i-1][j]
                else: #마지막 인덱스는 윗줄의 마지막 인덱스
                    triangle[i][j] += triangle[i-1][j-1]
        
    return max(triangle[-1])
© 2021 GitHub, Inc.
