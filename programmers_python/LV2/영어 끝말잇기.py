def solution(n, words):
    answer = [0, 0]
    idx = -1

    for i in range(1, len(words)):
        if words[i-1][-1] != words[i][0] or words[i] in words[:i]:
            idx = i
            break
            
    if idx != -1:
        if (idx + 1) % n != 0:
            answer = [(idx + 1) % n, (idx + 1) // n + 1]
        else:
            answer = [n, (idx + 1) // n]
           
    return answer
