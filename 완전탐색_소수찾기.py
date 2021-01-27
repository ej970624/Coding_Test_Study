import itertools

def solution(numbers):
    lst = []
    tmp = []
    lst2 = []
    answer = 0
    
    for i in numbers:
        tmp.append(i) #numbers를 리스트로 바꾸기
    
    for i in range(1, len(numbers)+1):
        lst.append(list(map(''.join, itertools.permutations(tmp, i)))) #순열 len(numbers) 중에 1 ~ len(numbers)개 뽑아서 lst에 저장
        
    for item in lst: #2중 리스트인 것을 하나의 원소씩 int로 바꿔 lst2에 저장(이때 이미 있거나 1이하의 수일 경우 저장하지 않음)
        for i in item:
            if int(i) not in lst2 and int(i) > 1:
                lst2.append(int(i))
                
    for i in lst2: #가능한 모든 숫자조합이 들어있는 lst2
        flag = True
        for j in range(2, i): #2부터 해당숫자 전까지 나눠지는 수가 있는지 확인
            if i % j == 0: #나눠지는게 있다면 소수가 아님
                flag = False
                break
        if flag == True: #나눠지는게 없어서 flag가 그대로 True일 경우 answer + 1
            answer += 1
            
    return answer
