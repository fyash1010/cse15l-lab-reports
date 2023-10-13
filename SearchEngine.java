import java.util.*;
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    ArrayList<String> inpList = new ArrayList<String>();

    public String handleRequest(URI url) {
        if(url.getPath().equals("/")) {
            return String.format(String.join(", ", inpList));
        } else {
            if(url.getPath().contains("/add")) {
                String[] queryInput = url.getQuery().split("=");
                
                if(queryInput[0].equals("s")) {
                    inpList.add(queryInput[1]);

                    return String.format("%s added to the list! It's now " + inpList, queryInput[1]);
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

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("Missing port number!");
            return;
        }

        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
