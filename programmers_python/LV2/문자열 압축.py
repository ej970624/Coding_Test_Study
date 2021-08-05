def solution(s):
    length = []
    size = len(s)    
    if size == 1:
        return 1

    for i in range(1, size//2+1):
        key = s[:i]
        remain = size%i
        length.append(i+remain)
        cnt = 1
        for j in range(i, size-remain, i):
            if key == s[j:j+i]:
                cnt += 1
            else:
                if cnt > 1:
                    length[-1] += len(str(cnt))
                length[-1] += i
                key = s[j:j+i]
                cnt = 1
        if cnt > 1:
            length[-1] += len(str(cnt))

    return min(length)
