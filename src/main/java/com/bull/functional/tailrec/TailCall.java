package com.bull.functional.tailrec;

import java.util.function.Supplier;

public abstract class TailCall<T> {
    public abstract TailCall<T> resume();
    public abstract T eval();
    public abstract boolean isSuspend();

    public static class Return<T> extends TailCall<T> {
        private final T t;
        public Return(T t) {
            this.t = t;
        }
        @Override
        public T eval() {
            return t;
        }
        @Override
        public boolean isSuspend() {
            return false;
        }
        @Override
        public TailCall<T> resume() {
            throw new IllegalStateException("Return has no resume");
        }
    }
    public static class Suspend<T> extends TailCall<T> {
        private final Supplier<TailCall<T>> resume;
        public Suspend(Supplier<TailCall<T>> resume) {
            this.resume = resume;
        }
        @Override
        public T eval() {
            TailCall<T> tailRec = this;
            while(tailRec.isSuspend()) {
                tailRec = tailRec.resume();
            }
            return tailRec.eval();
        }
        @Override
        public boolean isSuspend() {
            return true;
        }
        @Override
        public TailCall<T> resume() {
            return resume.get();
        }
    }
}