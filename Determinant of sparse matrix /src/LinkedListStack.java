public class LinkedListStack {

    public static void main(String[] args){
        SparseMatrix Mymatrix = new SparseMatrix();


//        Mymatrix.addElement(1,1,3);
        Mymatrix.addElement(1,1,5);
        Mymatrix.addElement(0,1,7);
        Mymatrix.addElement(0,0,-10);

        Mymatrix.addElement(1,1,6);
        Mymatrix.addElement(0,1,5);
        Mymatrix.addElement(1,0,50);

        Mymatrix.addElement(1,1,-40);
        Mymatrix.addElement(2,2,5);
        Mymatrix.addElement(3,3,3);
        Mymatrix.addElement(4,4,3);
        Mymatrix.addElement(0,3,3);
        Mymatrix.removeElement(0,3);
        Mymatrix.addElement(2,2,4);
        Mymatrix.addElement(0,1,4);
        Mymatrix.addElement(2,1,3);
        Mymatrix.addElement(2,2,4);
        Mymatrix.addElement(2,2,4);

        Mymatrix.addElement(3,1,4);
        Mymatrix.addElement(4,2,4);
        Mymatrix.addElement(4,1,6);




        System.out.println(Mymatrix.toString());
//        System.out.println(Mymatrix.getSize());
//        System.out.println(Mymatrix.minor(1,1).toString());
        //System.out.println(Mymatrix.minor(0,0).toString());
        System.out.println(Mymatrix.determinant());
//        SparseInterface myTest = new SparseMatrix();
//
//        myTest.addElement(0, 0, 16);
//
//        myTest.addElement(0, 1, 4);
//
//        myTest.removeElement(0,1);
//
//        String correctString = "0 0 16\n";
//        System.out.println(myTest.toString());
//        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));
//
//        myTest.setSize(3);
//
//        System.out.println("Size is 3: " + (myTest.getSize() == 3));
//
//        correctString = "";
//        System.out.println(myTest.toString());
//        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));
//
//        myTest.addElement(2,2,4);
//
//        myTest.addElement(1,0,-3);
//
//        correctString = "1 0 -3\n2 2 4\n";
//        System.out.println(myTest.toString());
//
//        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));
//
//       System.out.println("The determinant is 0: " + (myTest.determinant() == 0));
//
//        SparseInterface myMinor = myTest.minor(1,1);
//
//        System.out.println("The (1,1) element of the minor is 4: " + (myMinor.getElement(1, 1) == 4));
//
//        myTest.clear();


    }
}
