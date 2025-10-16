import java.util.*;

public class BracketMatcher {

   private static class Bracket{
      char type;
      int position;
      Bracket(char type, int position){
         this.type = type;
         this.position = position;
      }
   }
      private static boolean isMatching(char open, char close) {
      if (open == '(' && close == ')') return true;
      if (open == '[' && close == ']') return true;
      if (open == '{' && close == '}') return true;
      return false;
   }

   public static void main(String[] args) {
      /*helper code from instructions*/
      In in = new In("test04.txt");
      String text = in.readLine();

      Stack<Bracket> openingBrackets = new Stack<>();

      for (int position = 1; position <= text.length(); ++position) {
         char next = text.charAt(position - 1);

         /* YOUR CODE HERE */
         //push opening brackets
         if (next == '(' || next == '[' || next == '{'){
            openingBrackets.push(new Bracket(next, position));
         }

         //check if closing brackets match
         else if (next == ')' || next == ']' || next == '}'){

            //if there's nothing to match
            if (openingBrackets.isEmpty()){
               System.out.println(position);
               return;
            }

            Bracket top = openingBrackets.pop();
            if(!isMatching(top.type, next)){
               System.out.println(position);
               return;
            }
         }

      }

      // Print "Success" if brackets are balanced
      /*YOUR CODE HERE */
      if (openingBrackets.isEmpty()) {
         System.out.println("Success");
      } else {
         Bracket firstUnmatched = openingBrackets.firstElement(); 
         System.out.println(firstUnmatched.position);
      }
   }
}


