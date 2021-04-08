def solution(jobs):
    num = len(jobs)
    jobs.sort(key = lambda x: (x[0], x[1]))
    answer = jobs[0][1]
    start = jobs[0][0] + jobs[0][1]
    jobs.pop(0)

    while len(jobs)>0:
        tmp = []
        for i in jobs:
            if i[0] > start:
                break
            tmp.append(i)

        if tmp == []:
            answer += jobs[0][1]
            start += jobs[0][1]
            del jobs[0]
        else:
            tmp.sort(key=lambda x: x[1])
            i = tmp.pop(0)
            jobs.remove(i)
            start += i[1]
            answer += start - i[0]

    return answer//num
