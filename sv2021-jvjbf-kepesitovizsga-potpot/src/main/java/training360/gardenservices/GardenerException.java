package training360.gardenservices;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class GardenerException extends AbstractThrowableProblem {

    public GardenerException(String type, String message, Status status) {
        super(URI.create(type), message, status);
    }
}
