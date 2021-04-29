import sys
from itertools import combinations

k = []
s = []

while True:
    x = list(map(int, sys.stdin.readline().split()))
    if x[0] == 0:
        break
    k.append(x[0])
    s.append(x[1:])

for i in s:
    for j in combinations(i, 6):
        for k in j:
            print(k, end=" ")
        print()
    print()
