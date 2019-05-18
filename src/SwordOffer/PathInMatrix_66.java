package SwordOffer;

public class PathInMatrix_66 {
    public static void main(String[] args) {
        char[][] mat = {{'a','b','c','e'},{ 's','f','c','s'},{'a','d','e','e'}};
        String path_1 = "bcced";
        String path_2 = "abcb";

        System.out.println(hasPath(mat,path_1));
        System.out.println(hasPath(mat,path_2));

    }

    public static boolean hasPath(char[][] mat, String path){
        if(mat==null||path==null){
            return false;
        }
        int rows = mat.length;
        int columns = mat[0].length;

        if(path.length()>rows*columns){
            return false;
        }

        boolean[][] visited = new boolean[rows][columns];

        // 从某一点出发，只能一行一列来遍历了。
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(helpFind(mat, i, j, visited, path, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean helpFind(char[][] mat, int row, int column, boolean[][] visited, String s, int now){
        if(now == s.length()){ //找到符合的路径
            return true;
        }

        boolean hasPath = false;
        if(0<=row&&row<mat.length&&0<=column&&column<mat[0].length  //先判断是否是有效坐标点
                &&!visited[row][column]   //没有访问过
                &&mat[row][column]==s.charAt(now)){
            now++;
            visited[row][column]= true;

            hasPath = helpFind(mat,row+1,column,visited,s,now)||
                    helpFind(mat,row-1,column,visited,s,now)||
                    helpFind(mat,row,column+1,visited,s,now)||
                    helpFind(mat,row,column-1,visited,s,now);
            if(!hasPath ){ //回退
                now--;
                visited[row][column] = false;
            }
        }
        return hasPath;
    }

}

