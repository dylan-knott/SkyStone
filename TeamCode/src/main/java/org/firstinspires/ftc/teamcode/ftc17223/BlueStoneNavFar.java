package org.firstinspires.ftc.teamcode.ftc17223;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Blue 1 Stone Nav Far")
//Remove this when making your op mode, this is only here so that the template doesn't show in the app
@Disabled
public class BlueStoneNavFar extends LinearOpMode {

    public void runOpMode() {
        //Initialization code
        RobotDrive robotDrive = new RobotDrive();
        VuforiaClass vuforiaClass = new VuforiaClass();
        robotDrive.initializeRobot(hardwareMap, telemetry, RobotDrive.color.blue);
        vuforiaClass.InitVuforia(hardwareMap, telemetry, RobotDrive.color.blue);
        int InchesTemp;

        waitForStart();
        //Code to run once once start button is pressed

        robotDrive.driveEncoder(23);
        robotDrive.strafeEncoder(10, RobotDrive.direction.right);
        robotDrive.gyroTurn(-90);
        telemetry.addLine("Searching for stone");
        telemetry.update();
        vuforiaClass.seekStone();
        robotDrive.strafeEncoder(7, RobotDrive.direction.left);
        robotDrive.mixDrive(robotDrive.motorPower, 0, 0);
        //Drive forward until the blue middle line is hit
        while (robotDrive.colorSensor.blue() < robotDrive.colorThreshold);
        //Stop the robot
        robotDrive.mixDrive(0,0,0);
        //Drive an additional 11 inches before dropping the stone and returning to center
        robotDrive.driveEncoder(11);
        robotDrive.SetSideArm(0, 180);
        robotDrive.driveEncoder(-7);

    }
}
