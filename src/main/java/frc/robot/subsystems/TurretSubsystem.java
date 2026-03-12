package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import static frc.robot.Constants.BaseMotorCosntants.*;
import static frc.robot.Constants.ShooterConstants.*;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {

    SparkMax turretRotationMotor = new SparkMax(susanMotorChannel, brushless);
    SparkMax shooterMotor = new SparkMax(shooterMotorChannel, brushless);

    SlewRateLimiter susanSlewLimits = new SlewRateLimiter(slewLimits);

    public TurretSubsystem() {
    
        SparkMaxConfig baseConfig = new SparkMaxConfig();
        baseConfig.smartCurrentLimit(maxCurrent);
        baseConfig.idleMode(idleMode);
        baseConfig.voltageCompensation(nominalVoltage);

        SparkMaxConfig shooterMotorConfig = new SparkMaxConfig();
        shooterMotorConfig.apply(baseConfig);
        shooterMotor.configure(shooterMotorConfig, noReset, persist);

        SparkMaxConfig turretRotationMotorConfig = new SparkMaxConfig();
        turretRotationMotorConfig.apply(baseConfig);
        turretRotationMotor.configure(turretRotationMotorConfig, noReset, persist);

    }

    public void rotate(double speed){
        turretRotationMotor.set(speed);
    }
    
    public void stopTurretRotation() {
        turretRotationMotor.set(0);
    }

    public void shoot(double speed){
        shooterMotor.set(speed);
    }

    public void stopShooter(){
        shooterMotor.set(0);
    }
}