def solution(s):
    answer = 0
    length = len(s)
    count = 0 #회전하는 괄호를 체크하기 위해 시작하는 인덱스
    dic = {'(':1, ')':-1, '[':2, ']':-2, '{':3, '}':-3} #열리는 괄호는 양수, 닫히는 괄호는 음수로 딕셔너리에 저장
    
    while count < length:
        flag = True
        stack = []
                
        for i in range(length):
            if i+count >= length: #인덱스 범위가 넘어가면 0부터
                idx = i+count - length
            else:
                idx = i+count
            if dic[s[idx]] > 0: #열리는 괄호면
                stack.append(dic[s[idx]]) #스택에 추가
            else: #닫히는 괄호면
                if stack == []: #스택에서 빼야하는데 스택이 비어있다면 잘못된 괄호임
                    flag = False 
                    break
                else: #비어있지 않다면
                    if stack.pop() != abs(dic[s[idx]]): #스택에서 마지막꺼 뽑아서 절댓값이 같은지 비교(같으면 올바른 괄호, 다르면 잘못된 괄호)
                        flag = False 
                        break
        
        if flag is True and stack == []: #괄호를 다 체크한 후에도 flag가 True이고 스택이 비어있으면 올바른 괄호임
            answer += 1
            
        count += 1
    
    
    return answer
