# Maze
### Robert Becthold
___
#### Maze generation and derived solutions with output window.
#### Some extra practice with algorithms.
Built in Java using JFrame for output  

### Maze Example (35x35, DFS Algorithm)
```
public void dfs(Integer row, Integer col) {
        Integer[] randomDirections = randomDirections();
        for(int i=0; i<randomDirections.length; i++) {
            switch(randomDirections[i]) {
                //Up
                case 0:
                    if(row-2 <= 0) {
                        continue;
                    }
                    if(maze[row-2][col] !=1) {
                        maze[row-2][col] = 1;
                        maze[row-1][col] = 1;
                        dfs(row-2, col);
                    }
                    break;
                //Down
                case 1:
                    if(row+2 >= maze.length-1) {
                        continue;
                    }
                    if(maze[row+2][col] !=1) {
                        maze[row+2][col] = 1;
                        maze[row+1][col] = 1;
                        dfs(row+2, col);
                    }
                    break;
                //Left
                case 2:
                    if(col-2 <= 0) {
                        continue;
                    }
                    if(maze[row][col-2] != 1) {
                        maze[row][col-2] = 1;
                        maze[row][col-1] = 1;
                        dfs(row, col-2);
                    }
                    break;
                //Right
                case 3:
                    if(col+2 >= maze[0].length) {
                        continue;
                    }
                    if(maze[row][col+2] != 1) {
                        maze[row][col+2] = 1;
                        maze[row][col+1] = 1;
                        dfs(row, col+2);
                    }
                    break;
            }
        }
    }
    
    public Integer[] randomDirections() {
        ArrayList<Integer> directions = new ArrayList<Integer>();
        for(int i=0; i<4; i++) {
            directions.add(i);
        }
        Collections.shuffle(directions);
        return directions.toArray(new Integer[4]);
    }
```
![DFS Generated Maze](images\dfsmaze.png)

### Solution Examples (35x35)
- Depth-First Search Solution  
some dfs code here  
35x35 solved image here

- Breadth-First Search Solution  
some bfs code here  
35x35 sovled image here

- Dijkstra's Solution  
some dijkstra code here  
35x35 solved image here

- A* Solution  
some A* code here  
35x35 solved image here

- Left-Hand Rule Solution  
some LHR code here  
35x35 solved image here  

Maze generation and solutions inspired by
- https://github.com/mikepound/mazesolving
- http://www.migapro.com/depth-first-search/
