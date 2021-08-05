def solution(s):
    answer = ''
    
    for i in range(len(s)):
        if i == 0: #첫문자는 무조건
            answer += s[i].upper()
        else:
            if s[i-1] == " ": #이전이 띄어쓰기였다면
                answer += s[i].upper() #대문자
            else: #아니면
                answer += s[i].lower() #소문자
    
    return answer
