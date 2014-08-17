package no.mesan.spring.aspekter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aspekt som kontrolleres av en spinnvill apekatt!
 *
 * @author Torbjørn S. Knutsen
 */
@Aspect
public class ApekattAspekt {
    @Around("@annotation(Apekatt)")
    public Object releaseTheMonkeys(final ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
