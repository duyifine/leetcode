package dataStructure;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CleanRobot implements Robot {
  
  public Deque<String> actionsCompleted = new LinkedList<>();
  public Deque<String> planTodos = new LinkedList<>();
  public int[] curPosition = new int[2];
  public Set<String> visited = new HashSet<>();

  /* (non-Javadoc)
   * @see dataStructure.Robot#move()
   */
  @Override
  public boolean move() {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see dataStructure.Robot#turnLeft()
   */
  @Override
  public void turnLeft(int k) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @see dataStructure.Robot#turnRight()
   */
  @Override
  public void turnRight(int k) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @see dataStructure.Robot#clean()
   */
  @Override
  public void clean() {
    // TODO Auto-generated method stub
    
  }
  
  public boolean moveForward() {
    boolean success = move();
    if (success) {
      curPosition[1]++;
    }
    return success;
  }
  
  public boolean moveBackward() {
    turnLeft(2);
    boolean success = move();
    if (success) {
      curPosition[1]--;
      turnRight(2);
    }
    return success;
  }
  
  public boolean moveLeft() {
    turnLeft(1);
    boolean success = move();
    if (success) {
      curPosition[0]--;
      turnRight(1);
    }
    return success;
  }
  
  public boolean moveRight() {
    turnRight(1);
    boolean success = move();
    if (success) {
      curPosition[0]++;
      turnLeft(1);
    }
    return success;
  }
  
  public boolean returnPreviousStep() {
    String lastAction = actionsCompleted.pollFirst();
    if (lastAction == "left") {
      return moveRight();
    } else if (lastAction == "right") {
      return moveLeft();
    } else if (lastAction == "forward") {
      return moveBackward();
    } else {
      return moveForward();
    }
  }
  
  public boolean actuator(String direction) {
    if (direction == "forward") {
      actionsCompleted.offerFirst(direction);
      return moveForward();
    } else if (direction == "backward") {
      actionsCompleted.offerFirst(direction);
      return moveBackward();
    } else if (direction == "left") {
      actionsCompleted.offerFirst(direction);
      return moveLeft();
    } else {
      actionsCompleted.offerFirst(direction);
      return moveRight();
    }
  }
  
  public boolean cleaner() {
    String postPos = curPosition[0] + "," + curPosition[1];
    visited.add(postPos);
    clean();
    planTodos.offerFirst("forward");
    planTodos.offerFirst("backward");
    planTodos.offerFirst("left");
    planTodos.offerFirst("right");
    while (!planTodos.isEmpty()) {
      String plan = planTodos.pollFirst();
      if (!actuator(plan)) {
        actionsCompleted.pollFirst();
      } else {
        postPos = curPosition[0] + "," + curPosition[1];
        if (!visited.contains(postPos)) {
          clean();
          visited.add(postPos);
          planTodos.offerFirst("forward");
          planTodos.offerFirst("backward");
          planTodos.offerFirst("left");
          planTodos.offerFirst("right");
        } else {
          returnPreviousStep();
        }
      }
    }
    return true;
  }
}