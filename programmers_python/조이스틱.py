def solution(name):
    answer = 0
    findA = []
    l = [len(name)-1]
    alpha = {'A':0, 'B':1, 'C':2, 'D':3, 'E':4, 'F':5, 'G':6, 'H':7, 'I':8, 'J':9, 'K':10, 'L':11, 'M':12, 'N':13, 'O':12, 'P':11, 'Q':10, 'R':9, 'S':8, 'T':7, 'U':6, 'V':5, 'W':4, 'X':3, 'Y':2, 'Z':1}
    
    for i in name:
        answer += alpha.get(i)
        
    if name.find('A') == -1:
        answer += len(name)-1
        return answer
    
    for i in range(len(name)):
        if name[i] != 'A':
            continue
        else:
            if i == 0:
                findA.append([0, 1])
            else:
                if name[i-1] != 'A':
                    findA.append([i, 1])
                else:
                    findA[-1][1] += 1
        
    for item in findA:
        before = item[0]
        after = len(name) - item[0] - item[1]
        if (before != 0):
            l.append((before-1) * 2 + after)
        if (after != 0):
            l.append(before + (after-1) * 2 + 1)
        
    answer += min(l)
        
    return answer
