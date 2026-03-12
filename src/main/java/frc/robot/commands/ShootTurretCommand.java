package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TurretSubsystem;

public class ShootTurretCommand extends Command {
    
    private TurretSubsystem turret;

    public ShootTurretCommand(TurretSubsystem turret){
        this.turret = turret;
        addRequirements(turret);
    }

    @Override
    public void execute() {
        turret.shoot(1);
    }

    @Override
    public void end(boolean interrupted){
        turret.stopShooter();
    }

}