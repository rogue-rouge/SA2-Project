package cozybrew.logic;

public interface TimerListener {
    void onTick(int secondsRemaining);
    void onFinish();
}
