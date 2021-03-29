def solution(genres, plays):
    answer = []
    dic = {}

    for i in range(len(genres)): #{장르:[[장르 총 재생횟수, 0], [장르 고유번호, 노래 재생횟수], [장르 고유번호, 노래 재생횟수], ...]} 이런 딕셔너리를 만들기 위한 for문
        if genres[i] in dic:
            dic[genres[i]][0][0] += plays[i]
            dic[genres[i]].append([i, plays[i]])
        else:
            dic[genres[i]] = []
            dic[genres[i]].append([plays[i], 0])
            dic[genres[i]].append([i, plays[i]])

    sdic = dict(sorted(dic.items(), key=lambda x:x[1], reverse=True)) #장르 총 재생횟수가 큰 순대로 정렬한 딕셔너리
    for key, val in sdic.items():
        if len(val) == 2: #장르에 해당하는 노래가 하나 뿐이라면 그냥 append
            answer.append(val[1][0])
            continue
        val.sort(key=lambda x: (-x[1], x[0])) #두개 이상이면 횟수 높은 순, 같으면 번호 낮은 순으로 정렬하고 두개 append
        answer.append(val[0][0])
        answer.append(val[1][0])

    return answer
