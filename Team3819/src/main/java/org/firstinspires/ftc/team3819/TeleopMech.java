package org.firstinspires.ftc.team3819;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.team3819.Hardware;


@TeleOp(name="TeleopMech")
public class TeleopMech extends OpMode {
    Hardware robot;
    double turn;

    private ElapsedTime runtime = new ElapsedTime();

    private ElapsedTime time = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    @Override
    public void init() {
        robot = new Hardware(hardwareMap);
    }

    private void driverOne() {
        robot.MechDrive(gamepad1);
        telemetry.addLine("Y stick 1 " + gamepad1.left_stick_y);
        telemetry.addLine("X stick 2 " + gamepad1.right_stick_x);
        telemetry.update();


        /*if(gamepad1.dpad_down) {
            robot.armUp();
        }
        else if(gamepad1.dpad_up) {
            robot.armDown();
        }
        else {
            robot.armStop();
        }

        if(gamepad1.y) {
            robot.servoUp();
        }

        if(gamepad1.x)
        {
            robot.servoDown();
        }*/

    }

    @Override
    public void loop() {
        init();
        driverOne();
    }



    }
