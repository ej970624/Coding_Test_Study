def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5
    
    answer = 0
    cache = ['' for i in range(cacheSize)]
    
    for i in range(len(cities)):
        if cities[i].lower() not in cache:
            answer += 5
            cache.pop(0)
        else:
            answer += 1
            cache.remove(cities[i].lower())
        cache.append(cities[i].lower())
    
    return answer
