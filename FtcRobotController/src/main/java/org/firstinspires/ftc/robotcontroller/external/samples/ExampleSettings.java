package org.firstinspires.ftc.robotcontroller.external.samples;

import com.google.gson.annotations.Expose;

import org.firstinspires.ftc.robotcore.internal.settings.Settings;

public class ExampleSettings extends Settings {
    @Expose boolean isRedAliance;
    @Expose boolean isNearSide;

    public class ClawSystem {
        @Expose public float loadPosition;
        @Expose public float releasePosition;
        @Expose public float pinchPosition;
    }
    @Expose public ClawSystem clawSystem = new ClawSystem();

    public class ElevatorSystem {
        @Expose public int loadPosition;
        @Expose public int block2Position;
        @Expose public int block3Position;
    }
    @Expose public ElevatorSystem elevatorSystem = new ElevatorSystem();

    public class BallFlickerSystem {
        @Expose String VerticalServoName;
        @Expose String horizontalServoName;

        @Expose float horizontalCenterPosition;
        @Expose float horizontalFlickAmount;
        @Expose float verticalTopPosition;
        @Expose float verticalBottomPosition;
    }
    @Expose public BallFlickerSystem leftBallFlickerSystem = new BallFlickerSystem();
    @Expose public BallFlickerSystem rightBallFlickerSystem = new BallFlickerSystem();

    public class DriveSystem {
        @Expose String frontLeftMotorName;
        @Expose String frontRightMotorName;
        @Expose String backLeftMotorName;
        @Expose String backRightMotorName;

        @Expose float maxPower;
    }
    @Expose public DriveSystem driveSystem = new DriveSystem();
}
