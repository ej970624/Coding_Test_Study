lst = []
def solution(numbers, target):
    answer = 0
    
    dfs(numbers, 0, 0)
    for i in lst:
        if i == target:
            answer += 1
    
    return answer

def dfs(arr, idx, total):
    if idx == len(arr):
        lst.append(total)
        return
    
    dfs(arr, idx+1, total+arr[idx]*1)
    dfs(arr, idx+1, total+arr[idx]*(-1))
