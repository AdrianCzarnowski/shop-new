package model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Environment {
    public EnvironmentModel prod;
    public List<EnvironmentModel> getEnvironments() {
        List<EnvironmentModel> environments = new ArrayList<>();
        environments.add(getProd());
        return environments;
    }
}
