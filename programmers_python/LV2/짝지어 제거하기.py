def solution(s):    
    while True:
        flag = False
        for i in s:
            st = i+i
            if st in s:
                s = s.replace(st, "")
                flag = True
                break
        if flag is False:
            return 0
        if len(s) == 0:
            return 1
