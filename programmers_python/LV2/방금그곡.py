def changeStr(s, dic): 
    changeS = ''
    for i in range(len(s)-1):
        if s[i] == '#':
            continue
        if s[i+1] == '#':
            changeS += dic[s[i:i+2]]
        else:
            changeS += s[i]
    if s[-1] != '#':
        changeS += s[-1]

    return changeS

def solution(m, musicinfos):
    dic = {'A#':'a', 'C#':'c', 'D#':'d', 'E#':'e', 'F#':'f', 'G#':'g'}
    changeM = changeStr(m, dic)
    melody = []
    songInfo = []
    answer = '(None)'

    for i in musicinfos:
        info = i.split(',')
        if info[0][:2] == info[1][:2]:
            time = int(info[1][3:]) - int(info[0][3:])
        else:
            time = (int(info[1][:2]) - int(info[0][:2]) - 1) * 60
            time += 60 + int(info[1][3:]) - int(info[0][3:])
        songInfo.append([time, info[2]])
        info[3] = changeStr(info[3], dic)

        if time < len(info[3]):
            melody.append(info[3][:time])
        else:
            melody.append(info[3] * (time // len(info[3])+1))

    maxTime = 0
    for i in range(len(melody)):
        if changeM in melody[i]:
            if maxTime < songInfo[i][0]:
                maxTime = songInfo[i][0]
                answer = songInfo[i][1]

    return answer
