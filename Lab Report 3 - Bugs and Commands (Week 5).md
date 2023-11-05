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
1. `-f`: Source: `man grep`
- The image shows the partial output of the command `grep -f basePairBiomedLines.txt basePairInBiomed.txt`, the remaining output is just the rest of the matched patterns in the file which could not be displayed on the screen at the same time. The     command takes the file "basePairBiomedLines.txt" as input for patterns and matches it with the contents of "basePairInBiomed.txt" and returns all the lines which contain the patterns found in "basePairBiomedLines.txt".
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img6.png)

- Running the command `grep -f ./technical/911report ./technical/biomed` gives an error saying that the arguments are directories. This error occurs because `grep -f` looks for patterns found in files and not directories so when it is given directories as inputs instead of files, it just returns `grep: ARGUMENT1: Is a directory`.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img7.png)

2. `-e`: Source: `man grep`
- The command compares takes in the first argument ("Introduction") as the pattern and compares it with the contents in the second argument ("1468-6708-3-1.txt"). The command then returns the matching contents to the terminal.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img8.png)

- Similar to `-f`, when a directory is passed to the `grep -e` command instead of a file, the terminal outputs the error `grep: ARGUMENT1: Is a directory`. This is because the terminal is expecting a file to match the pattern in but is given a directory instead of a file.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img9.png)

3. `-i`: Source: `man grep`
- The `grep -i` command is incredibly similar to the `grep -e` command in the sense that it takes an arguemnt as a pattern and matches it with the contents of the file passed as the second argument. The only difference however is that `-e` is case sensative meaning it will not match "Happy" with "happy" or "hApPy" while `-i` takes away the case sensitive nature.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img10.png)

- When the command is ran the terminal outputs the same error: `grep: ARGUMENT1: Is a directory` because it expects a file but is given a directory.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img11.png)
