def solution(n):
    size = 0
    for i in range(1, n+1):
        size += i
    answer = [0 for i in range(size)] #리스트 크기에 맞춰 0으로 초기화

    k = 0 #answer의 index
    count = 1 #삼각의 어떤 변인지 판단하기 위한 변수
    num = 1 #1부터 size까지 계속 증가하는 변수
    for i in range(n):
        for j in range(0, n-i):
            quotient = count // 3 #몫
            remainder = count % 3 #나머지 -> 어떤 변인지 판단하여 계산
            if remainder == 1: #왼쪽
                k += j + quotient * 2
            elif remainder == 2: #밑면
                k += 1
            else: #오른쪽
                k -= n - quotient - j + 1
            answer[k] = num
            num += 1
        count += 1

    return answer
