def solution(bridge_length, weight, truck_weights):
    answer = 1
    start = [1] #트럭 다리 들어갈 때의 시간
    que = [truck_weights.pop(0)] #다리 위의 트럭 리스트
    now_weight = que[0] #현재 다리 위에 있는 트럭들의 무게 합

    while len(truck_weights) > 0:
        answer += 1
        if start[0] + bridge_length == answer: #다리 위의 첫 트럭이 도착지에 도착하면
            now_weight -= que.pop(0)
            start.pop(0)
        if now_weight + truck_weights[0] <= weight: #다음 트럭이 들어갈 수 있다면 (무게비교)
            now_weight += truck_weights[0]
            que.append(truck_weights.pop(0))
            start.append(answer)
        else: #들어갈 수 없다면 다리 위의 첫 트럭이 도착하기 전으로 이동
            answer = start[0] + bridge_length - 1

    return start[-1] + bridge_length
