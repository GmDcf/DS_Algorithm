package LeetCode.DP;

public class Boomerang {
    public boolean isBoomerang(int[][] points) {
    int[] x = points[0],  y=points[1],  z=points[2];

    if(!compare(x,y)&&!compare(x,z)&&!compare(z,y)){
        return !((x[0]-y[0])*(y[1]-z[1])==(y[0]-z[0])*(x[1]-y[1]));
    }
    return false;
}
    public boolean compare(int[] x, int[] y ){
        return x[0]==y[1]&&x[1]==y[1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0},{1,0},{1,2}};
        System.out.println(new Boomerang().isBoomerang(arr));
    }
}
