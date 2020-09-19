package samson;


import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.annotations.Test;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.ServiceLoader;
import static org.junit.Assert.assertEquals;


@TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
public class MethodInfo {


    @Test
    public void annotation() {
        ServiceLoader<ITestListener> serviceLoader =  ServiceLoader.load(ITestListener.class);
        Iterator iterator = serviceLoader.iterator();
        ITestListener iTestListener = (ITestListener) iterator.next();
        TestNG testNG= new TestNG();
        testNG.setTestClasses(new Class[]{MethodInfo.class});
        testNG.addListener(iTestListener);
        testNG.run();
        Annotation a = MethodInfo.class.getAnnotation(TestMethodInfo.class);
        System.out.println(((TestMethodInfo) a).author());
        System.out.println(((TestMethodInfo) a).priority());
        System.out.println(((TestMethodInfo) a).lastModified());
        assertEquals(1, 1);
    }
}
