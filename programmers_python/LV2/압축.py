def solution(msg):
    answer = []
    alpha = [-1, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    now = msg[0]
    
    for i in range(1, len(msg)):
        if now+msg[i] in alpha:
            now += msg[i]
        else:
            answer.append(alpha.index(now))
            alpha.append(now+msg[i])
            now = msg[i]
    answer.append(alpha.index(now))
    
    return answer
