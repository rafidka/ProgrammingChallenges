with open('data.txt', 'r') as f:
  data = [int(n) for n in f.readline().split(',')]

l = 0
r = len(data) - 1

while l < r:
  if data[l] < data[r]:
    break
  m = l + (r - l) // 2
  if data[m] > data[r]:
    l = m + 1
  else:
    r = m

print(l)
