package learn.clone;

import java.util.Arrays;

public class ShallowCopy {

    private int[] data;

    public ShallowCopy(int[] values) {
        data = values;
    }

    public void showData() {
        System.out.println( Arrays.toString(data) );
    }
}


 class ShallowCopyMain{
    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        ShallowCopy copy = new ShallowCopy(vals);
        copy.showData();
        vals[0] = 13;
        copy.showData();
    }

}


