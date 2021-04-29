def solution(prices):
    answer = [-1 for i in prices]
    answer[-1] = 0 #마지막은 무조건 0(뒤가 없으니)
    
    for i in range(len(prices)-1):
        n = 0
        for j in range(i+1, len(prices)):
            n += 1
            if prices[j] < prices[i]: #떨어지면
                answer[i] = n #추가하고
                break #for문 탈출
        if answer[i] == -1: #위에서 떨어진적이 없다면
            answer[i] = n #온만큼 추가

    return answer
