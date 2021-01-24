def solution(brown, yellow):
    answer = []
    
    #노랑이 x*y일때, 브라운은 2x+2y+4
    #카펫의 가로는 x+2, 세로는 y+2
    #plus = x+y
    plus = int((brown-4)/2)
    for i in range(1, plus):
        if yellow == i * (plus-i):
            x = i > plus-i and i or plus-i
            
    answer = [x+2, plus-x+2]
    
    return answer
