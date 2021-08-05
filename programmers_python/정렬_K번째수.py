def solution(array, commands):
    answer = []
    
    for item in commands:
        l = array[item[0]-1:item[1]]
        l.sort()
        answer.append(l[item[2]-1])
    
    return answer
