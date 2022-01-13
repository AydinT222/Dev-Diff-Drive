package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class Conveyer implements cmd {
    WPI_TalonSRX conveyer;
    Joystick joystickExtras;
    double conveyerSpeed;

    public Conveyer(WPI_TalonSRX conveyer, Joystick joystickExtras) {
        this.conveyer = conveyer;
        this.joystickExtras = joystickExtras;

    }

    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
    }

    public void testInit() {
    }

    public void testPeriodic() {
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
    }

    public void setConveyer(double power) {
        conveyer.set(power);
    }

    public void activateConveyer(boolean conveyerIn, boolean conveyerOut, boolean halfSpeedButton) {

        if (conveyerIn) {
            conveyerSpeed = .75;
        } else if (conveyerOut) {
            conveyerSpeed = -.75;
        } else {
            conveyerSpeed = 0;
        }

        setConveyer(conveyerSpeed);
    }
}