#include <iostream>
#include <vector>

using namespace std;

int partition(vector<int> &arr, int l, int r, int pivotIndex);

void sort(vector<int> &arr, int l = 0, int r = -1) {
  if (r == -1) {
    r = arr.size() - 1;
  }
  if (l >= r) {
    return;
  }
  auto p = partition(arr, l, r, r);
  sort(arr, l, p-1);
  sort(arr, p+1, r);
}

int partition(vector<int> &arr, int l, int r, int pivotIndex) {
  if (l >= r) {
    return pivotIndex;
  }
  auto pivot = arr[pivotIndex];
  auto newPivotIndex = l;
  swap(arr[r], arr[pivotIndex]);
  for (auto i = l; i <= r; i++) {
    if (arr[i] < pivot) {
      swap(arr[i], arr[newPivotIndex]);
      newPivotIndex++;
    }
  }
  swap(arr[r], arr[newPivotIndex]);
  return newPivotIndex;
}

int main() {
  vector<int> arr = {4159, 8611, 1019, 6366, 4633, 3886, 3880, 1217, 715, 3936, 3251, 3930, 9125, 396, 3870, 4518, 4240, 1813, 1180, 5856, 9583, 4145, 1885, 2711, 9100, 4247, 8037, 6459, 2098, 8723, 2049, 8322, 9641, 4588, 2434, 6101, 613, 9146, 7962, 1724, 8076, 3197, 9432, 8296, 5204, 6092, -44, 6439, 8284, 2766, 7071, 9762, 1863, 4372, 5856, 3118, 6805, 4884, 6955, 155, 9485, 6310, 9541, 6093, 3524, 6302, 7796, 4836, 6740, 690, 1246, 9030, 294, 9939, 9223, 2837, 292, 8627, 513, 9079, 7999, 3645, 9469, 5166, 1298, 7649, 5924, 1207, 2807, 2898, 7381, 282, 4341, 991, 2609,4997, 4313, 6313, 1102, 1595};
  sort(arr);
  for (auto i : arr) {
    cout << i << endl;
  }
  return 0;
}