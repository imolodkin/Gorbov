package gorbov;


import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class TimerLabel extends JLabel {

    private DecimalFormat decimalFormat = new DecimalFormat("00");
    private Timer timer = new Timer();
    private TimerTask timerTask;

    public TimerLabel() {
        restartTimer();
    }

    public void restartTimer() {
        stopTimer();
        timerTask = new TimerTask() {
            private volatile int time = -1;

            @Override
            public void run() {
                time++;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int t = time;
                        TimerLabel.this.setText(decimalFormat.format(t / 60) + ":" + decimalFormat.format(t % 60));
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    public void stopTimer() {
        if (timerTask != null) {
            timerTask.cancel();
        }
    }
}
