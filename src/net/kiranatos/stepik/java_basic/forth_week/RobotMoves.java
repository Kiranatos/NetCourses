package net.kiranatos.stepik.java_basic.forth_week;

import java.math.*;
import java.util.Arrays;
 
public class RobotMoves {
    
    public static void main(String[] args) {        
        moveRobot(new RConnectManager(), -10, 20);
    }
 
    public enum Direction { UP, DOWN, LEFT, RIGHT }
    
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
            void close();
    }
    
    public interface RobotConnectionManager { RobotConnection getConnection(); }
    
    
 
    public static class Robot {
        int x, y;
        Direction dir;
 
        public Robot (int x, int y, Direction dir) { this.x = x; this.y = y; this.dir = dir; }
 
        public Direction getDirection() { return dir; } 
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
            if(robot.getX()<toX) while (robot.getDirection()!=Direction.RIGHT) { robot.turnRight(); }
            else { while (robot.getDirection()!=Direction.LEFT) { robot.turnLeft(); } }
                
        while (robot.getX()!=toX) { robot.stepForward(); }
        
        if (robot.getY()!=toY)
            if(robot.getY()<toY) while (robot.getDirection()!=Direction.UP) { robot.turnRight(); }
            else { while (robot.getDirection()!=Direction.DOWN) { robot.turnLeft(); } }
                
        while (robot.getY()!=toY) { robot.stepForward(); }
        //throw new RobotConnectionException("");
    }
    
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        
        boolean flag = true;
        boolean no_erorr = true;
        int a = 1;
        
        while (flag) {
            try(RobotConnection rc = robotConnectionManager.getConnection()){
                System.out.println("1");
                rc.moveRobotTo(toX, toY);
                
                flag = false;
            }catch(RobotConnectionException e){
                System.out.println("2");
                a++;
                no_erorr = false;
                if (a==4) throw e;                
            } catch (Exception e) { throw e; }
            
            if (no_erorr) flag = false;
        }
       
    }
    
    
    static class RConnectManager implements RobotConnectionManager {
        private RobotConnection rc;
        @Override
        public RobotConnection getConnection() {            
            if (rc == null) { rc = new RConnect();}
            return rc;
        }
    }
    static class RConnect implements RobotConnection {
        Robot robot = new Robot(0,0, Direction.DOWN);

        @Override
        public void moveRobotTo(int x, int y) {   
            moveRobot(robot, x, y);
        }

        @Override
        public void close() { 
            System.out.println("Robot Destroyed!");
        }
    }
        
        
}

class RobotConnectionException extends RuntimeException {
        public RobotConnectionException(String message) { super(message); }
        public RobotConnectionException(String message, Throwable cause) { super(message, cause); }
    }