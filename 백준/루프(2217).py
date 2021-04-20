n = int(input())
rope = []
    
for i in range(n):
    rope.append(int(input()))
        
rope.sort(reverse=True) #최대중량이 큰 순대로 정렬

for i in range(n):
    rope[i] *= (i+1) #큰 순서부터 루프를 하나씩 더해가며 최대중량 측정(같이 이용하는 루프 중 가장 낮은 루프의 최대중량 * 이용하는 루프 수가 처음부터 해당 루프까지 이용했을 때의 최대 중량_
        
print(max(rope)) #그 중 가장 높은 값 출력
