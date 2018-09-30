package dynamicProgramming;

public class JumpGame {
  
  public boolean canJumpI(int[] array) {
    if (array == null || array.length == 0) {
      return true;
    }
    
    boolean[] canJump = new boolean[array.length];
    if (array[array.length - 1] >= 1) {
      canJump[array.length - 1] = true;
    }
    for (int i = array.length - 2; i >= 0; i--) {
      for (int j = 1; j <= array[i]; j++) {
        if (canJump[i + j]) {
          canJump[i] = true;
          break;
        }
      }
    }
    
    return canJump[0];
  }
  
  public boolean canJumpII(int[] array) {
    if (array == null || array.length == 0) {
      return true;
    }
    
    boolean[] canJump = new boolean[array.length];
    canJump[0] = true;
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        if (canJump[j] && array[j] >= i - j) {
          canJump[i] = true;
          break;
        }
      }
    }
    
    return canJump[array.length - 1];
  }
  
  public int minJumps(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    
    int[] minJumps = new int[array.length + 1];
    minJumps[0] = 0;
    for (int i = 1; i <= array.length; i++) {
      minJumps[i] = array.length;
      for (int j = 0; j < i; j++) {
        if (array[j] + j >= i) {
          minJumps[i] = Math.min(minJumps[i], 1 + minJumps[j]);
        }
      }
    }
    return minJumps[array.length];
  }
  
  public static void main(String[] args) {
    int[] array = {2,3,1,1,4};
    int[] array2 = {3,2,1,0,4};
    JumpGame j = new JumpGame();
    System.out.println(j.canJumpI(array));
    System.out.println(j.canJumpI(array2));
    System.out.println(j.canJumpII(array));
    System.out.println(j.minJumps(array));
    System.out.println(j.canJumpII(array2));
    System.out.println(j.minJumps(array2));
  }
}