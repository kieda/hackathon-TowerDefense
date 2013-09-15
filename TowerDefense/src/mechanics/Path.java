/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    SpaceGrid grid;
    List<Point> solution;
    int board[][];
    public Path(SpaceGrid inputGrid){
        // Variable Declarations
        grid = inputGrid;
        int width = grid.getWidth();
        int height = grid.getHeight();
        board = new int[width][height];
        for (int x=0; x<width; x++){ // populate all board squares wih max in val
            for (int y=0; y<height; y++){
                board[x][y] = Integer.MAX_VALUE;
            }
        }
        Set<Point> frontier = new HashSet<>();
        solution = new ArrayList<>();
        
        // Add first square if is unoccupied
        if (!grid.isOccupied(0, 0)){
            frontier.add(new Point(0,0));
            board[0][0] = 1;
        }
        
        // Explore the fronteir
        for (Point explorer : frontier){
            for (Point neighbor : neighbors(explorer)){
                if (boardValue(neighbor) > boardValue(explorer) + 1){
                    frontier.remove(explorer);
                    board[neighbor.x][neighbor.y] = boardValue(explorer) + 1;
                    frontier.add(neighbor);
                }
            }
        }
        
        // If found a path to the end
        solution = backtrackPath(new Point(width-1, height-1));
    }
    
    private List<Point> backtrackPath(Point end){
        List<Point> result = new ArrayList<Point>();
        if (boardValue(end) == Integer.MAX_VALUE){
            return result;
        }
        
        if (boardValue(end) == 1){
            result.add(new Point(0,0));
            return result;
        }
        
        for (Point neighbor : neighbors(end)){
            if (boardValue(neighbor) == boardValue(end)-1){
                result = backtrackPath(neighbor);
                result.add(end);
                return result;
            }
        }
        
        throw new RuntimeException("Should not reach here"); // should not reach here
    }
    
    private int boardValue(Point p){
        return board[p.x][p.y];
    }
    
    // Return unoccupied N E S W squares which are on board
    private List<Point> neighbors(Point p){
        List<Point> result = new ArrayList<>();
        if (squareOpen(new Point(p.x-1, p.y))) // West
            result.add(new Point(p.x-1, p.y));
        if (squareOpen(new Point(p.x+1, p.y))) // East
            result.add(new Point(p.x+1, p.y));
        if (squareOpen(new Point(p.x, p.y-1))) // North
            result.add(new Point(p.x, p.y-1));
        if (squareOpen(new Point(p.x, p.y+1))) // South
            result.add(new Point(p.x, p.y+1));
        return result;
    }
    
    // Return if point is on board and unoccupied
    private boolean squareOpen(Point p){
        // if off the board, then not open
        if (p.x < 0 || p.x >= grid.getWidth())
            return false;
        if (p.y <0 || p.y >= grid.getHeight())
            return false;
        // otherwise return true if unoccupied square
        return !grid.isOccupied(p.x, p.y);
    }
}
