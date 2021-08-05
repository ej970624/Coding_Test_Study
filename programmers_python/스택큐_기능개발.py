def solution(progresses, speeds):
    answer = []
    days = [] #작업 당 걸리는 기간 저장하는 리스트
    
    for i in range(len(progresses)):
        if (100-progresses[i]) % speeds[i] == 0:
            days.append((100-progresses[i])//speeds[i])
        else:
            days.append((100-progresses[i])//speeds[i] + 1)    
            
    cnt = 1
    standard = days[0] #첫번째 작업 기준
    for i in range(1, len(days)):
        if standard < days[i]: #기준보다 오래걸리면 그 전까지 가능한 작업 수를 append
            answer.append(cnt)
            standard = days[i]
            cnt = 1
        else: #기준과 함께 배포 가능하다면 cnt증가
            cnt += 1
    answer.append(cnt) #마지막 cnt도 추가
    
    return answer
