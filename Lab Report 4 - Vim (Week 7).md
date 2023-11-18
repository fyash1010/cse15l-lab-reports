# Lab Report 4 - Vim (Week 7)

1. `ssh cs15lfa23kq@ieng6.ucsd.edu` `<enter>`: The `ssh` command initiates the remote connection to the remote computers located at ieng.ucsd.edu.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img14.png)

3. `git clone git@github.com:fyash1010/lab7.git` `<enter>`: This line clones the fork of the lab7 repository into the remote server.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img15.png)

4. `cd lab7/` `<enter>`: `cd` allows us to change the current working directory into `/home/linux/ieng6/cs15lfa23/cs15lfa23kq/lab7` where all the imported files are located.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img16.png)

5. `bash test.sh` `<enter>`: Runs the `test.sh` script which runs the junit tests.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img17.png)

6. `vim ListExamples.java` `<enter>`: Opens `ListExamples.java` in the vim editor so we can edit its contetnts.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img18.png)

7. `<PgDn><up><up><up><up><up><up><1><e><s><2><esc><:wq><enter>`: First the `<PgDn>` and `<up>`s navigate to the line `index1 += 1;` under the comment `// change index1 below to index2 to fix test`, then the `<1><e>` jumps to 1 character behind the first word on the line (between x and 1). Once the cursor is in the correct position, `<s>` deletes the next character (1) and goes into insert mode where pressing `<2>` fixes the code, making the new line `index2 += 1`. Finally, `<esc>` makes the vim window return to default mode from insert, and `<:wq>` is the command to save changes to the file and quit.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img19.png)

8. `bash test.sh` `<enter>`: Again, after fixing the file, the command runs the script which runs the junit tests.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img20.png)

9. `git add ListExamples.java` `<enter>`: Adds the `ListExamples.java` file to the files waiting to be commited and pushed.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img21.png)

10. `git commit` `<enter>`: Commits all files in the queue and takes us to the vim page where we write our commit message.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img22.png)

11. "Commit" `<esc><:wq><enter>`: Writes "Commit" as the commit message and the `<esc><:wq>` commands save and exit the file, completing the commit process.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img23.png)

12. `git push` `<enter>`: Pushes the latest commit to the online github repository for it to be viewable by everyone on the web.

![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img24.png)
