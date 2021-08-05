def solution(n):
    answer = ''
    three = [] #3의 0제곱부터 19제곱까지 저장하는 리스트
    m = [0] #숫자를 선택할 때 남아야 하는 최솟값을 저장하는 리스트 ex) 3의 3제곱인 81을 선택한다면 1+3+9+27 = 40이 최소 남아야함
    n = int(n)

    for i in range(20):
        three.append(3 ** i)
        if i > 0:
            m.append(m[-1] + three[i-1])

    for i in range(19, -1, -1):
        if n >= three[i]: 
            for j in range(3, 0, -1):
                if n > three[i] * j and n - three[i] * j >= m[i]:
                    if j == 3:
                        answer += '4'
                    else:
                        answer += str(j)
                    n -= three[i] * j
                    break
                elif n == three[i] * j and i == 0:
                    if i == 0:
                        if j == 3:
                            answer += '4'
                        else:
                            answer += str(j)
                        break

    return answer
