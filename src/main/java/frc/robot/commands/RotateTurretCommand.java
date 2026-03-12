package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TurretSubsystem;

public class RotateTurretCommand extends Command {

    private TurretSubsystem turret;
    private double speed;

    public RotateTurretCommand(TurretSubsystem turret, double speed) {
        this.turret = turret;
        this.speed = speed;
        addRequirements(turret);
    }

    @Override
    public void execute() {
        turret.rotate(speed);
    }

    public void end(boolean interrupted) {
        turret.stopTurretRotation();
    }

}