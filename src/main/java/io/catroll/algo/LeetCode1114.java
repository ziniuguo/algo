package io.catroll.algo;

public class LeetCode1114 {
    class Foo {
        private boolean first = true;
        private boolean second = true;


        public Foo() {

        }
        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first = false;
        }
        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            while (first) {
                Thread.sleep(10);
            }
            printSecond.run();
            second = false;
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            while (second) {
                Thread.sleep(10);
            }
            printThird.run();
        }
    }

}
