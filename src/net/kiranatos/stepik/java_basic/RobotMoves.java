package net.kiranatos.stepik.java_basic;

import java.math.*;
import java.util.Arrays;
 
public class RobotMoves {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }
 
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
 
    public static class Robot {
        int x;
        int y;
        Direction dir;
 
        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
 
        public Direction getDirection() {return dir;}
 
        public int getX() {return x;}
 
        public int getY() {return y;}
 
        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }
 
        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }
 
        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }
 
    public static void moveRobot(Robot robot, int toX, int toY) {
        
        if (robot.getX()!=toX)
            if(robot.getX()<toX)
                while (robot.getDirection()!=Direction.RIGHT) { 
                    robot.turnRight();
                    
                }
            else {
                while (robot.getDirection()!=Direction.LEFT) { 
                    robot.turnLeft();
                    
                }
            }
                
        while (robot.getX()!=toX) { 
            robot.stepForward();
            
        }
        
        
        
        
        if (robot.getY()!=toY)
            if(robot.getY()<toY)
                while (robot.getDirection()!=Direction.UP) { 
                    robot.turnRight();
                    
                }
            else {
                while (robot.getDirection()!=Direction.DOWN) { 
                    robot.turnLeft();
                   
                }
            }
                
        while (robot.getY()!=toY) { 
            robot.stepForward();
            
        }
    }
}