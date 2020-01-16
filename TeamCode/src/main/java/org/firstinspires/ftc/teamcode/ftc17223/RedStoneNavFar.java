package org.firstinspires.ftc.teamcode.ftc17223;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.Vuforia;

@Autonomous(name = "Red 1 Stone Nav Far")
public class RedStoneNavFar extends LinearOpMode {


    public void runOpMode() {
        //Initialization code
        telemetry.addLine("Initializing");
        telemetry.update();
        RobotDrive robotDrive = new RobotDrive();
        VuforiaClass vuforiaClass = new VuforiaClass();
        robotDrive.initializeRobot(hardwareMap, telemetry, RobotDrive.color.red);
        vuforiaClass.InitVuforia(hardwareMap, telemetry, RobotDrive.color.red);
        waitForStart();
        telemetry.addLine("Robot Initialized");
        telemetry.update();
        //Code to run once once start button is pressed

        robotDrive.driveEncoder(24);
        robotDrive.gyroTurn(-90);
        robotDrive.mixDrive(0,0,0);
        Thread.sleep(50);
        robotDrive.mixDrive(0.3, 0, 0);
        while (robotDrive.dist.getDistance(DistanceUnit.INCH) < 129);
        robotDrive.mixDrive(0,0,0);
        telemetry.addLine("Searching for stone");
        telemetry.update();
        vuforiaClass.seekStone();
        Thread.sleep(100);
        robotDrive.strafeEncoder(14, RobotDrive.direction.left);
        robotDrive.mixDrive(-0.4, 0, 0);
        //Drive forward until the red middle line is hit
        while (robotDrive.colorSensor.red() < 190);
        //Stop the robot
        robotDrive.mixDrive(0,0,0);
        //Drive an additional 11 inches before dropping the stone and returning to center
        robotDrive.driveEncoder(11);
        robotDrive.SetSideArm(70, 180);
        robotDrive.driveEncoder(-7);
    }
}
