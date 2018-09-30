package dynamicProgramming;

public class NumberGame {
  
  public int maxValues(int[] input) {
    if (input == null || input.length == 0) {
      return 0;
    }    
    if (input.length == 1) {
      return input[0];
    }
    if (input.length == 2) {
      return input[0] + input[1];
    }
    
    int[][] maxValues = new int[input.length][input.length];
    for (int i = 0; i < input.length - 2; i++) {
      maxValues[i][i] = input[i];
      maxValues[i][i + 1] = input[i] + input[i + 1];
      maxValues[i][i + 2] = input[i] + input[i + 1];
    }
    maxValues[input.length - 1][input.length - 1] = input[input.length - 1];
    maxValues[input.length - 2][input.length - 2] = input[input.length - 2];
    maxValues[input.length - 2][input.length - 1] = input[input.length - 2] + input[input.length - 1];
    
    for (int i = 0; i < input.length - 3; i++) {
      maxValues[i][i + 3] = Math.max(input[i] + Math.min(maxValues[i + 2][i + 3], maxValues[i + 3][i + 3]),
          input[i] + input[i + 1]);
    }
    
    for (int i = 0; i < input.length; i++) {
      for (int j = i + 4; j < input.length; j++) {
        maxValues[i][j] = Math.max(input[i] + Math.min(maxValues[i + 2][j], maxValues[i + 3][j]), 
            input[i] + input[i + 1] + Math.min(maxValues[i + 3][j], maxValues[i + 4][j]));
      }
    }
    
    return maxValues[0][input.length - 1];
  }
  
  public static void main(String[] args) {
    int[] input = {1,2,3,8};
    NumberGame n = new NumberGame();
    System.out.println(n.maxValues(input));
    int[] input2 = {3,5,2,7,9,10,1};
    System.out.println(n.maxValues(input2));
  }
}