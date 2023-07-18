package io.catroll.algo;

public class LeetCode1114 {
    class Foo {
        private boolean oneDone;
        private boolean twoDone;

        public Foo() {
            oneDone = false;
            twoDone = false;
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            oneDone = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (!oneDone) {
                wait(); // wait until notifyAll() called, no busy waiting
            }
            printSecond.run();
            twoDone = true;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (!twoDone) {
                wait();
            }
            printThird.run();
        }
    }

    class Foo2 {
        private boolean oneDone;
        private boolean twoDone;
        private final Object lock;

        public Foo2() {
            lock = new Object();
            oneDone = false;
            twoDone = false;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // method here doesn't need synchronized keyword
            synchronized (lock) {
                printFirst.run();
                oneDone = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!oneDone) {
                    lock.wait();
                }
                printSecond.run();
                twoDone = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!twoDone) {
                    lock.wait();
                }
                printThird.run();
            }
        }
    }

    class Foo3 {
        private final Object lock1;
        private final Object lock2;
        private boolean oneDone;
        private boolean twoDone;

        public Foo3() {
            lock1 = new Object();
            lock2 = new Object();
            oneDone = false;
            twoDone = false;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock1) {
                printFirst.run();
                oneDone = true;
                lock1.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock1) { // bad practice?
                synchronized (lock2) {
                    while (!oneDone) {
                        lock1.wait();
                    }
                    printSecond.run();
                    twoDone = true;
                    lock2.notifyAll();
                }
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock2) {
                while (!twoDone) {
                    lock2.wait();
                }
                printThird.run();
            }
        }
    }
}
