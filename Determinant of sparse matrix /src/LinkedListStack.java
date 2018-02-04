public class LinkedListStack {

    public static void main(String[] args){
        SparseMatrix Mymatrix = new SparseMatrix();
        Mymatrix.addElement(3,3,6);
        Mymatrix.addElement(2,5,5);
        Mymatrix.addElement(2,2,3);
        Mymatrix.addElement(3,3,7);
        Mymatrix.addElement(2,4,7);
        Mymatrix.removeElement(2,4);



        System.out.println(Mymatrix.toString());
        System.out.println(Mymatrix.getElement(2,4));



    }
}
