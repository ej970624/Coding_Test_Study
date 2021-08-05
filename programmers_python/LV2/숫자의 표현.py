def solution(n):
    answer = 1 #n자체는 무조건 가능하므로 1로 초기화
    
    for i in range(1, n):
        num = n
        for j in range(i, n):
            if num > 0:
                num -= j
            else:
                break
        if num == 0:
            answer += 1
    
    return answer
