def solution(s):
    answer = True
    stack = []
    
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(s[i])
        else:
            if stack:
                if stack.pop() == ')':
                    return False
            else:
                return False
    
    if len(stack) > 0:
        return False

    return True
