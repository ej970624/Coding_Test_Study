lst = []
def solution(begin, target, words):
    flag = False
    for i in words:
        if i == target:
            flag = True
    if flag == False: #words에 target이 없으면
        return 0 #0리턴

    dfs(begin, words, target, begin, 0)

    return min(lst) #최솟값 리턴


def dfs(before, words, target, now, cnt): #begin : 전에 선택한 단어, now : 현재단어, cnt : 변환횟수
    if cnt > len(words): #words 개수보다 cnt가 커지면 리턴
        return
    if now == target: #target을 찾으면
        lst.append(cnt) #cnt를 lst에 추가
        return

    for item in words:
        dif = 0 #다른 스펠링 횟수체크
        if item == before: #전에 선택한 단어를 다시 선택하면 안되므로 pass
            continue
        for i in range(len(now)):
            if dif > 2: #2개 이상 다를경우 계속 체크할 필요 없으므로 break
                break
            if now[i] != item[i]: #다른 스펠링 체크
                dif += 1
        if dif == 1: #한 글자만 다르면
            dfs(now, words, target, item, cnt + 1) #before를 now로, now를 item으로, cnt를 +1
