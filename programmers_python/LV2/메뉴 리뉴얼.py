from itertools import combinations

def solution(orders, course):
    answer = []
    n = len(orders) #주문한 인원수
    menu = [[] for i in range(n)] #각 사람이 주문한 메뉴의 course개수로의 조합 리스트
    num = [[0] for i in range(len(course))] #course와 같은 길이의 리스트 (가장 많이 주문된 메뉴 찾기위함) 리스트 예시 : [[4, 'AC'], [2, 'ACD', 'BEF'], [0]]

    for i in range(n): #menu리스트 채우는 for문
        for j in course:
            menu[i].append(list(combinations(sorted(orders[i]), j))) #조합 구할 때에도 정렬해서 구해야함
        menu[i] = sum(menu[i], [])

    for i in range(n - 1):
        for j in menu[i]:
            count = 0
            idx = course.index(len(j)) #몇 개의 조합인지, 그 수에 해당하는 course 인덱스
            for k in range(i + 1, n):
                if j in menu[k]:
                    count += 1 #다른 사람의 주문 메뉴에도 있는 조합이면 +1
            if count >= 1: #본인이 주문한 횟수 제외 count이므로 1이상이면 가능
                if num[idx][0] < count: #저장되어있는 횟수보다 크다면 해당 데이터로 저장
                    num[idx] = [count, ''.join(j)]
                elif num[idx][0] == count: #최대 횟수와 동일하면 추가
                    num[idx].append(''.join(j))

    for i in num:
        if i[0] > 0: #i[0] = 0이면 해당 개수 조합이 2번 이상 주문된 적이 없다는 것이므로 0보다 클때만
            for j in range(1, len(i)): #저장되어있는 조합 answer에 추가
                answer.append(i[j])

    return sorted(answer) #정렬해서 리턴
