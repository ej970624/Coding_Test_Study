#def solution(scoville, K):
#    answer = 0
#    
#    while min(scoville) < K:
#        if len(scoville) < 2:
#            return -1
#        
#        scoville.sort(reverse=True)
#        scoville.append(scoville.pop()+(scoville.pop()*2))
#        answer += 1
#    
#    return answer

import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1
        heapq.heappush(scoville, heapq.heappop(scoville)+heapq.heappop(scoville)*2)
        answer += 1
    
    return answer
