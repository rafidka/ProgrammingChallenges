with open('data.txt', 'r') as f:
  data = [int(n) for n in f.readline().split(',')]

l = 0
r = len(data) - 1
index = -1

while l <= r:
  m = l + (r - l) // 2
  if data[m] == m:
    index = m
    break
  elif data[m] < m:
    l = m + 1
  else:
    r = m - 1

print(index)
