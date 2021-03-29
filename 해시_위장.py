def solution(clothes):
    answer = 1
    dic = {}
    
    for [i, j] in clothes: #카테고리별로 딕셔너리에 추가
        if j in dic:
            dic[j].append(i)
        else:
            dic[j] = [i]
            
    for key, val in dic.items():
        answer *= (len(val)+1) #카테고리의 개수+1만큼 모두 곱한 것이 나올 수 있는 경우의 수 (ex. face의 개수가 3개면 face를 선택하지 않는 것도 포함하므로 +1)
    
    return answer-1 #-1해주는 이유는 모든 카테고리를 하나도 선택하지 않는 경우의 수 제거하기 위함
