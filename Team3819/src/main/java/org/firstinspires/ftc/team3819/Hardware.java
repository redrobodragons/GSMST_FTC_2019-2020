package org.firstinspires.ftc.team3819;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorControllerEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

public class Hardware {

    private HardwareMap map = null;

    public DcMotorEx  frontLeft = null, frontRight = null, backLeft = null, backRight = null;    //DC Motors
    public DcMotorControllerEx motorControllerEx = null;
    public Servo servo = null;
    public WebcamName Webcam1 = null;

    public static final double     PI  =  3.14159;
    public static final int        CPR = 537;                                 //encoder counts per revolution
    private static final double    DIAMETER = 4;                               //encoded drive wheel diameter (in)
    private static final double    GEARING = 1;
    public static final double     CPI = (CPR * GEARING) / (DIAMETER * PI);
    public static final double     CPF = CPI * 12;
    public static final double     TURNING_RADIUS = 7;
    public static final double     CIRCUMFRENCE = TURNING_RADIUS * 2 * PI;     //distnace 1 wheel travels in a full 360


    public Hardware(HardwareMap map){
        this.map = map;

        frontLeft = (DcMotorEx)map.get(DcMotor.class, "frontLeft");
        backLeft = (DcMotorEx)map.get(DcMotor.class, "backLeft");
        frontRight = (DcMotorEx)map.get(DcMotor.class, "frontRight");
        backRight = (DcMotorEx)map.get(DcMotor.class, "backRight");
        //servo = (Servo)map.get(Servo.class, "servo");
        //Webcam1 = map.get(WebcamName.class, "Webcam 1");

        //left.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        //left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }


    /*public void drive(int num) {
        left.setPower(num);
        right.setPower(num);
    }*/

    /*public void winch(float f) {
        liftFront.setPower(f);
        liftBack.setPower(f);
    }*/

    public void drive(Gamepad gp) {
        double turn = 0;
        if(Math.abs(gp.right_stick_x)>=.05 || Math.abs(gp.right_stick_y)>=.05) {
            if(Math.abs(gp.right_stick_x)>=.1) {
                turn = gp.right_stick_x;
            }
            frontLeft.setPower(-1 * gp.right_stick_y + turn);
            backLeft.setPower(-1 * gp.right_stick_y + turn);
            frontRight.setPower(-1 * gp.right_stick_y - turn);
            backRight.setPower(-1 * gp.right_stick_y - turn);
        }
        else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
    }

    /*public void driveInches(double pow, int in) {
        resetEncoders();
        motorControllerEx = (DcMotorControllerEx)left.getController();
        PIDFCoefficients pidfNew = new PIDFCoefficients(128, 40, 192, 57);
        int motorIndexL = ((DcMotorEx)left).getPortNumber();
        int motorIndexR = ((DcMotorEx)left).getPortNumber();

        int target = (int)(in*CPI);

        //motorControllerEx.setPIDFCoefficients(motorIndexL,DcMotor.RunMode.RUN_TO_POSITION,pidfNew);
        //motorControllerEx.setPIDFCoefficients(motorIndexR,DcMotor.RunMode.RUN_TO_POSITION,pidfNew);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setTargetPosition(target);
        right.setTargetPosition(target);

        //left.setDirection(DcMotorSimple.Direction.REVERSE);
        //right.setDirection(DcMotorSimple.Direction.FORWARD);

        //while( (left.getCurrentPosition()>target + 10||left.getCurrentPosition()<target-10) &&
        //      (right.getCurrentPosition()>target + 10||right.getCurrentPosition()<target-10) ) {
        left.setPower(pow);
        right.setPower(pow);

        //left.setDirection(DcMotorSimple.Direction.FORWARD);
        //right.setDirection(DcMotorSimple.Direction.REVERSE);
    }*/

    /*public void turn(double pow, double degrees) {
        resetEncoders();

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setTargetPosition(-1*(int)((360.0/degrees)*CIRCUMFRENCE*CPI));
        right.setTargetPosition((int)((360.0/degrees)*CIRCUMFRENCE*CPI));

        left.setPower(pow);
        right.setPower(pow);
    }*/

    /*public void armUp() {
        armLeft.setPower(1);
        armRight.setPower(1);
    }

    public void armDown() {
        armLeft.setPower(-.05);
        armRight.setPower(-.05);
    }

    public  void armStop() {
        armLeft.setPower(0);
        armRight.setPower(0);
    }

    public void servoUp() {
        servo.setPosition(1);
    }

    public void servoDown() {
        servo.setPosition(0.5);
    }

    public void intake() {intake.setPower(-.75); }

    public void intake(float f) {intake.setPower(f); }

    public void outtake() {intake.setPower(.75); }

    public void outtake(float f) {intake.setPower(-f); }

    public void donttake() {
        intake.setPower(0);
    }

    public void stop() {
        drive(0);
    }

    public boolean driveIsBusy(){
        return left.isBusy() || right.isBusy();
    }

    public boolean isBusy(){
        return left.isBusy() || right.isBusy();
    }*/

    /*public void resetEncoders(){
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }*/




}