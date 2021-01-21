def solution(people, limit):
    answer = 0
    people.sort()
    start = 0 
    end = len(people)-1
    
    while(1):
        if start == end: #한명 남았으면
            answer += 1 #구명보트 하나 추가하고
            break #끝
        if start > end: 
            break
        
        if people[end] + people[start] <= limit: 
            answer += 1
            start += 1
            end -= 1
        else: #limit를 초과하면 무거운 사람만
            answer += 1 #하나추가
            end -= 1 
                
    
    return answer