package util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class Startup {

    public void start(@Observes StartupEvent evt) {
        // in DEV mode we seed some data
        if (LaunchMode.current() == LaunchMode.DEVELOPMENT) {
            // nothing
        }
    }
}
