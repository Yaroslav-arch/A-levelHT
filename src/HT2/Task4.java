package HT2;

public class Task4 {
    static int c;
    public static void main(String[] args) {
      System.out.println(getSmallest(-11,11,-55));
    }

    static int getSmallest(int a,int b,int c){
      int absA = a < 0 ? -a : a;
      int absB = b < 0 ? -b : b;
      int absC = c < 0 ? -c : c;

//      if (absA<=absB && absA<=absC) { //как второй вариант
//          return a;
//      } else if  (absB<=absA && absB<=absC) {
//          return b;
//      } else {
//          return c;
//        }


        return absA < absB ? absC < absA ? c : a : absC < absB ? c : b;

  }

}
