package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Environment {
    public EnvironmentModel prod;
    public List<EnvironmentModel> getEnvironments() {
        List<EnvironmentModel> environments = new ArrayList<>();
        environments.add(getProd());
        return environments;
    }
}
