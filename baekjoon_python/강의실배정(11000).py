import heapq
import sys #그냥 input으로 받으면 시간초과 뜸..

n = int(input())
time = []

for i in range(n):
    time.append(list(map(int, sys.stdin.readline().split())))

time.sort(key=lambda x:x[0]) #시작시간 순으로 정렬
finish = [time[0][1]] #강의실마다 수업 끝나는 시간 저장하는 힙
for i in range(1, n):
    if finish[0] > time[i][0]:
        heapq.heappush(finish, time[i][1])
    else:
        heapq.heappop(finish)
        heapq.heappush(finish, time[i][1])
        
print(len(finish)) #finish의 길이가 강의실 개수
