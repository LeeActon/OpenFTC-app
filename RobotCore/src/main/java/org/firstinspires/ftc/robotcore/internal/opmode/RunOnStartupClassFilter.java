package org.firstinspires.ftc.robotcore.internal.opmode;


public class RunOnStartupClassFilter implements ClassFilter {

    private static RunOnStartupClassFilter instance = new RunOnStartupClassFilter();
    public static RunOnStartupClassFilter getInstance() {return instance;}

    @Override
    public void filterAllClassesStart() {

    }

    @Override
    public void filterOnBotJavaClassesStart() {

    }

    @Override
    public void filterClass(Class clazz) {
        if (clazz.isAnnotationPresent(RunOnStartup.class)) {
            try {
                Object o = clazz.newInstance();
                if (o instanceof Runnable) {
                    Runnable runnable = (Runnable) o;

                    runnable.run();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void filterOnBotJavaClass(Class clazz) {

    }

    @Override
    public void filterAllClassesComplete() {

    }

    @Override
    public void filterOnBotJavaClassesComplete() {

    }
}
