package cozybrew.core;

public interface TimerListener {
    void onTick(int secondsRemaining);
    void onFinish();
}
