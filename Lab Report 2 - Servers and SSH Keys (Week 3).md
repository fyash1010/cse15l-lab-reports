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
2. When `handleRequest(URI url)` is called, the entire url ("http://localhost:7018/add-message?s=Hello") is passed as type URI. In the `Handler` class, the updated fields are an array list named `inpList` which contains all the messages added (Hello), an array of type String named `queryInput` which has the query split at "=" ("s", "Hello"), and a String `outputString` which contains the list in a numbered form to return (1. Hello).
3. Because when initialized `inpList` and `outputString` were initialized to be empty, when the command is run they are changed from empty to contain "Hello" and "1. Hello" respectively. However, because `queryInput` is initialized with content in it, no changes occur because nothing is assigned to it after the first command call. Additionally, because `url` of type URI is an argument, it changes to the arguments passed to the method every time it is called, in this case, it is "http://localhost:7018/add-message?s=Hello".
