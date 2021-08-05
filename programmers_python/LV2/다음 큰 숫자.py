def solution(n):
    answer = 0
    num = str(format(n, 'b')).count('1')

    for i in range(n + 1, 1000001):
        if str(format(i, 'b')).count('1') == num:
            return i
