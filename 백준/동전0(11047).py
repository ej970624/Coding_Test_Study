n, k = map(int, input().split())
money = []
answer = 0

for i in range(n):
    money.append(int(input()))
    
money.sort(reverse=True) #큰 순서로 정렬

for i in money:
    num = k//i
    k -= num*i #사용한만큼 k값 변경
    answer += num
    if k == 0: #0원 되면 break
        break        

print(answer)
