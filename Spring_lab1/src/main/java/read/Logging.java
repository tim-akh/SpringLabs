package read;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Pointcut("execution(public Customer[] Read.readDataFromFile())")
    public void callReadDataFromFile() {}

    @Pointcut("execution(public int Read.*(..))")
    public void callMethodAtRead() {}

    @Around("callReadDataFromFile()")
    public Customer[] readDataFromFileAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Read read = new Read();
            long m = System.currentTimeMillis();
            joinPoint.proceed();
            System.out.println("\n-------------------------------------------------------------------------------------------");
            System.out.println("Файл найден. Чтение данных заняло " + (double) (System.currentTimeMillis() - m) + " миллисекунд.");
            System.out.println("-------------------------------------------------------------------------------------------\n");
            return read.readDataFromFile();
        } catch (Exception e){
            System.out.println("\n-------------------------------------------------------------------------------------------");
            System.out.println("Файл не найден!");
            System.out.println("-------------------------------------------------------------------------------------------\n");
            return new Customer[0];
        }
    }

    @Before("callMethodAtRead()")
    public void printMethodNameAdvice(JoinPoint joinPoint) {
        System.out.println("\nИмя вызываемого метода: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "callMethodAtRead()", returning = "size")
    public void printReturnedAdvice(Object size) {
        System.out.println("Размер полученной выборки: " + size);
    }

    @AfterThrowing(pointcut = "callMethodAtRead()", throwing = "ex")
    public void printExceptionAdvice(Exception ex) {
        System.out.println("В ходе выполнения метода было выброшено следующее исключение: " + ex);
    }
}
