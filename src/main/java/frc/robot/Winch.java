package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class Winch implements cmd {
  WPI_TalonSRX winchL;
  WPI_TalonSRX winchR;
  Joystick joystickExtras;

  public Winch(WPI_TalonSRX winchL, WPI_TalonSRX winchR, Joystick joystickExtras) {
    this.winchL = winchL;
    this.winchR = winchR;
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

  public void teleopPeriodic() {}

  public void _winch(double up, boolean leftAdj, boolean rtAdj, boolean endgame){
    if (Math.abs(up) < 0.10) {
      up = 0;
    }

    // start to climb at endgame
    if (leftAdj) {
      setWinchL(-up);
      setWinchR(0.0);
    } else if (rtAdj) {
      setWinchL(0.0);
      setWinchR(-up);
    } else if (endgame) {
      setWinchB(up);
    } else {
      setWinchB(0);
    }

  }
  public void setWinchL(double power){
    winchL.set(-power);
  }
  public void setWinchR(double power){
    winchR.set(power);
  }
  public void setWinchB(double power){
    winchL.set(power);
    winchR.set(power);
  }
  
}