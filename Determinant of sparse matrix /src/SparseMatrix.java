 import java.util.*;
 import java.lang.Math;

public class SparseMatrix implements SparseInterface {


        private int cur_rows = 5;
        private int cur_columns = 5;
        private MatrixNode head = null;


        public class MatrixNode {
            int data;
            int row;
            int col;
            public MatrixNode next = null;
            // linked list  constructor
            MatrixNode(int data, int row, int col){
                this.data = data;
                this.row = row;
                this.col = col;
            }
        }



        // Adds all elements in order based on their coordiantes from top left to bottom right.
        public void addElement(int row, int col, int data){
            MatrixNode node = new MatrixNode(data, row, col);
            MatrixNode current = head;
            MatrixNode prev = head;
            // The two if statements below throw out of bounds exceptions if the row or column are out of bounds
            if (row >= cur_rows || col >= cur_columns){
               throw new IndexOutOfBoundsException("Index " + row + ", "
                       + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            if (node.data == 0 ){
                return;
            }
            // If the list is empty just point the head of the list to the new node.
            if (head == null ){
                this.head = node;
                node.next = null;
                return;
            }
            // Traverses the entire linked list to add new nodes in order.
            while (current.next != null ) {
                // The if statements below take care of all the possible locations for insertion of a new node
                // to ensure that the new node is inserted in order.

                // The below if statement takes care of the case where row and column are the same as an existing row and column.
                if(current.row == row && current.col == col || current.next.row == row && current.next.col == col) {
                    if (current.next.row == row && current.next.col == col) {
                        current.next.data = data;
                        return;
                    }

                    else if(current.row == row && current.col == col){
                        current.data = data;
                        return;
                    }
                }
                // If the current is head and the node row is lessthan or equal to the current row
                // and the node column is  lesthan or equal to the current column
                else if(current == head && node.row <= current.row && node.col <= current.col){
                    MatrixNode temp = head;
                    head = node;
                    node.next = temp;
                    return;
                }
                // If the current is head and the node row is less than or equal to the current row
                // and the node column is greater than or equal to the current column
                else if(current == head && node.row <= current.row && node.col > current.col){
                    if(node.row < current.row){
                        MatrixNode temp = head;
                        head = node;
                        node.next = temp;
                        return;
                    }
                    else if(node.row == current.next.row && node.col > current.next.col){
                        MatrixNode temp = current.next.next;
                        current.next.next = node;
                        node.next = temp;
                        return;
                    }
                    MatrixNode temp = current.next;
                    current.next = node;
                    node.next = temp;
                    return;
                }
                // if the node row is less than or equal to the current row and the node column is greater
                // than the current column
                else if(node.row <= current.row && node.col < current.col ){
                    prev.next = node;
                    node.next = current;
                    return;
                }
                else if(node.row <= current.row && node.col > current.col ){
                    MatrixNode temp = current.next;
                    current.next = node;
                    node.next = temp;
                    return;
                }
                prev = current;
                current = current.next;
            }
            // Due to the while loop only testing until current.next if statements must be called one more time
            // to test the remaining cases below. I know its long but i was running into too many null pointer exceptions
            // trying to execute placing the elements in order but doing a while loop that went while (current != null)
            if(current == head && node.row <= current.row && node.col <= current.col){
                MatrixNode temp = head;
                head = node;
                node.next = temp;
                return;
            }
            else if(current == head && node.row <= current.row && node.col > current.col){
                if(node.row < current.row){
                    MatrixNode temp = head;
                    head = node;
                    node.next = temp;
                    return;
                }
                else {
                    MatrixNode temp = current.next;
                    current.next = node;
                    node.next = temp;
                    return;
                }
            }
            else if(current.row == row && current.col == col){
                return;
            }
            else if(node.row <= current.row && node.col < current.col ){
                prev.next = node;
                node.next = current;
                return;
            }
            else if(node.row <= current.row && node.col > current.col ){
                MatrixNode temp = current.next;
                current.next = node;
                node.next = temp;
                return;
            }
            else if (current.next == null) {
                current.next = node;
                return;
            }
        }

        //converts the matrix to a sting in the specified format.
        public String toString() {
            MatrixNode current = head;
            ArrayList <String> list = new ArrayList <String> ();
            // returns an empty string if there is no input.
            if (head == null ){
                return "";
            }
            // traverses the linked list and converts all the data to a string arrayList
            while (current != null) {
                list.add(String.valueOf(current.row));
                list.add(String.valueOf(current.col));
                list.add(String.valueOf(current.data));
                current = current.next;
                }
            // Converts the array list to a string in the desired format.
            int count = 1;
            StringBuilder newString = new StringBuilder();
            for (String s : list){
                // every 3rd item inserts a new line.
                if (count % 3 == 0){
                    newString.append(s);
                    newString.append("\n");
                    count++;
                    continue;
                }
                newString.append(s);
                newString.append(" ");
                count ++;

            }
            return newString.toString();
        }

        // clears the list by setting the head to null all the data is lost.
        public void clear() {
            this.head = null;
        }

        //changes the size of the matrix from the default size
        //sets all elements to zero
        public void setSize(int size) {
            this.cur_columns = size;
            this.cur_rows = size;
            this.head = null;
        }

        public void removeElement(int row, int col) {
            // The two if statements below throw out of bounds exceptions if the row or column are out of bounds
            if (row >= cur_rows || col >= cur_columns){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            // traverses the list and finds the node we want to remove based on location.
            MatrixNode current = head;
            while(current.next != null){
                if (current == head && current.col == col && current.row == row){
                    head = current.next;
                    break;
                }
                else if((current.next.col == col) && (current.next.row == row)){
                    current.next = current.next.next;
                    break;
                }
                current= current.next;
            }

        }

        public int getElement(int row, int col) {
            MatrixNode current = head;
            // The two if statements below throw out of bounds exceptions if the row or column are out of bounds
            if (row >= cur_rows || col >= cur_columns){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            // Traverses the list to return the element we are looking for, if the element is not in the list we return zero.
            while (current != null) {
                if ((current.col == col) && (current.row == row)) {
                    return current.data;
                }
                current = current.next;
            }

            // If the element is not found in the linked list.
            return 0;
        }

        public int determinant() {
            // preforms a recursive call on the minor until it is at the base case of size 2X2 then it computes that matrix and returns the value.
            int sum = 0;
            // This is the base case for the recursive call
            if (getSize() == 1){
                sum += getElement(0,0);
            }
            else if (getSize() == 2){
                sum += getElement(0,0)*getElement(1,1) -
                        getElement(0,1)*getElement(1,0);
                return sum;
            }
            // This else statement contains the recursive step.
            else {
                for (int i = 0; i < cur_rows; i++) {
                    sum += (int) (Math.pow(-1, i) * getElement(i, 0) * minor(i, 0).determinant());
                }
            }
            return sum;
        }


        public SparseInterface minor(int row, int col) {
            //Creates a new matrix minor that is the minor of the original matrix being passed.
            SparseMatrix minor = new SparseMatrix();
            minor.setSize(getSize()-1);
            MatrixNode current = head;
            // the while loop excludes cases that are in the specified row and column to produce the desired minor of the matrix
            while (current != null){

                if ((current.col != col) &&  (current.row != row)){
                    //takes care of the case if the element is at 0'0
                    if (current.col == 0  && current.row == 0 ){
                        minor.addElement(current.row, current.col, current.data);
                        current = current.next;
                        continue;
                    }
                    //takes care of the case if the element is at !0'0
                    else if (current.col == 0  && current.row != 0 ){
                        minor.addElement(current.row-1, current.col, current.data);
                        current = current.next;
                        continue;
                    }
                    //takes care of the case if the element is at 0'!0
                    else if (current.col != 0  && current.row == 0 ){
                        minor.addElement(current.row, current.col-1, current.data);
                        current = current.next;
                        continue;
                    }
                    //takes care of the case if the element is at !0'!0
                    else if (current.col != 0  && current.row != 0 ) {
                        minor.addElement(current.row - 1, current.col - 1, current.data);
                        current = current.next;
                        continue;
                    }
                }
                current = current.next;
            }
            return minor;
        }

        // returns the size of the current matrix.
        public int getSize() {
            return cur_columns;
        }
    }

