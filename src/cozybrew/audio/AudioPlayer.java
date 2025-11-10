package testcontrolsmain.audio;

public interface AudioPlayer {
    void playLoop();
    void pause();
    boolean isPlaying();
    void playOneShot(String soundId);
}
