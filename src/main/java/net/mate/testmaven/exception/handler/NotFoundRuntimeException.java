package net.mate.testmaven.exception.handler;

import lombok.Setter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class NotFoundRuntimeException extends RuntimeException {
    private Long id;
    private String message;

    public NotFoundRuntimeException(Long id, String message) {
        super(message);
        this.message = message;
        this.id = id;
        log.error(" Not found resources by id: {} with message: {}", id, message);
    }
}
