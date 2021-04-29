def solution(answers):
    answer = []
    p1 = [1,2,3,4,5]
    p2 = [2,1,2,3,2,4,2,5]
    p3 = [3,3,1,1,2,2,4,4,5,5]
    check = [0,0,0]
    
    for i in range(len(answers)):
        if answers[i] == p1[i%5]:
            check[0] += 1
        if answers[i] == p2[i%8]:
            check[1] += 1
        if answers[i] == p3[i%10]:
            check[2] += 1
            
    big = max(check)
    
    for i in range(len(check)):
        if check[i] == big:
            answer.append(i+1)
    
    return answer
