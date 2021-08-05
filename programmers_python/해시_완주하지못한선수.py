def solution(participant, completion):
    dic = {p:0 for p in participant} #이름마다 0으로 초기화한 딕셔너리 생성
    for i in participant: #동명이인이 있을 수 있기 때문에 이름에 대한 cnt를 value값으로 설정
        dic[i] += 1
    
    for i in completion: #도착한 선수의 이름을 value값에서 -1
        dic[i] -= 1
        
    for key, value in dic.items(): #하나를 제외한 모든 value값이 0이고, 나머지 하나는 1일 것이므로 value가 1인 key값 리턴
        if value == 1:
            return key
