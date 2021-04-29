def solution(priorities, location):
    answer = 0
    alpha = [chr(i+65) for i in range(len(priorities))] #작업 구분을 위해 알파벳으로 된 리스트 생성
    key = alpha[location] #구해야 하는 작업
    
    while 1:
        bigest = max(priorities) #남은 작업 중 가장 높은 중요도
        now = priorities[0] #현재 작업
        if now == bigest: #현재가 가장 높다면
            answer += 1 #인쇄
            priorities.pop(0) #인쇄한것은 제거
            if alpha.pop(0) == key: #알파리스트도 제거하면서 key와 같은지 확인
                return answer #같으면 리턴
        else: #더 높은 중요 작업이 있다면
            priorities.append(priorities.pop(0)) #앞에서 제거하고 뒤에 다시 붙임
            alpha.append(alpha.pop(0)) #마찬가지
