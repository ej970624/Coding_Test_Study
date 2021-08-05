def solution(record):
    answer = []
    message = [] #[['Enter', 'id1', 'Eunji'], ['Leave', 'id1']] 이런 식의 리스트
    uid = dict() #id마다 회원의 닉네임을 저장하기 위한 딕셔너리

    for i in record: #message리스트와 uid딕셔너리 저장과정
        message.append(i.split(" "))
        if message[-1][0] == "Enter" or message[-1][0] == "Change": #Enter나 Leave할 때마다 id갱신
            uid[message[-1][1]] = message[-1][2]

    for i in message:
        if i[0] == "Enter":
            answer.append(uid[i[1]] + "님이 들어왔습니다.")
        if i[0] == "Leave":
            answer.append(uid[i[1]] + "님이 나갔습니다.")

    return answer
