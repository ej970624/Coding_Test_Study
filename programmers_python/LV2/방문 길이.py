def solution(dirs):
    dic = {'U': [0, 1], 'D': [0, -1], 'R': [1, 0], 'L': [-1, 0]}
    passed = []
    now = [0, 0]

    for i in dirs:
        after = [now[0] + dic[i][0], now[1] + dic[i][1]]
        if -5 <= after[0] <= 5 and -5 <= after[1] <= 5:
            if [now[0], now[1], after[0], after[1]] not in passed and [after[0], after[1], now[0], now[1]] not in passed:
                passed.append([now[0], now[1], after[0], after[1]])
                passed.append([after[0], after[1], now[0], now[1]])
            now = after

    return len(passed) / 2
