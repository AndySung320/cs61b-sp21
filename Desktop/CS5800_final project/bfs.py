from collections import deque
def bfs_solver(maze, start, end):
    """
    Solves a maze using Breadth-First Search (BFS) to find the shortest path from start to end.

    Parameters:
    - maze (list of lists): 2D grid representing the maze, where 1 is a road and 0 is a wall.
    - start (tuple): Starting coordinates (x, y) in the maze.
    - end (tuple): Ending coordinates (x, y) in the maze.

    Returns:
    - path (dict): A dictionary where each key is a coordinate in the path, and the value is the next coordinate
                   towards the end, forming a path from start to end.
    """

    # Initialize the queue for BFS with the start position
    queue = deque([start])
    # Set to track visited nodes and avoid revisiting
    visited = set()
     # Dictionary to map each node to its previous node, building a path
    bfs_path = {}

    directions = [(0, 1), (-1, 0), (0, -1), (1, 0)] # East, South, West, North
    # BFS loop
    while queue:
        cur_x, cur_y = queue.popleft()
        # Check if we reached the end position
        if (cur_x, cur_y) == end:
            break
        for dx, dy in directions:
            new_x, new_y = cur_x + dx, cur_y + dy

            # Check if new position is valid, unvisited, and a road (1)
            if (0 <= new_x < len(maze) and 0 <= new_y < len(maze[0]) and
                maze[new_x][new_y] == 1 and (new_x, new_y) not in visited):  # 1:road, 0:wall

                # Add the new position to the queue and mark it as visited
                queue.append((new_x, new_y))
                visited.add((new_x, new_y))
                # Record the path from the current node to the new node
                bfs_path[(new_x, new_y)] = (cur_x, cur_y)
                
    # Reconstruct the path from end to start
    path = {}
    pos = end
    while pos != start:
        path[bfs_path[pos]] = pos
        pos = bfs_path[pos]
    return path

if __name__ == "__main__":
    # Example usage:
    maze = [
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 1, 1, 0, 1],
        [1, 0, 0, 0, 1],
        [1, 1, 1, 1, 1]
    ]
    start = (0, 0)
    end = (4, 4)

    path = bfs_solver(maze, start, end)
    s = (0,0)
    while s != end:
        print(path[s])
        s = path[s]
    print("Path to solve the maze:", path)