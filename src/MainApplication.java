import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication extends JFrame {

    private enum CounterMode {
        INCREASING, DECREASING
    }

    private Timer exTimer;                              // timer for exercise time measurement
    private Timer globalTimer;                          // timer for global time (clock) measurement

    private int exTimerTimeSec = 0;                            // exercise time in seconds
    private int globalTimerTimeSec = 0;                        // global time in seconds

    private final int TIMER_TICK_LENGTH_MSEC = 10;           // timer period (1 second length)

    private int exerciseTimeSecPreset = 60;
    private int numSeriesPreset = 0;

    private CounterMode seriesCounterMode = CounterMode.INCREASING;

    /**
     * MainApplication constructor - application entry point
     */
    private MainApplication() {
        initComponents();
        this.setLocationRelativeTo(null);
        exTimer = new Timer(TIMER_TICK_LENGTH_MSEC, exTimerTickTock);        // timer for exercise time measurement
        globalTimer = new Timer(TIMER_TICK_LENGTH_MSEC, globalTimerTickTock);        // timer for global time measurement
        exTimerTimeSec = exerciseTimeSecPreset;
        globalTimerTimeSec = 0;
        resetGlobalClock();
        jButtonResetGlobalTime.addActionListener(e -> jButtonResetClockClicked(e));
        jButtonPauseGlobalTime.addActionListener(e -> jButtonPauseResumeClockClicked(e));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Milan Herbig
    private void initComponents() {
        jMenuBar1 = new JMenuBar();
        jMenuFile = new JMenu();
        jMenuItemPreferences = new JMenuItem();
        jMenuItemQuit = new JMenuItem();
        jMenuHelp = new JMenu();
        jMenuItemAbout = new JMenuItem();
        jPanelTimer = new JPanel();
        jButtonStartStop = new JButton();
        jTextFieldMinutes = new JTextField();
        jLabelColon = new JLabel();
        jTextFieldSeconds = new JTextField();
        jPanelPreset = new JPanel();
        jLabelPresetTitle = new JLabel();
        jRadioButton1min = new JRadioButton();
        jRadioButton2min = new JRadioButton();
        jRadioButton3min = new JRadioButton();
        jRadioButton5min = new JRadioButton();
        jRadioButton10min = new JRadioButton();
        jRadioButtonXmin = new JRadioButton();
        jTextFieldXmin = new JTextField();
        jLabelXmin = new JLabel();
        jButtonResetTimer = new JButton();
        jPanelSeries = new JPanel();
        jTextFieldSeries = new JTextField();
        jLabelSeries = new JLabel();
        jButtonSetSeries = new JButton();
        jButtonResetSeries = new JButton();
        jLabelSeriesCounterMode = new JLabel();
        jPanelGlobalTime = new JPanel();
        jLabelHours = new JLabel();
        jTextFieldGlobalTime = new JTextField();
        jLabelGlobalTime = new JLabel();
        jLabelGlobalTimeState = new JLabel();
        jButtonResetGlobalTime = new JButton();
        jButtonPauseGlobalTime = new JButton();
        jFramePreferences = new JFrame();
        jLabelPreferencesDesc = new JLabel();
        jRadioButtonAsc = new JRadioButton();
        jRadioButtonDesc = new JRadioButton();
        jLabelPreferencesHeading = new JLabel();
        jButtonSavePreferences = new JButton();
        jButtonStornoPreferences = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exercise Timer");
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        //======== jMenuBar1 ========
        {

            //======== jMenuFile ========
            {
                jMenuFile.setMnemonic('S');
                jMenuFile.setText("File");
                jMenuFile.setToolTipText("");

                //---- jMenuItemPreferences ----
                jMenuItemPreferences.setMnemonic('N');
                jMenuItemPreferences.setText("Preferences");
                jMenuItemPreferences.addActionListener(e -> jMenuItemPreferencesActionPerformed(e));
                jMenuFile.add(jMenuItemPreferences);
                jMenuFile.addSeparator();

                //---- jMenuItemQuit ----
                jMenuItemQuit.setMnemonic('U');
                jMenuItemQuit.setText("Quit");
                jMenuItemQuit.addActionListener(e -> jMenuItemQuitActionPerformed(e));
                jMenuFile.add(jMenuItemQuit);
            }
            jMenuBar1.add(jMenuFile);

            //======== jMenuHelp ========
            {
                jMenuHelp.setMnemonic('N');
                jMenuHelp.setText("Help");

                //---- jMenuItemAbout ----
                jMenuItemAbout.setMnemonic('O');
                jMenuItemAbout.setText("About");
                jMenuHelp.add(jMenuItemAbout);
            }
            jMenuBar1.add(jMenuHelp);
        }
        setJMenuBar(jMenuBar1);

        //======== jPanelTimer ========
        {
            jPanelTimer.setBorder(new TitledBorder("Timer"));
            jPanelTimer.setNextFocusableComponent(jButtonStartStop);

            //---- jButtonStartStop ----
            jButtonStartStop.setFont(new Font("Tahoma", Font.PLAIN, 16));
            jButtonStartStop.setText("START");
            jButtonStartStop.setToolTipText("Zapne nebo zastav\u00ed odpo\u010d\u00edt\u00e1v\u00e1n\u00ed \u010dasom\u00edry");
            jButtonStartStop.setNextFocusableComponent(jRadioButton1min);
            jButtonStartStop.addActionListener(e -> jButtonStartStopClicked(e));

            //---- jTextFieldMinutes ----
            jTextFieldMinutes.setEditable(false);
            jTextFieldMinutes.setFont(new Font("Tahoma", Font.PLAIN, 72));
            jTextFieldMinutes.setHorizontalAlignment(SwingConstants.CENTER);
            jTextFieldMinutes.setText("01");
            jTextFieldMinutes.setToolTipText("Minuty");

            //---- jLabelColon ----
            jLabelColon.setFont(new Font("Tahoma", Font.PLAIN, 72));
            jLabelColon.setText(":");

            //---- jTextFieldSeconds ----
            jTextFieldSeconds.setEditable(false);
            jTextFieldSeconds.setFont(new Font("Tahoma", Font.PLAIN, 72));
            jTextFieldSeconds.setHorizontalAlignment(SwingConstants.CENTER);
            jTextFieldSeconds.setText("00");
            jTextFieldSeconds.setToolTipText("Vte\u0159iny");

            //======== jPanelPreset ========
            {

                //---- jLabelPresetTitle ----
                jLabelPresetTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
                jLabelPresetTitle.setText("Time preset:");

                //---- jRadioButton1min ----
                jRadioButton1min.setSelected(true);
                jRadioButton1min.setText("1 minute");
                jRadioButton1min.setActionCommand("1  minuta");
                jRadioButton1min.addActionListener(e -> jRadioButton1minActionPerformed(e));

                //---- jRadioButton2min ----
                jRadioButton2min.setText("2 minutes");
                jRadioButton2min.addActionListener(e -> jRadioButton2minActionPerformed(e));

                //---- jRadioButton3min ----
                jRadioButton3min.setText("3 minutes");
                jRadioButton3min.addActionListener(e -> jRadioButton3minActionPerformed(e));

                //---- jRadioButton5min ----
                jRadioButton5min.setText("5 minutes");
                jRadioButton5min.addActionListener(e -> jRadioButton5minActionPerformed(e));

                //---- jRadioButton10min ----
                jRadioButton10min.setText("10 minutes");
                jRadioButton10min.addActionListener(e -> jRadioButton10minActionPerformed(e));

                //---- jRadioButtonXmin ----
                jRadioButtonXmin.addActionListener(e -> jRadioButtonXminActionPerformed(e));

                //---- jTextFieldXmin ----
                jTextFieldXmin.setEditable(false);
                jTextFieldXmin.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        jTextFieldXminKeyReleased(e);
                    }
                });

                //---- jLabelXmin ----
                jLabelXmin.setText("min");

                //---- jButtonResetTimer ----
                jButtonResetTimer.setText("Reset");
                jButtonResetTimer.setEnabled(false);
                jButtonResetTimer.addActionListener(e -> jButtonResetTimerActionPerformed(e));

                GroupLayout jPanelPresetLayout = new GroupLayout(jPanelPreset);
                jPanelPreset.setLayout(jPanelPresetLayout);
                jPanelPresetLayout.setHorizontalGroup(jPanelPresetLayout.createParallelGroup().addGroup(jPanelPresetLayout.createSequentialGroup().addGroup(jPanelPresetLayout.createParallelGroup().addComponent(jLabelPresetTitle).addGroup(jPanelPresetLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanelPresetLayout.createParallelGroup().addComponent(jRadioButton1min).addComponent(jRadioButton2min).addComponent(jRadioButton3min)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelPresetLayout.createParallelGroup().addComponent(jRadioButton5min).addComponent(jRadioButton10min).addGroup(jPanelPresetLayout.createSequentialGroup().addComponent(jRadioButtonXmin).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldXmin, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelXmin))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButtonResetTimer).addContainerGap()));
                jPanelPresetLayout.setVerticalGroup(jPanelPresetLayout.createParallelGroup().addGroup(jPanelPresetLayout.createSequentialGroup().addGroup(jPanelPresetLayout.createParallelGroup().addGroup(jPanelPresetLayout.createSequentialGroup().addComponent(jLabelPresetTitle).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelPresetLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jRadioButton1min).addComponent(jRadioButton5min))).addGroup(jPanelPresetLayout.createSequentialGroup().addContainerGap().addComponent(jButtonResetTimer))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelPresetLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jRadioButton2min).addComponent(jRadioButton10min)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelPresetLayout.createParallelGroup().addComponent(jRadioButton3min).addGroup(jPanelPresetLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextFieldXmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabelXmin)).addComponent(jRadioButtonXmin)).addContainerGap(12, Short.MAX_VALUE)));
            }

            GroupLayout jPanelTimerLayout = new GroupLayout(jPanelTimer);
            jPanelTimer.setLayout(jPanelTimerLayout);
            jPanelTimerLayout.setHorizontalGroup(jPanelTimerLayout.createParallelGroup().addGroup(jPanelTimerLayout.createSequentialGroup().addContainerGap().addGroup(jPanelTimerLayout.createParallelGroup().addGroup(jPanelTimerLayout.createSequentialGroup().addGroup(jPanelTimerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(jButtonStartStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanelPreset, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)).addGap(0, 0, Short.MAX_VALUE)).addGroup(jPanelTimerLayout.createSequentialGroup().addComponent(jTextFieldMinutes, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE).addComponent(jLabelColon).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldSeconds, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
            jPanelTimerLayout.setVerticalGroup(jPanelTimerLayout.createParallelGroup().addGroup(jPanelTimerLayout.createSequentialGroup().addGroup(jPanelTimerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextFieldMinutes, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE).addComponent(jTextFieldSeconds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabelColon)).addGap(12, 12, 12).addComponent(jButtonStartStop).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanelPreset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
        }
        contentPane.add(jPanelTimer);

        //======== jPanelSeries ========
        {
            jPanelSeries.setBorder(new TitledBorder("Series counter:"));

            //---- jTextFieldSeries ----
            jTextFieldSeries.setEditable(false);
            jTextFieldSeries.setFont(new Font("Tahoma", Font.PLAIN, 18));
            jTextFieldSeries.setHorizontalAlignment(SwingConstants.CENTER);
            jTextFieldSeries.setText("0");
            jTextFieldSeries.setToolTipText("Po\u010det odcvi\u010den\u00fdch s\u00e9ri\u00ed");

            //---- jLabelSeries ----
            jLabelSeries.setFont(new Font("Tahoma", Font.PLAIN, 18));
            jLabelSeries.setText("series");

            //---- jButtonSetSeries ----
            jButtonSetSeries.setText("Set");
            jButtonSetSeries.setToolTipText("Nejprve je nutn\u00e9 nastavit re\u017eim odpo\u010d\u00edt\u00e1v\u00e1n\u00ed.");
            jButtonSetSeries.setEnabled(false);
            jButtonSetSeries.setMargin(new Insets(2, 5, 2, 5));
            jButtonSetSeries.setPreferredSize(new Dimension(63, 23));
            jButtonSetSeries.addActionListener(e -> jButtonSetSeriesActionPerformed(e));

            //---- jButtonResetSeries ----
            jButtonResetSeries.setText("Reset");
            jButtonResetSeries.setMargin(null);
            jButtonResetSeries.addActionListener(e -> jButtonResetSeriesActionPerformed(e));

            //---- jLabelSeriesCounterMode ----
            jLabelSeriesCounterMode.setFont(new Font("Tahoma", Font.PLAIN, 10));
            jLabelSeriesCounterMode.setText("Mode: increasing");
            jLabelSeriesCounterMode.setEnabled(false);

            GroupLayout jPanelSeriesLayout = new GroupLayout(jPanelSeries);
            jPanelSeries.setLayout(jPanelSeriesLayout);
            jPanelSeriesLayout.setHorizontalGroup(jPanelSeriesLayout.createParallelGroup().addGroup(jPanelSeriesLayout.createSequentialGroup().addContainerGap().addGroup(jPanelSeriesLayout.createParallelGroup().addGroup(jPanelSeriesLayout.createSequentialGroup().addComponent(jTextFieldSeries, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelSeries).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE).addComponent(jButtonSetSeries, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonResetSeries)).addGroup(jPanelSeriesLayout.createSequentialGroup().addComponent(jLabelSeriesCounterMode).addGap(0, 110, Short.MAX_VALUE))).addContainerGap()));
            jPanelSeriesLayout.setVerticalGroup(jPanelSeriesLayout.createParallelGroup().addGroup(jPanelSeriesLayout.createSequentialGroup().addContainerGap().addGroup(jPanelSeriesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButtonSetSeries, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jButtonResetSeries).addGroup(jPanelSeriesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextFieldSeries, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE).addComponent(jLabelSeries))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelSeriesCounterMode).addContainerGap()));
        }
        contentPane.add(jPanelSeries);

        //======== jPanelGlobalTime ========
        {
            jPanelGlobalTime.setBorder(new TitledBorder("Exercise time:"));

            //---- jLabelHours ----
            jLabelHours.setText("hours");

            //---- jTextFieldGlobalTime ----
            jTextFieldGlobalTime.setEditable(false);
            jTextFieldGlobalTime.setHorizontalAlignment(SwingConstants.CENTER);
            jTextFieldGlobalTime.setText("00:00");
            jTextFieldGlobalTime.setPreferredSize(new Dimension(63, 21));

            //---- jLabelGlobalTime ----
            jLabelGlobalTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
            jLabelGlobalTime.setText("Clock:");
            jLabelGlobalTime.setEnabled(false);

            //---- jLabelGlobalTimeState ----
            jLabelGlobalTimeState.setFont(new Font("Tahoma", Font.PLAIN, 10));
            jLabelGlobalTimeState.setText("not running");
            jLabelGlobalTimeState.setEnabled(false);

            //---- jButtonResetGlobalTime ----
            jButtonResetGlobalTime.setText("Reset");

            //---- jButtonPauseGlobalTime ----
            jButtonPauseGlobalTime.setText("Pause");

            GroupLayout jPanelGlobalTimeLayout = new GroupLayout(jPanelGlobalTime);
            jPanelGlobalTime.setLayout(jPanelGlobalTimeLayout);
            jPanelGlobalTimeLayout.setHorizontalGroup(jPanelGlobalTimeLayout.createParallelGroup().addGroup(jPanelGlobalTimeLayout.createSequentialGroup().addContainerGap().addGroup(jPanelGlobalTimeLayout.createParallelGroup().addGroup(jPanelGlobalTimeLayout.createSequentialGroup().addComponent(jLabelGlobalTime).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelGlobalTimeState).addGap(0, 0, Short.MAX_VALUE)).addGroup(jPanelGlobalTimeLayout.createSequentialGroup().addComponent(jTextFieldGlobalTime, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelHours).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButtonPauseGlobalTime).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonResetGlobalTime))).addContainerGap()));
            jPanelGlobalTimeLayout.setVerticalGroup(jPanelGlobalTimeLayout.createParallelGroup().addGroup(jPanelGlobalTimeLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(jPanelGlobalTimeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextFieldGlobalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabelHours).addComponent(jButtonPauseGlobalTime).addComponent(jButtonResetGlobalTime)).addGroup(jPanelGlobalTimeLayout.createParallelGroup().addComponent(jLabelGlobalTimeState).addComponent(jLabelGlobalTime))));
        }
        contentPane.add(jPanelGlobalTime);
        pack();
        setLocationRelativeTo(getOwner());

        //======== jFramePreferences ========
        {
            jFramePreferences.setTitle("Preferences");
            jFramePreferences.setAlwaysOnTop(true);
            jFramePreferences.setBounds(new Rectangle(100, 100, 0, 0));
            jFramePreferences.setLocationByPlatform(true);
            jFramePreferences.setMinimumSize(new Dimension(300, 140));
            jFramePreferences.setResizable(false);
            Container jFramePreferencesContentPane = jFramePreferences.getContentPane();

            //---- jLabelPreferencesDesc ----
            jLabelPreferencesDesc.setText("Chose ascending or descending series counter mode.");

            //---- jRadioButtonAsc ----
            jRadioButtonAsc.setSelected(true);
            jRadioButtonAsc.setText("ascending");

            //---- jRadioButtonDesc ----
            jRadioButtonDesc.setText("descending");

            //---- jLabelPreferencesHeading ----
            jLabelPreferencesHeading.setFont(new Font("Tahoma", Font.BOLD, 11));
            jLabelPreferencesHeading.setText("Series counter mode:");

            //---- jButtonSavePreferences ----
            jButtonSavePreferences.setText("Save");
            jButtonSavePreferences.addActionListener(e -> jButtonSavePreferencesActionPerformed(e));

            //---- jButtonStornoPreferences ----
            jButtonStornoPreferences.setText("Storno");
            jButtonStornoPreferences.addActionListener(e -> jButtonStornoPreferencesActionPerformed(e));

            GroupLayout jFramePreferencesContentPaneLayout = new GroupLayout(jFramePreferencesContentPane);
            jFramePreferencesContentPane.setLayout(jFramePreferencesContentPaneLayout);
            jFramePreferencesContentPaneLayout.setHorizontalGroup(jFramePreferencesContentPaneLayout.createParallelGroup().addGroup(jFramePreferencesContentPaneLayout.createSequentialGroup().addContainerGap().addGroup(jFramePreferencesContentPaneLayout.createParallelGroup().addComponent(jLabelPreferencesHeading).addComponent(jLabelPreferencesDesc).addGroup(jFramePreferencesContentPaneLayout.createSequentialGroup().addComponent(jRadioButtonAsc).addGroup(jFramePreferencesContentPaneLayout.createParallelGroup().addGroup(jFramePreferencesContentPaneLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE).addComponent(jButtonSavePreferences, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonStornoPreferences)).addGroup(jFramePreferencesContentPaneLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(jRadioButtonDesc))))).addContainerGap()));
            jFramePreferencesContentPaneLayout.setVerticalGroup(jFramePreferencesContentPaneLayout.createParallelGroup().addGroup(jFramePreferencesContentPaneLayout.createSequentialGroup().addContainerGap().addComponent(jLabelPreferencesHeading).addGap(1, 1, 1).addComponent(jLabelPreferencesDesc).addGroup(jFramePreferencesContentPaneLayout.createParallelGroup().addGroup(jFramePreferencesContentPaneLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jFramePreferencesContentPaneLayout.createParallelGroup().addComponent(jRadioButtonAsc).addComponent(jRadioButtonDesc)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, jFramePreferencesContentPaneLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE).addGroup(jFramePreferencesContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButtonStornoPreferences).addComponent(jButtonSavePreferences)).addContainerGap()))));
        }

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(jRadioButton1min);
        buttonGroup1.add(jRadioButton2min);
        buttonGroup1.add(jRadioButton3min);
        buttonGroup1.add(jRadioButton5min);
        buttonGroup1.add(jRadioButton10min);
        buttonGroup1.add(jRadioButtonXmin);

        //---- buttonGroup2 ----
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(jRadioButtonAsc);
        buttonGroup2.add(jRadioButtonDesc);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ExTimer worker called on timer-tick
     */
    private ActionListener exTimerTickTock = evt -> {
        exTimerTimeSec -= 1;

        if (exTimerTimeSec <= 0) {
            exerciseTimeRanOut();
        } else {
            setExerciseTime(exTimerTimeSec);
        }
    };

    /**
     * GlobalTimer callback called on timer-tick
     */
    private ActionListener globalTimerTickTock = evt -> {
        globalTimerTimeSec += 1;
        setGlobalClock(globalTimerTimeSec);
    };

    /**
     * Called when exercise time is 00:00
     * Stops exTimer, adjusts GUI, resets timer and plays sound.
     */
    private void exerciseTimeRanOut() {
        exTimer.stop();
        exTimerTimeSec = exerciseTimeSecPreset;
        adjustExerciseGUIElements(true);
        playSound("alarm2.wav");
        setExerciseTime(exerciseTimeSecPreset);

        // increase or decrease series counter
        int numSeries = getNumberOfSeries();
        if (seriesCounterMode == CounterMode.DECREASING) {
            if (numSeries != 0) {
                numSeries--;
            } else {
                // TODO add some kind of notification
            }
        } else {
            numSeries++;
        }
        setNumberOfSeries(numSeries);
    }

    /**
     * Sets number of series to GUI text field
     */
    private void setNumberOfSeries(int numSeries) {
        jTextFieldSeries.setText(Integer.toString(numSeries));
    }

    /**
     * Gets number of series from GUI text field
     */
    private int getNumberOfSeries() {
        return Integer.parseInt(jTextFieldSeries.getText());
    }

    /**
     * Sets minutes and seconds to exercise time text fields
     */
    private void setExerciseTime(int timeSec) {
        exTimerTimeSec = timeSec;
        int minutes = timeSec / 60;
        int seconds = timeSec - (minutes * 60);
        jTextFieldMinutes.setText(String.format("%02d", minutes));
        jTextFieldSeconds.setText(String.format("%02d", seconds));
    }

    /**
     * Set global clock value to GUI element.
     */
    private void setGlobalClock(int timeSec) {
        int hours = timeSec / (60 * 60);
        int minutes = (timeSec - (hours * 60 * 60)) / 60;
        jTextFieldGlobalTime.setText(String.format("%02d", hours) + ":" + String.format("%02d", minutes));
    }

    /**
     * Depending on if exercise timer is running this methods enables/disables GUI elements
     */
    private void adjustExerciseGUIElements(boolean timerIsStopped) {
        jButtonStartStop.setText(timerIsStopped ? "START" : "STOP");
        jButtonResetTimer.setEnabled(timerIsStopped);
        jRadioButton1min.setEnabled(timerIsStopped);
        jRadioButton2min.setEnabled(timerIsStopped);
        jRadioButton3min.setEnabled(timerIsStopped);
        jRadioButton5min.setEnabled(timerIsStopped);
        jRadioButton10min.setEnabled(timerIsStopped);
        jRadioButtonXmin.setEnabled(timerIsStopped);
        jTextFieldXmin.setEnabled(timerIsStopped);
        jLabelXmin.setEnabled(timerIsStopped);
    }

    private void startGlobalClock() {
        jLabelGlobalTimeState.setText("running");
        jButtonPauseGlobalTime.setEnabled(true);
        jButtonResetGlobalTime.setEnabled(true);
    }

    private void resetGlobalClock() {
        jLabelGlobalTimeState.setText("not running");
        jButtonPauseGlobalTime.setEnabled(false);
        jButtonResetGlobalTime.setEnabled(false);
        jTextFieldGlobalTime.setText("00:00");
    }

    private void startExerciseTimer() {
        exTimer.start();
        adjustExerciseGUIElements(false);
        if (!globalTimer.isRunning()) {
            globalTimer.start();
            startGlobalClock();
        }
    }

    private void stopExerciseTimer() {
        exTimer.stop();
        adjustExerciseGUIElements(true);
    }

    private void saveSettings() {
        // set selected mode
        if (jRadioButtonAsc.isSelected()) {
            seriesCounterMode = CounterMode.INCREASING;
            numSeriesPreset = 0;
        } else {
            seriesCounterMode = CounterMode.DECREASING;
        }
        // adjust GUI according to selected mode
        if (seriesCounterMode == CounterMode.INCREASING) {
            jTextFieldSeries.setEditable(false);
            jButtonSetSeries.setEnabled(false);
            jLabelSeriesCounterMode.setText("Mode: increasing.");
        } else {
            jTextFieldSeries.setEditable(true);
            jButtonSetSeries.setEnabled(true);
            jButtonStartStop.setEnabled(false);
            jLabelSeriesCounterMode.setText("Mode: descreasing");
        }
        jFramePreferences.dispose();      // close dialog
    }

    /**
     * Play alarm sound after exercise timer time runs-off
     *
     * @param filename name of sound file
     */
    private void playSound(String filename) {
        try {
            // Get resource as stream
            InputStream audioStream = getClass().getResourceAsStream("/" + filename);
            if (audioStream == null) {
                audioStream = getClass().getResourceAsStream("/data/" + filename);
                if (audioStream == null) {
                    throw new RuntimeException("Could not find audio file: " + filename);
                }
            }
            // Wrap the InputStream with BufferedInputStream to support mark/reset
            BufferedInputStream bufferedIn = new BufferedInputStream(audioStream);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error when playing media file!");
            System.out.println(e.toString());
        }
    }

    /* ********************* event handlers ******************************** */

    private void jButtonResetClockClicked(ActionEvent e) {
        globalTimer.stop();
        globalTimerTimeSec = 0;
        resetGlobalClock();
    }

    private void jButtonPauseResumeClockClicked(ActionEvent e) {
        if (globalTimer.isRunning()) {
            globalTimer.stop();
            jButtonPauseGlobalTime.setText("Resume");
            jLabelGlobalTimeState.setText("paused");
        } else {
            globalTimer.start();
            jButtonPauseGlobalTime.setText("Pause");
            jLabelGlobalTimeState.setText("running");
        }
    }

    private void jButtonStartStopClicked(java.awt.event.ActionEvent evt) {
        if ((exTimer == null) || (!exTimer.isRunning())) {
            startExerciseTimer();
        } else {
            stopExerciseTimer();
        }
    }

    private void jRadioButton1minActionPerformed(java.awt.event.ActionEvent evt) {
        exerciseTimeSecPreset = 1 * 60;
        setExerciseTime(exerciseTimeSecPreset);
        jTextFieldXmin.setEditable(false);
    }

    private void jRadioButton2minActionPerformed(java.awt.event.ActionEvent evt) {
        exerciseTimeSecPreset = 2 * 60;
        setExerciseTime(exerciseTimeSecPreset);
        jTextFieldXmin.setEditable(false);
    }

    private void jRadioButton3minActionPerformed(java.awt.event.ActionEvent evt) {
        exerciseTimeSecPreset = 3 * 60;
        setExerciseTime(exerciseTimeSecPreset);
        jTextFieldXmin.setEditable(false);
    }

    private void jRadioButton5minActionPerformed(java.awt.event.ActionEvent evt) {
        exerciseTimeSecPreset = 5 * 60;
        setExerciseTime(exerciseTimeSecPreset);
        jTextFieldXmin.setEditable(false);
    }

    private void jRadioButton10minActionPerformed(java.awt.event.ActionEvent evt) {
        exerciseTimeSecPreset = 10 * 60;
        setExerciseTime(exerciseTimeSecPreset);
        jTextFieldXmin.setEditable(false);
    }

    private void jRadioButtonXminActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldXmin.setEditable(true);
    }

    /**
     * Custom exercise time field filled
     */
    private void jTextFieldXminKeyReleased(java.awt.event.KeyEvent evt) {
        // if some character is filled
        if (!(jTextFieldXmin.getText().equals(""))) {
            int minutes = 0;
            try {
                minutes = Integer.parseInt(jTextFieldXmin.getText());
            } catch (NumberFormatException e) {
                jTextFieldXmin.setText("");
                return;
            }
            // check bounds
            if (minutes > 99) {
                minutes = 99;
            } else if (minutes < 0) {
                minutes = 0;
            }
            jTextFieldXmin.setText(String.valueOf(minutes));
            exerciseTimeSecPreset = minutes * 60;
            setExerciseTime(exerciseTimeSecPreset);
        }
    }

    /**
     * Timer reset button
     */
    private void jButtonResetTimerActionPerformed(java.awt.event.ActionEvent evt) {
        setExerciseTime(exerciseTimeSecPreset);
    }

    /**
     * Quit the program
     */
    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Open Preferences dialog
     */
    private void jMenuItemPreferencesActionPerformed(java.awt.event.ActionEvent evt) {
        jFramePreferences.setVisible(true);
        jFramePreferences.setLocationRelativeTo(null);
    }

    /**
     * Storno changes and close Preferences dialog window.
     */
    private void jButtonStornoPreferencesActionPerformed(java.awt.event.ActionEvent evt) {
        jFramePreferences.dispose();
    }

    /**
     * Save changes and close Preferences dialog window.
     */
    private void jButtonSavePreferencesActionPerformed(java.awt.event.ActionEvent evt) {
        saveSettings();
    }

    /**
     * User set number of series by clicking Set button.
     */
    private void jButtonSetSeriesActionPerformed(java.awt.event.ActionEvent evt) {
        int newValue;
        try {
            newValue = Integer.parseInt(jTextFieldSeries.getText());
            if (newValue <= 0) throw new NumberFormatException();

        } catch (NumberFormatException e) {
            final String originalTest = jLabelSeriesCounterMode.getText();
            jLabelSeriesCounterMode.setText("Desired number must be greater than zero!");
            jButtonStartStop.setEnabled(false);

            // show info message about wrong input number to user
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
                jLabelSeriesCounterMode.setText(originalTest);

            }).start();
            jTextFieldSeries.setText("0");
            return;
        }
        setNumberOfSeries(newValue);
        numSeriesPreset = newValue;
        jButtonStartStop.setEnabled(true);
    }

    /**
     * User clicked on Reset series button.
     */
    private void jButtonResetSeriesActionPerformed(java.awt.event.ActionEvent evt) {
        setNumberOfSeries(numSeriesPreset);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Windows look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Milan Herbig
    private JMenuBar jMenuBar1;
    private JMenu jMenuFile;
    private JMenuItem jMenuItemPreferences;
    private JMenuItem jMenuItemQuit;
    private JMenu jMenuHelp;
    private JMenuItem jMenuItemAbout;
    private JPanel jPanelTimer;
    private JButton jButtonStartStop;
    private JTextField jTextFieldMinutes;
    private JLabel jLabelColon;
    private JTextField jTextFieldSeconds;
    private JPanel jPanelPreset;
    private JLabel jLabelPresetTitle;
    private JRadioButton jRadioButton1min;
    private JRadioButton jRadioButton2min;
    private JRadioButton jRadioButton3min;
    private JRadioButton jRadioButton5min;
    private JRadioButton jRadioButton10min;
    private JRadioButton jRadioButtonXmin;
    private JTextField jTextFieldXmin;
    private JLabel jLabelXmin;
    private JButton jButtonResetTimer;
    private JPanel jPanelSeries;
    private JTextField jTextFieldSeries;
    private JLabel jLabelSeries;
    private JButton jButtonSetSeries;
    private JButton jButtonResetSeries;
    private JLabel jLabelSeriesCounterMode;
    private JPanel jPanelGlobalTime;
    private JLabel jLabelHours;
    private JTextField jTextFieldGlobalTime;
    private JLabel jLabelGlobalTime;
    private JLabel jLabelGlobalTimeState;
    private JButton jButtonResetGlobalTime;
    private JButton jButtonPauseGlobalTime;
    private JFrame jFramePreferences;
    private JLabel jLabelPreferencesDesc;
    private JRadioButton jRadioButtonAsc;
    private JRadioButton jRadioButtonDesc;
    private JLabel jLabelPreferencesHeading;
    private JButton jButtonSavePreferences;
    private JButton jButtonStornoPreferences;
    // End of variables declaration//GEN-END:variables


}
