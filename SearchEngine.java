import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


  class Handler implements URLHandler {
      ArrayList<String> enterWord = new ArrayList<String>();
      String WordSearched = new String();
      String subString = "";
      public String handleRequest(URI url) {
          if (url.getPath().equals("/")) {
              return String.format("No string");
          } else if (url.getPath().equals("/search")) {
              String[] input = url.getQuery().split("=");
                  if (input[0].equals("a")) {
                      subString = input[1];
                  for (int a = 0; a < enterWord.size(); a++){
                          if (enterWord.get(a).contains(subString)){
                              WordSearched += (enterWord.get(a) + " ");
                      }
                  }
                  return String.format(WordSearched);
              }
              return "404 Not Found";
          } else {
              System.out.println("Path: " + url.getPath());
              if (url.getPath().contains("/add")) {
                  String[] input = url.getQuery().split("=");
                  if (input[0].equals("a")) {
                      enterWord.add(input[1]);
                      return String.format("Your string has been added");
                  }
              }
              return "404 Not Found!";
          }
  }
}         