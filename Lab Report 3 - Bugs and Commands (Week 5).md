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

![img25](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/07c3c61c-8c74-4657-89e6-218916ba71ba)

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
![img6](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/cb3e9c47-4190-4640-b60d-e2cff55632fb)

- Running the command `grep -f ./technical/911report ./technical/biomed` gives an error saying that the arguments are directories. This error occurs because `grep -f` looks for patterns found in files and not directories so when it is given directories as inputs instead of files, it just returns `grep: ARGUMENT1: Is a directory`.
![img7](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/1c23a3c8-669b-449f-b5b7-384907581395)

2. `-e`: Source: `man grep`
- The command compares takes in the first argument ("Introduction") as the pattern and compares it with the contents in the second argument ("1468-6708-3-1.txt"). The command then returns the matching contents to the terminal.
![img8](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/0de32dab-677e-47a0-97cc-e8bb3aa0aea4)

- Similar to `-f`, when a directory is passed to the `grep -e` command instead of a file, the terminal outputs the error `grep: ARGUMENT1: Is a directory`. This is because the terminal is expecting a file to match the pattern in but is given a directory instead of a file.
![img9](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/209e5551-c158-495e-a3d0-a1b72666f31e)

3. `-i`: Source: `man grep`
- The `grep -i` command is incredibly similar to the `grep -e` command in the sense that it takes an arguemnt as a pattern and matches it with the contents of the file passed as the second argument. The only difference however is that `-e` is case sensative meaning it will not match "Happy" with "happy" or "hApPy" while `-i` takes away the case sensitive nature.
![img10](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/db83c476-a8b8-4712-bc3e-dd9c909cd887)

- When the command is ran the terminal outputs the same error: `grep: ARGUMENT1: Is a directory` because it expects a file but is given a directory.
![img11](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/87f5417c-165e-466a-ab78-b18f4ca8e8d3)

4. `-w`: Source `man grep`
- Although the output of the `grep -w` command might seem similar to the ones with `-i` and `-e`, it is different because rather than matching patterns, it matches words. For example, `-e` would match "Da" with a line contaning the word "Have a good Day" because the pattern "Da" is found within it. But `-w` only matches entire words in a case sensitive manner meaning it will only match when the entire word is found on the line.
![img12](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/64d6801e-322c-4079-b189-684e15703015)

- As seen in all other variations of this command, the output when running with a directory is `grep: ARGUMENT1: Is a directory`. This happens because whether the `-e` or `-i` or -`w` flag is given, the basic functionality of the `grep` command is still to match patterns and words within a file. However, it is possible to use the `-r` flag which stands for "recursively" to input a directory and search within every file in the directory.
![img13](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/a34f5526-03bb-492f-80f2-95188bd12abd)
