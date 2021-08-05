def function(n, i, j, arr, answer):
    if n == 1 or arr[i][j] == -1:
        return
    key = arr[i][j]
    flag = True
    
    for x in range(i, i+n):
        for y in range(j, j+n):
            if arr[x][y] != key:
                flag = False
                break
        if flag is False:
            break
            
    if flag is True:
        answer[key] += 1
        for x in range(i, i+n):
            for y in range(j, j+n):
                arr[x][y] = -1
    else:
        function(n//2, i, j, arr, answer)
        function(n//2, i+n//2, j, arr, answer)
        function(n//2, i, j+n//2, arr, answer)
        function(n//2, i+n//2, j+n//2, arr, answer)
            

def solution(arr):
    answer = [0, 0]
    n = len(arr)
    
    function(n, 0, 0, arr, answer)
    for i in range(n):
        for j in range(n):
            if arr[i][j] != -1:
                answer[arr[i][j]] += 1
                
    return answer
