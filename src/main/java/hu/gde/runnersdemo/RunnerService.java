package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public double getAverageLaptime(Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            return (double) totalTime / laptimes.size();
        } else {
            return -1.0;
        }
    }

    public double getAveragePace() {
        List<RunnerEntity> runners = runnerRepository.findAll();
        if (runners != null) {
            int totalPace = 0;

            for (RunnerEntity runner : runners) {
                totalPace += runner.getPace();
            }
            return (double) totalPace / runners.size();
        } else {
            return -1.0;
        }
    }

    public String getBiggestFeetRunnerName() {
        List<RunnerEntity> runners = runnerRepository.findAll();

        RunnerEntity biggestFeet = null;

        if (runners != null) {
            for (RunnerEntity runner : runners) {
                if (biggestFeet == null) {
                    biggestFeet = runner;
                }
                else {
                    if (biggestFeet.getShoeSize() < runner.getShoeSize()) {
                        biggestFeet = runner;
                    }
                }
            }
            return biggestFeet.getRunnerName();
        } else {
            return "";
        }
    }
}
