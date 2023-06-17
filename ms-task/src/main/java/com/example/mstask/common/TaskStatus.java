package com.example.mstask.common;

public enum TaskStatus {
    TO_DO {
        @Override
        public TaskStatus getNextStatus() {
            return IN_PROGRESS;
        }
    }, IN_PROGRESS {
        @Override
        public TaskStatus getNextStatus() {
            return IN_REVIEW;
        }
    }, IN_REVIEW {
        @Override
        public TaskStatus getNextStatus() {
            return DONE;
        }
    }, DONE {
        @Override
        public TaskStatus getNextStatus() {
            return DONE;
        }
    };

    public abstract TaskStatus getNextStatus();
}
