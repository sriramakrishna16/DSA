package Trees;
//problem , given n * n matrix , so we have to build a quad tree
// matrix contains 0 and 1's represents boolean value
//building quadtree involves if all value are 1's or either 0's then we mark it as leaf and return
// if not we mark it as not leaf and do divide and conquer the same process
// ex -> in 4*4 matrix , if all values same simply we return true and isLeaf true
// else if not same we split the matrix into 4 parts each 2 * 2 matrices and again check is same or not

// same process continues until the matrix become 1 * 1 if values not same and each singles value
// marked as leaf true.

public class ConstructQuadTree {
    class Node{
        boolean val;
        boolean isLeaf;
        Node topLeft;
        Node topRight;
        Node bottomLeft;
        Node bottomRight;

        Node(){};

        Node(boolean val , boolean isLeaf){
            this.val = val;
            this.isLeaf = isLeaf;
        }
        Node(boolean val, boolean isLeaf,Node topLeft, Node topRight,Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    public static void main(String args[]){
        int [][] grid = {{0,1},{1,0}};
        ConstructQuadTree c = new ConstructQuadTree();
        Node root = c.construct(grid);
        c.preorder(root);
    }
    public Node construct(int[][] grid){
        return build(grid, 0 , 0, grid.length);
    }
    public Node build(int [][] grid, int row , int col, int size){
        int value = grid[row][col];
        boolean same = true;

        for(int i = row ; i < row + size ; i++){
            for(int j = col ; j < col + size; j++){
                if(grid[i][j] != value){
                    same = false;
                    break;
                }
            }
            if(!same){
                break;
            }
        }

        if(same){
            return new Node(value == 1, true);
        }

        int half = size / 2;

        Node topLeft = build(grid, row,col,half);
        Node topRight = build(grid, row,col+half,half);
        Node bottomLeft = build(grid, row + half , col , half);
        Node bottomRight = build(grid, row + half , col + half , half);

        return new Node(true, false, topLeft, topRight, bottomLeft , bottomRight);
    }
    public void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println("value : " + (root.val ? 1 : 0) + " isLeaf : " + root.isLeaf);
        preorder(root.topLeft);
        preorder(root.topRight);
        preorder(root.bottomLeft);
        preorder(root.bottomRight);
    }
}
