package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class HelloWorld extends OpMode {
    // called for when driver presses INIT on driver statiom
    @Override
    public void init() {
        String myName = "Namya Bhargava";
        telemetry.addData("Hello", myName);
    }

    // called repeatedly (50 times per second) until user presses PAUSE
    @Override
    public void loop() {
        double forwardSpeed = gamepad1.left_stick_y;
        telemetry.addData("right stick", gamepad1.right_stick_x);
        if (gamepad1.b) {
            telemetry.addData("B button", " is pressed");
        } else {
            telemetry.addData("B button", " is not pressed");
        }

        if (gamepad1.a && gamepad1.b) telemetry.addData("A and B button", " are pressed");
        else if (gamepad1.a) telemetry.addData("A button", " is pressed");
        else if (gamepad1.b) telemetry.addData("B button", " is pressed");
        else telemetry.addData("Neither A nor B button", " is pressed");

        telemetry.addData("sum of triggers", gamepad1.right_trigger+gamepad1.left_trigger);

        if (!gamepad1.a) {
            forwardSpeed *= 0.5;
        }
        telemetry.addData("forward speed", forwardSpeed);

        if (gamepad1.a) {
            telemetry.addData("right stick x", gamepad1.right_stick_y);
            telemetry.addData("left stick x", gamepad1.left_stick_y);
            telemetry.addData("right stick y", gamepad1.right_stick_x);
            telemetry.addData("left stick y", gamepad1.left_stick_x);
        } else {
            telemetry.addData("right stick x", gamepad1.right_stick_x);
            telemetry.addData("left stick x", gamepad1.left_stick_x);
            telemetry.addData("right stick y", gamepad1.right_stick_y);
            telemetry.addData("left stick y", gamepad1.left_stick_y);
        }
    }
}
