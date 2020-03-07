package TopCoder;

public class A0Paper {
    public static String canBuild(int[] A){
        int n = A.length;
        if(A[0]!=0)
            return "Possible";
        else{
            int sum=0;
            for(int i=1;i<n;i++){
                sum+=(1/Math.pow(2,i-1))*A[i];
            }
            if(sum/2>=1)
                return "Possible";
            else
                return "Impossible";
        }
    }
    public static void main(String args[]){
        int A[] = {0,3};
        System.out.println(canBuild(A));
        int B[] = {0,1,2};
        System.out.println(canBuild(B));
        int C[] = {0,0,0,0,15};
        System.out.println(canBuild(C));
        int D[] = {2,0,0,0,0,0,0,3,2,0,0,5,0,3,0,0,1,0,0,0,5};
        System.out.println(canBuild(D));
    }
}
