package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Shooter implements cmd {
  CANSparkMax shootL;
  CANSparkMax shootR;
  Joystick joystick;

  int shootFlag = 0;
  Timer shootTimer = new Timer();

  public Shooter(CANSparkMax shootL, CANSparkMax shootR, Joystick joystick) {
    this.shootL = shootL;
    this.shootR = shootR;
    this.joystick = joystick;

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
    /*
     * final boolean shoot = joystick.getRawButton(1); //shooting a ball if (shoot){
     * shootL.set(-1.0); shootR.set(1.0); //conveyer.set(1.0); }else{
     * shootL.set(0.0); shootR.set(0.0); }
     */
    // test code for rapid fire w/ conveyer

  }

  public void setShootL(double power) {
    shootL.set(-power);
  }

  public void setShootR(double power) {
    shootR.set(power);
  }

  public void setShoot(double power) {
    shootL.set(-power);
    shootR.set(power);
  }

  public void shootCommand(boolean shootCmd, Conveyer conveyerDude) {
    if (shootCmd) {
      if (shootFlag == 0) {
        setShoot(-1);

        shootTimer.stop();
        shootTimer.reset();
        shootTimer.start();

        shootFlag++;

      } else if (shootFlag == 1) {
        if (shootTimer.get() > 1) {
          shootFlag++;
        }
      } else if (shootFlag == 2) {
        conveyerDude.setConveyer(-0.5);
      }
    } else {
      setShoot(0);
      shootTimer.stop();
      shootTimer.reset();
      shootFlag = 0;
    }
  }
}