# Lab Report 5 - Putting it All Together (Week 9)
## Part 1 - Debugging Scenario

1. Hello, recently I was working on an autograder bash script called `grade.sh` and have implemented everything correctly but the file seems to have an error with junit. When I run it: `bash grade.sh https://github.com/ucsd-cse15l-f22/list-methods-corrected`, I get the following error:

![img25](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/5cca5119-8b9a-4804-896c-8859540c4ce7)

I have a guess to as why this may be happening which is that maybe I am using an outdated version of junit which is not recognized correctly or maybe bash files run `javac` commands differently but I am not sure how I can fix this. Could you please provide some input? Thanks, Yash.

2. Oh this is interesting. Have you confirmed if the `lib` folder can be found as mentioned in your `CPATH` variable, and if the junit packages are named the same? Can you try using the `ls` command to check if the files which you are trying to refer to are present?

3. Ok so I tried what you suggested but there seems to be no problem with the junit files or the lib folder. This is what my `CPATH` variable looks like:

![img26](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/58c8d4a4-5443-46c4-a8a5-8da3446dd9f0)

and this is the `lib` folder and files in the directory: 

![img27](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/3e02ebe4-8db3-4251-8e13-9c1087194635)

They both match perfectly which means the `javac` command should work correctly. I can also confirm that the issue is with the `javac` command as the "Correct file submitted" and the "Compilation failed! Exit code: 1" messages sandwich the error and the only command associated with junit in that section is `javac.exe -cp $CPATH ./grading-area/*.java`.

![img28](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/0fbe8489-671b-4be8-9933-2890643f81c3)

4. Ok thanks for the images and context it seems like I have figured out what the problem is. However, first let me jsut confirm the file structure:

```
./list-examples-grader/

  ./grading-area/
  
    isMoon.class
    
    ListExamples.class
    
    ListExamples.java
    
    StringChecker.class

    TestListExamples.class
    
    TestListExamples.java
    
  ./lib/
  
    hamcrest-core-1.3.jar
    
    junit-4.13.2.jar
    
  GradeServer.java
  
  Server.java
  
  TestListExamples.java
  
  grade.sh

with `grade.sh`'s contents being:
```

```
rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# list-examples-grader
#   lib
#       hamcrest-core-1.3.jar
#       junit-4.13.2.jar
#   grade.sh
#   GradeServer.java
#   Server.java
#   TestListExamples.java
#   grading-area
#   student-submission
#       ~GIT FOLDER CLONED~

# Then, add here code to compile and run, and do any post-processing of the
# tests

if [[ -f ./student-submission/ListExamples.java ]]
then
    echo ""
    echo "Correct file submitted!"
    echo ""
else
    echo ""
    echo "Incorrect submission! Please submit ListExamples.java"
    echo ""
    exit
fi

cp -r ./student-submission/*.java ./grading-area/
cp ./TestListExamples.java ./grading-area/

javac.exe -cp $CPATH ./grading-area/*.java

compileExitCode=$?

if [[ $compileExitCode -eq 0 ]]
then
    echo "Compilation successful!"
else
    echo "Compilation failed! Exit code: $compileExitCode"
    exit
fi
```


## Part 2 - Reflection

Soemthing new I learned in the second half of the quarter in labs is how to use the command line interface to interact with git, as in adding, commiting, and pushing updates to the web where the changes can be accessed by everyone. 
I found this cool because previously whenever I wanted to update a github page online with new files or code, I always used GitHub desktop and thought that it was the only way. However, through the command line it is much easier
and makes more sense as most work is also done through the command line. Another thing I learned is that for ssh only one key was needed for both passwordless connection to the ieng6@ucsd.edu computers and to github from my local
machine. I had assumed that I would need to generate a new key and put it into github if i wanted to connect it to the terminal and use ssh cloning but the same key that connects my machine to the ucsd computers can also connect me
to github.
