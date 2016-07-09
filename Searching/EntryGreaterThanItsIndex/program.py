with open('data.txt', 'r') as f:
  data = [int(n) for n in f.readline().split(',')]

key = -13

l = 0
r = len(data) - 1
index = -1

while l <= r:
  m = l + (r - l) // 2
  if data[m] > key:
    r = m - 1
    index = m
  elif data[m] == key:
    l = m + 1
  else:
    l = m + 1

print(index)
