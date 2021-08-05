def solution(skill, skill_trees):
    answer = 0
    dic = dict()
    
    for i in skill:
        dic[i] = -1 #스킬이 사용된 인덱스를 저장할 딕셔너리 -1로 초기화
    
    for i in skill_trees:
        count = 0
        for j in range(len(i)):
            if i[j] in dic:
                dic[i[j]] = j #사용된 스킬이 있으면 해당 인덱스 저장
                count += 1 #몇 개의 스킬이 사용됐는지 알기 위한 count
        val = -1
        for k in skill:
            if dic[k] < 0: #사용되지 않은 스킬이 나오면 break
                break
            if dic[k] > val: #이전 스킬보다 나중에 쓰였으면 가능(저장된 인덱스 값이 더 크면)
                val = dic[k]
                count -= 1 #연속으로 사용된 스킬의 개수와 똑같은지 확인하기 위함
        if count == 0: #count = 0 이면 사용된 스킬이 모두 순서에 맞게 연속으로 사용된 것이므로 사용가능
            answer += 1
        for key in dic.keys(): #다시 딕셔너리 초기화
            dic[key] = -1
    
    return answer
