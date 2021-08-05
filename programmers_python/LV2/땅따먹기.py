def solution(land):

    for i in range(1, len(land)):
        for j in range(len(land[i])):
            big = 0
            for k in range(len(land[i])):
                if j != k:
                    if land[i-1][k] + land[i][j] > big:
                        big = land[i-1][k] + land[i][j]
            land[i][j] = big

    return max(land[-1])
