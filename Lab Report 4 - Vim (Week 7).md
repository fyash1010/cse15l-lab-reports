# Lab Report 4 - Vim (Week 7)

1. `ssh cs15lfa23kq@ieng6.ucsd.edu` `<enter>`: The `ssh` command initiates the remote connection to the remote computers located at ieng.ucsd.edu.

![img14](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/db143327-4f4a-4f70-b3a0-8e78796ff71c)

2. `git clone git@github.com:fyash1010/lab7.git` `<enter>`: This line clones the fork of the lab7 repository into the remote server.

![img15](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/3468ef5b-865c-4c9b-ae88-8bcc21c18205)

3. `cd lab7/` `<enter>`: `cd` allows us to change the current working directory into `/home/linux/ieng6/cs15lfa23/cs15lfa23kq/lab7` where all the imported files are located.

![img16](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/c6072b67-d6d9-421b-b01c-d92c898b95e5)

4. `bash test.sh` `<enter>`: Runs the `test.sh` script which runs the junit tests.

![img17](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/309f2d66-b9de-4537-823a-295d2805b1c9)

5. `vim ListExamples.java` `<enter>`: Opens `ListExamples.java` in the vim editor so we can edit its contetnts.

![img18](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/234963a2-48db-4c0f-add1-3eae6846c5c9)

6. `<PgDn><up><up><up><up><up><up><1><e><s><2><esc><:wq><enter>`: First the `<PgDn>` and `<up>`s navigate to the line `index1 += 1;` under the comment `// change index1 below to index2 to fix test`, then the `<1><e>` jumps to 1 character behind the first word on the line (between x and 1). Once the cursor is in the correct position, `<s>` deletes the next character (1) and goes into insert mode where pressing `<2>` fixes the code, making the new line `index2 += 1`. Finally, `<esc>` makes the vim window return to default mode from insert, and `<:wq>` is the command to save changes to the file and quit.

![img19](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/c91528cd-de70-4371-9083-d3aaa816e9dc)

7. `bash test.sh` `<enter>`: Again, after fixing the file, the command runs the script which runs the junit tests.

![img20](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/611c4e53-6523-4814-8b41-3225daa58650)

8. `git add ListExamples.java` `<enter>`: Adds the `ListExamples.java` file to the files waiting to be commited and pushed.

![img21](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/9c6a22e3-8067-4e48-bcb2-4a6590670654)

9. `git commit` `<enter>`: Commits all files in the queue and takes us to the vim page where we write our commit message.

![img22](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/30af8e04-6b3d-411a-98a9-af7f3b7a1c36)

10. "Commit" `<esc><:wq><enter>`: Writes "Commit" as the commit message and the `<esc><:wq>` commands save and exit the file, completing the commit process.

![img23](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/ef24d50c-28d4-46fa-8a17-16a857c5150e)

12. `git push` `<enter>`: Pushes the latest commit to the online github repository for it to be viewable by everyone on the web.

![img24](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/5cb1fec8-5148-4f5c-b3a6-43afac6ce4b6)
