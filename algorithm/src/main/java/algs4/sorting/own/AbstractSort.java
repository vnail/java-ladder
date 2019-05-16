package algs4.sorting.own;

public abstract class AbstractSort<T extends Comparable<T>> {

    public void swap(T[] a,int i,int j){
        T n=a[i];
        a[i] = a[j];
        a[j]=n;
    }

    public boolean less(T a,T b){
        return a.compareTo(b)<0;
    }

    public abstract void sort(T[] nums);
}
