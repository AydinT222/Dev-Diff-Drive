package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class Intake implements cmd {
    WPI_TalonSRX intake;
    Joystick joystickExtras;

    public Intake(WPI_TalonSRX intake, Joystick joystickExtras){
        this.intake = intake;
        this.joystickExtras = joystickExtras;

    }
    public void autonomousInit(){}
    public void autonomousPeriodic(){}
    public void testInit(){}
    public void testPeriodic(){}
    public void teleopInit(){}
    public void teleopPeriodic(){

    }
public double getIntake(){
    return intake.get();
}

    public void setIntake(double power){
        intake.set(power);
    }
    public void activateIntake(boolean intakeIn, boolean intakeOut){
        if (intakeIn){
            setIntake(-1);
        }
        else if (intakeOut){
            setIntake(1);
        }
        else{
            setIntake(0);
        }
    }
}