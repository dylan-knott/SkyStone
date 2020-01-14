package org.firstinspires.ftc.teamcode.ftc17223;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Red Nav Near")
//Remove this when making your op mode, this is only here so that the template doesn't show in the app
@Disabled
public class AutonomousTemp extends LinearOpMode {

    public void runOpMode() {
        //Initialization code
        RobotDrive robotDrive = new RobotDrive();
        robotDrive.initializeRobot(hardwareMap, telemetry, RobotDrive.color.blue);

        waitForStart();
        //Code to run once once start button is pressed
        AutonomousTemp.java
        strafeEncoder(2,RobotDrive.direction.right)
        while (opModeIsActive()) {
        //Code to run repeatedly once the op mode has started


        }
    }
}
