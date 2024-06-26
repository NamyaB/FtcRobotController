package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class HelloWorld extends OpMode {
    enum State {
        START,
        SECOND_STEP,
        DONE
    }

    State state = State.START;
    double lastTime;
    // called for when driver presses INIT on driver station
    @Override
    public void init() {
        telemetry.addData("Hello ", "World");
    }

    @Override
    public void start() {
        state = State.START;
        resetRuntime();
        lastTime = getRuntime();
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

        telemetry.addData("sum of triggers", gamepad1.right_trigger + gamepad1.left_trigger);

        telemetry.addData("State", state);
        telemetry.addData("Runtime", getRuntime());
        telemetry.addData("Time in State", getRuntime() - lastTime);
        switch (state) {
            case START:
                if (getRuntime() >= 3.0) {
                    state = State.SECOND_STEP;
                    lastTime = getRuntime();
                }
                break;
            case SECOND_STEP:
                if (getRuntime() >= lastTime + 3.0) {
                    state = State.DONE;
                }
                lastTime = getRuntime();
                break;
            default:
                telemetry.addData("Auto", "Finished");
            }
    }
}
