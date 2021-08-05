def solution(str1, str2):
    sub1 = []
    sub2 = []
    inter = []
    
    for i in range(len(str1)-1):
        alpha = str1[i:i+2]
        if alpha.isalpha():
            sub1.append(alpha.lower())
        
    for i in range(len(str2)-1):
        alpha = str2[i:i+2]
        if alpha.isalpha():
            sub2.append(alpha.lower())
            
    if len(sub2) == 0:
        return 65536
          
    intersection = 0
    union = len(sub1) + len(sub2)
    
    for i in sub1:
        if i in inter:
            continue
        if i in sub2:
            intersection += min(sub1.count(i), sub2.count(i))
            union -= min(sub1.count(i), sub2.count(i))
        inter.append(i)
            
    return int((intersection / union) * 65536)
