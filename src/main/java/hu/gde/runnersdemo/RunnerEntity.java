package hu.gde.runnersdemo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private long pace;

    private int shoeSize;

    @OneToMany(mappedBy = "runner")
    private List<LapTimeEntity> laptimes = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private ShoeName shoe;


    public RunnerEntity() {
    }

    public long getRunnerId() {
        return runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public long getPace() {
        return pace;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public void setPace(long pace) {
        this.pace = pace;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public ShoeName getShoe() {
        return shoe;
    }

    public void setShoe(ShoeName shoe) {
        this.shoe = shoe;
    }

    public List<LapTimeEntity> getLaptimes() {
        return laptimes;
    }
}
