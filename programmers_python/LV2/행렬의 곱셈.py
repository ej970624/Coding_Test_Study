def solution(arr1, arr2):
    answer = [[0 for j in range(len(arr2[0]))] for i in range(len(arr1))] #정답의 행은 arr1의 행, 열은 arr2의 열과 같음

    for i in range(len(arr1)): #arr1의 행 = 정답의 행 => i
        for j in range(len(arr2[0])): #arr2의 열 = 정답의 열 => j
            s = 0
            for k in range(len(arr2)): #arr1의 열과 arr2의 행의 개수는 같음 => k
                s += arr1[i][k] * arr2[k][j]
            answer[i][j] = s

    return answer
