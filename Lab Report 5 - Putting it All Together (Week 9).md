# Lab Report 5 - Putting it All Together (Week 9)
## Part 1 - Debugging Scenario

1. Hello, recently I was working on an autograder bash script called `grade.sh` and have implemented everything correctly but the file seems to have an error with junit. When I run it: `bash grade.sh https://github.com/ucsd-cse15l-f22/list-methods-corrected`, I get the following error:

![img25](https://github.com/fyash1010/cse15l-lab-reports/assets/146874433/5cca5119-8b9a-4804-896c-8859540c4ce7)

I have a guess to as why this may be happening which is that maybe I am using an outdated version of junit which is not recognized correctly or maybe bash files run javac commands differently but I am not sure how I can fix this. Could you please provide some input? Thanks, Yash.


## Part 2 - Reflection

Soemthing new I learned in the second half of the quarter in labs is how to use the command line interface to interact with git, as in adding, commiting, and pushing updates to the web where the changes can be accessed by everyone. 
I found this cool because previously whenever I wanted to update a github page online with new files or code, I always used GitHub desktop and thought that it was the only way. However, through the command line it is much easier
and makes more sense as most work is also done through the command line. Another thing I learned is that for ssh only one key was needed for both passwordless connection to the ieng6@ucsd.edu computers and to github from my local
machine. I had assumed that I would need to generate a new key and put it into github if i wanted to connect it to the terminal and use ssh cloning but the same key that connects my machine to the ucsd computers can also connect me
to github.