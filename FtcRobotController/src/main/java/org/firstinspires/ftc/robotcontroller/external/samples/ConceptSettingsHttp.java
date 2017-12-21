package org.firstinspires.ftc.robotcontroller.external.samples;


import org.firstinspires.ftc.robotcore.internal.opmode.RunOnStartup;
import org.firstinspires.ftc.robotcore.internal.settings.MetaSettings;


@RunOnStartup()
public class ConceptSettingsHttp implements Runnable {

    private static MetaSettings metaSettings;
    private static ExampleSettings exampleSettings;

    @Override
    public void run() {
        // MetaSettings are settings about settings... in particular where to find the application's settings
        metaSettings = MetaSettings.getMetaSettings();

        exampleSettings = metaSettings.getActiveSettings();
        if (exampleSettings == null) {
            exampleSettings = new ExampleSettings();
            metaSettings.setActiveSettings(exampleSettings);
        }
    }
}
