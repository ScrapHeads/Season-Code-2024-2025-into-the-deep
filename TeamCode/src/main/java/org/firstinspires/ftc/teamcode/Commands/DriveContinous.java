package org.firstinspires.ftc.teamcode.Commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class DriveContinous extends CommandBase {
    private Drivetrain drivetrain;
    private GamepadEx driver;

    public DriveContinous(Drivetrain drivetrain, GamepadEx driver) {
        this.drivetrain = drivetrain;
        this.driver = driver;

        addRequirements(drivetrain);
    }

//    @Override
//    public void initialize(){
//
//    }

    @Override
    public void execute(){
        Pose2d pose = new Pose2d(-driver.getLeftY(), driver.getLeftX(), driver.getRightX());
        drivetrain.setWeightedDrivePower(pose);
    }

    @Override
    public void end(boolean isInterrupted){
        drivetrain.setMotorPowers(0, 0, 0, 0);
    }
}
