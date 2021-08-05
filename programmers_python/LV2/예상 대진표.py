def solution(n, a, b):
    for i in range(20):
        if 2**(i+1) >= abs(a-b)+1: #2, 4, 8, 16, ... 2의 제곱수 만큼 토너먼트 올라가면서 시합인원의 수이므로 a와 b의 차이+1보다는 적어도 같거나 커야 함
            s =2**(i+1) #예를 들어 a = 16, b = 19일 경우 차이+1은 4이므로 4명씩부터 확인 s = 4
            for j in range(int(n/s)): #전체 인원이 32라면 n/s = 8 (j = 0~7)
                if j*s < a <= (j + 1)*s: #0<a<=4, 4<a<=8, .. 순으로 확인하면 a=16이므로 12<a<=16이지만 / s=32일 때 0<a<=32, 0<b<=32 모두 충족 -> 8번 라인으로
                    if j*s < b <= (j+1)*s: #12<b<=16이 아니기 때문에 for문 나감(a와 b가 같은 범위에 같이 있지 않다면)
                        return i+1 #32는 2의 5승이므로 5번째에 만나는 것~~~~
                    else:
                        break 
