from math import ceil
from math import floor

def solution(w, h):
    answer = 0
    slope = h / w

    for i in range(w):
        answer += ceil(slope * (i+1)) - floor(slope * i) #큰수는 올림, 작은수는 내림해서 차이값을 빼야함
        
        if slope * (i+1) == ceil(slope * (i+1)): #정수의 값이 나오면 나머지는 배수단위로 같음
            answer *= w / (i+1)
            break
        
    return int(w * h - answer)

#testcase6 실패, testcase11 시간초과
