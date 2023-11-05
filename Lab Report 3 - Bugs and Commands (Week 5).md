# Lab Report 3 - Bugs and Commands (Week 5)
## Part 1 - Bugs
Bug: `reverseInPlace`

1:
```
@Test 
public void testReverseInPlace() {
  int input[] = {1, 2, 3, 4, 5};
  int expected[] = {5, 4, 3, 2, 1};
  assertArrayEquals(expected, reverseInPlace(input);
}
```
2:
```
@Test 
public void testReverseInPlace() {
  int input[] = {5};
  int expected[] = {5};
  assertArrayEquals(expected, reverseInPlace(input);
}
```
3:

4: 
- Before:
  ```
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
  ```
- After:
  ```
  static void reverseInPlace(int[] arr) {
    int[] tempArr = arr;
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = tempArr[arr.length - i - 1];
    }
  }
  ```
This implementation fixes the bug because previously, the first half of the contents were being overwritten by the second half. So when the list interated to the second half, the same elements would be written. This implements creates a duplicate array and when reversing `arr`, it uses elements from the duplicate array so even when the loop iterates to the second half, the values are taken from the duplicate array which has the original elements as opposed to `arr`'s overwritten elements.
## Part 2 - Researching Commands
Command: `grep`
1. `-f`
   
  a. The image shows the partial output of the command `grep -f basePairBiomedLines.txt basePairInBiomed.txt`, the remaining output is just the rest of the matched patterns in the file which could not be displayed on the screen at the same time. The     command takes the file "basePairBiomedLines.txt" as input for patterns and matches it with the contents of "basePairInBiomed.txt" and returns all the lines which contain the patterns found in "basePairBiomedLines.txt".

    ![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img6.png)
