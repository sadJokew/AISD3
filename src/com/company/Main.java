package com.company;

/*
________________________________________________________________________________________________________________________

                                                      v20
 _______________________________________________________________________________________________________________________
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        for (int i = 0; i < 1; i++)
            new Main().run();
    }

    //cards mixer
    private void run() {
        int size = 10;
        Queue queue1 = new Queue(size);
        Queue queue2 = new Queue(size);

        //FILL
        for (int i = 0; i < size; i++) {
            queue1.insert((int) (Math.random() * 100));
            queue2.insert((int) (Math.random() * 100));
        }
        Queue temp1 = new Queue(queue1);
        Queue temp2 = new Queue(queue2);

        //COUT
        System.out.println("\t Queue 1 Before Shaking");
        print(temp1);

        System.out.println("\t Queue 2 Before Shaking");
        print(temp2);

        temp1 = new Queue(queue1);
        temp2 = new Queue(queue2);
        Queue result = shake(temp1, temp2);

        System.out.println("\t Queue 1 After shaking");
        print(temp1);
        System.out.println("\t Queue 2 After shakin");
        print(temp2);
        System.out.println("\t Result After shaking");
        print(result);
    }

    private void print(Queue que){
        while (!que.isEmpty()) {
            Object o = que.remove();
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }

    private Queue shake(Queue temp1, Queue temp2){
        Queue result = new Queue(temp1.getMaxSize()*2);
        for (int k = 0; k < (Math.random()*10000); k++) {
            //SHAKE 2->1
            while (!temp1.isEmpty() && !temp2.isEmpty()) {
                if (Math.random() * 100 > 50.0) {
                    result.insert(temp2.remove());
                } else
                    result.insert(temp1.remove());
            }
            while (!temp1.isEmpty()) {
                result.insert(temp1.remove());
            }
            while (!temp2.isEmpty()) {
                result.insert(temp2.remove());
            }

            //SHAKE 1->2
            for (int i = 0; i < result.getMaxSize(); i++) {
                if (i % 2 == 0) {
                    temp1.insert(result.remove());
                } else {
                    temp2.insert(result.remove());
                }
            }
        }
        //CONTAIN 2->1
        for (int i = 0; i < result.getMaxSize(); i++) {
            if (i % 2 == 0) {
                result.insert(temp1.remove());
            } else {
                result.insert(temp2.remove());
            }
        }
        return result;
    }
}
