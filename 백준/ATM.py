n = int(input())
time = list(map(int, input().split()))
total = 0

time.sort() #소요시간이 낮은 순으로 이용하는 것이 최단시간
for i in range(n):
    total += time[i] * (n - i) 
    
print(total)
