package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive implements cmd {

  WPI_TalonSRX rtFront;
  WPI_TalonSRX rtFollower;
  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftFollower;
  Joystick joystick;
  ADXRS450_Gyro gyro;
  double currentAngle;
  double kP = .098;
  DifferentialDrive diffDrive;

  public Drive(WPI_TalonSRX rtFront, WPI_TalonSRX rtFollower, WPI_TalonSRX leftFront, WPI_TalonSRX leftFollower,
      Joystick joystick) {
    this.rtFront = rtFront;
    this.rtFollower = rtFollower;
    this.leftFront = leftFront;
    this.leftFollower = leftFollower;
    this.joystick = joystick;
    diffDrive = new DifferentialDrive(leftFront, rtFront);
    diffDrive.setRightSideInverted(false);
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
  public void _drive(double forw, double turn){
     /* get gamepad stick values */

     if (Math.abs(forw) < 0.1) {
      forw = 0;
    }

    diffDrive.arcadeDrive(forw, turn);
    /* deadband gamepad 10% */

    /*// gyro code for driving straight
    if (Math.abs(turn) > .10) {
      diffDrive.arcadeDrive(forw, turn);
      currentAngle = gyro.getAngle();
    } else {
      double error = currentAngle - gyro.getAngle();
      diffDrive.arcadeDrive(forw, error * kP);

    }*/
  }
}
