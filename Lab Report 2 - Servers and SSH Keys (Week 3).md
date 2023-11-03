# Lab Report 2 - Servers and SSH Keys (Week 3)
## Part 1
Code: 
```
import java.util.*;
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    ArrayList<String> inpList = new ArrayList<String>();

    public String handleRequest(URI url) {
        if(url.getPath().equals("/")) {
            return String.format(String.join(", ", inpList));
        } else {
            if(url.getPath().contains("/add-message")) {
                String[] queryInput = url.getQuery().split("=");
                
                if(queryInput[0].equals("s")) {
                    inpList.add(queryInput[1]);

                    String outputString = "";

                    for(int a = 0; a < inpList.size(); a++) {
                        outputString += ((a + 1) + ". " + inpList.get(a) + "\n");
                    }

                    return String.format(outputString);
                } 
            } else if (url.getPath().contains("/search")) {
                String [] queryInput = url.getQuery().split("=");

                if(queryInput[0].equals("s")) {
                    ArrayList<String> returnList = new ArrayList<String>();

                    for(String queryElement : inpList) {
                        if(queryElement.contains(queryInput[1])) {
                            returnList.add(queryElement);
                        }
                    }

                    return String.format(String.join(", ", returnList));
                }
            }

            return "404 Not Found";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("Missing port number!");
            return;
        }

        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
```
Call 1:
![Image 1](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img1.png)
1. When running the `/add-message` command, the `handleRequest(URI url)` is called.
2. When `handleRequest(URI url)` is called, the entire url ("http://localhost:7018/add-message?s=Hello") is passed as type URI. In the `Handler` class, the updated fields are an array list named `inpList` which contains all the messages added {"Hello"}, an array of type String named `queryInput` which has the query split at "=" ("s", "Hello"), and a String `outputString` which contains the list in a numbered form to return "1. Hello\n".
3. Because when initialized `inpList` and `outputString` were initialized to be empty, when the command is run they are changed from empty to contain {"Hello"} and "1. Hello\n" respectively. However, because `queryInput` is initialized with content in it, no changes occur because nothing is assigned to it after the first command call. Additionally, because `url` of type URI is an argument, it changes to the arguments passed to the method every time it is called, in this case, it is "http://localhost:7018/add-message?s=Hello".

Call 2:
![Image2](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img2.png)
1. Because the same command (`/add-message`) is run again, the method `handleRequest(URI url)` is called again.
2. When `handleRequest(URI url)` is called, similar to when "Hello" was added, the entire url ("http://localhost:7018/add-message?s=How%20are%20%you") is passed as type URI. In the `Handler` class, the newly updated fields are the array list named `inpList` which contains all the messages {"Hello", "How are you"}, an array of type String named `queryInput` which has the query split at "=" ("s", "How are you"), and a String `outputString` which contains the list in a numbered form to return "1. Hello\n2. How are you". Something that may seem slightly different about this is the %20 in the url instead of spaces. This is because in urls, special characters like the space or dollar sign must be encoded in ASCII and the special character for space is "%20".
3. Because the `/add-message` command has already been called, both `inpList` and `outputString` have contents inside them. When the current command is run, `inpList` changes from {"Hello"} to {"Hello", "How are you"} because a simple `add()` function is used. `outputString` however is reinitialized because it is a local variable so it changes from "" to "1. Hello\n2. How are you" after the loop is executed. Similarly, `queryInput` is also reinitialized again because it is a local variable. In addition, `url` is an argument which changes every time the method is called, which in this case changes to "http://localhost:7018/add-message?s=How%20are%20you".

## Part 2
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img3.png)
1. Absolute path: `C:\Users\Fnu Yash\.ssh\.id_rsa.pub`.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img5.png)
2. Absolute path: `/home/linux/ieng6/cs15lfa23/cs15lfa23kq/.ssh/authorized_keys`.
![Image](https://github.com/fyash1010/cse15l-lab-reports/blob/main/img4.png)

## Part 3
One thing I learned from labs during weeks 2 and 3 is how to ssh into a remote computer. I have always found it interesting how we can connect to powerful computers to run tasks that can not be run onto our own computer. Additionally, the tutorial on how to set up a key so I do not have to enter my password every time I log in was also new and incredibly helpful.
