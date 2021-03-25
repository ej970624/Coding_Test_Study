def solution(citations):
    answer = 0
    
    citations.sort(reverse=True)
    for i in range(len(citations)):
        if citations[i] <= i+1 and answer < citations[i]:
            answer = citations[i]
        if citations[i] >= i+1 and answer < i+1:
            answer = i+1
    
    return answer
