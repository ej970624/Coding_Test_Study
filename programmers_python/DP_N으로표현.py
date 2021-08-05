def solution(N, number):
    if N == number:
        return 1
    
    S = [0, {N}]
    for i in range(2, 9):
        case_set = {int(str(N)*i)}
        for i_half in range(1, i//2+1):  # S[i_half] S[1]
            for x in S[i_half]:
                for y in S[i-i_half]:
                    case_set.add(x+y)
                    case_set.add(x-y)
                    case_set.add(y-x)
                    case_set.add(x*y)
                    if x != 0:
                        case_set.add(y//x)
                    if y != 0:
                        case_set.add(x//y)
        if number in case_set:
            return i
        S.append(case_set)
    return -1
