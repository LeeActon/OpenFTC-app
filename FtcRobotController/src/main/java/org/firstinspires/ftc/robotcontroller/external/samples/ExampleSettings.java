package org.firstinspires.ftc.robotcontroller.external.samples;

import com.google.gson.annotations.Expose;

import org.firstinspires.ftc.robotcore.internal.settings.Settings;

public class ExampleSettings extends Settings {
    @Expose public boolean isRedAliance;
    @Expose public boolean isNearSide;

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
        @Expose public String VerticalServoName;
        @Expose public String horizontalServoName;

        @Expose public float horizontalCenterPosition;
        @Expose public float horizontalFlickAmount;
        @Expose public float verticalTopPosition;
        @Expose public float verticalBottomPosition;
    }
    @Expose public BallFlickerSystem leftBallFlickerSystem = new BallFlickerSystem();
    @Expose public BallFlickerSystem rightBallFlickerSystem = new BallFlickerSystem();

    public class DriveSystem {
        @Expose public String frontLeftMotorName;
        @Expose public String frontRightMotorName;
        @Expose public String backLeftMotorName;
        @Expose public String backRightMotorName;

        @Expose public float maxPower;
    }
    @Expose public DriveSystem driveSystem = new DriveSystem();
}
