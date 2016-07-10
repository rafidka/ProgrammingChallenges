from random import randint, seed

with open('data.txt', 'r') as f:
  data = [int(n) for n in f.readline().split(',')]

l = 0
r = len(data) - 1

print("Data: " + str(data))
print("Sorted data: " + str(sorted(data)))


def partition(data, pv_idx, left, right):
  pv = data[pv_idx]
  new_pv_idx = left
  data[pv_idx], data[right] = data[right], data[pv_idx]
  for i in range(left, right):
    if data[i] < pv:
      data[i], data[new_pv_idx] = data[new_pv_idx], data[i]
      new_pv_idx += 1
  data[new_pv_idx], data[right] = data[right], data[new_pv_idx]
  return new_pv_idx

k = 3
kth_largest = -1
while l <= r:
  pv_idx = partition(data, randint(l, r), l, r)
  diff = r - pv_idx
  if diff == k - 1:
    # The pivot is the kth largest element.
    kth_largest = data[pv_idx]
    break
  elif diff > k - 1:
    l = pv_idx + 1
  else:
    k -= diff + 1
    r = pv_idx - 1

if kth_largest != -1:
  print('The kth largest element is: ' + str(kth_largest))
elif k > len(data):
  print('There is no kth largest element.')
else:
  print("Couldn't find the kth largest element for some reason! Please investigate.")
