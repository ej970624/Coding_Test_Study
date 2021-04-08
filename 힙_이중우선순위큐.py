def solution(operations):
    answer = []
    
    for i in operations:
        val = i.split()
        if val[0] == "I":
            answer.append(int(val[1]))
        else:
            if len(answer) == 0:
                continue
            if val[1] == "1":
                answer.remove(max(answer))
            else:
                answer.remove(min(answer))
                
    if len(answer) == 0:
        return [0, 0]
    
    return [max(answer), min(answer)]
