package com.example.projectmanagement.task;

public enum TaskStatus {
    TO_DO {
        @Override
        TaskStatus getNextStatus() {
            return IN_PROGRESS;
        }
    }, IN_PROGRESS {
        @Override
        TaskStatus getNextStatus() {
            return IN_REVIEW;
        }
    }, IN_REVIEW {
        @Override
        TaskStatus getNextStatus() {
            return DONE;
        }
    }, DONE {
        @Override
        TaskStatus getNextStatus() {
            return DONE;
        }
    };

    abstract TaskStatus getNextStatus();
}
