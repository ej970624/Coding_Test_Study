def solution(phone_book):
    answer = True
    phone_book.sort() #str형으로 sort되므로 처음부분이 비슷한 순으로 정렬
    
    for i in range(len(phone_book)-1):
        if phone_book[i+1][:len(phone_book[i])] == phone_book[i]: #정렬로 인해 앞이 같다면 바로 다음것과 같을 것
            return False
    
    return answer
