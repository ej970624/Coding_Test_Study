def solution(tickets):
    global answer
    answer = ["ICN"]
    global fail
    fail = [] #잘못 뽑은거 저장하는 리스트

    dfs("", "ICN", tickets, 1, False, 0)

    return answer


def dfs(before, now, tickets, idx, flag, cnt): #idx: 현재 뽑아야하는 인덱스, flag: 실패여부, cnt: 잘못 뽑았을경우 돌아가야 하는 횟수
    if tickets == []:
        return
    tmp = [] #뽑을 수 있는 후보 리스트
    for i in range(len(tickets)):
        if tickets[i][0] == now and [idx, before, tickets[i][1]] not in fail: #출발지가 현재와 같고, 잘못뽑은 리스트에 없으면
            tmp.append(tickets[i][1]) #tmp에 append

    if tmp == []: #뽑은게 없다는건 이전에 잘못뽑았다는 것.
        fail.append([idx, before, now])
        if idx < 3:
            dfs("", before, tickets, idx-1, True, cnt+1) 
        else:
            dfs(answer[idx-3], before, tickets, idx-1, True, cnt+1)
    else:
        if flag: #이전에 잘못뽑아서 돌아온 경우에는
            for i in range(cnt): #돌아가야 하는 횟수만큼 반복
                tickets.append([answer[-2], answer[-1]]) #삭제했던 항공권 복구
                answer.pop(-1) #추가했던 경로삭제
        after = min(tmp) #가능한 경로 중 알파벳 작은 순으로 설정
        answer.append(after) #answer에 경로추가
        tickets.remove([now, after]) #경로 추가했으면 그 항공권은 삭제
        dfs(now, after, tickets, idx+1, False, 0)
