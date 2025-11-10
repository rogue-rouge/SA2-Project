package testcontrolsmain.core;

public interface TimerEngine {
    void setDurationSeconds(int seconds);
    void start();
    void stop();
    boolean isRunning();
    void addTimerListener(TimerListener listener);
    void removeTimerListener(TimerListener listener);
}
