package testcontrolsmain.core;

public interface TimerListener {
    void onTick(int secondsRemaining);
    void onFinish();
}
