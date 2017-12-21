package org.firstinspires.ftc.robotcore.internal.settings;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import org.firstinspires.ftc.robotcore.internal.webserver.RobotControllerWebHandlers;
import org.firstinspires.ftc.robotcore.internal.webserver.RobotControllerWebHandlers.FileWebHandler;
import org.firstinspires.ftc.robotcore.internal.webserver.RobotControllerWebHandlers.ListFilesWebHandler;
import org.firstinspires.ftc.robotcore.internal.webserver.RobotControllerWebHandlers.StringWebHandler;

public class SettingsWebHandlers {
    private static FileWebHandler settingsFileWebHandler;
    private static ListFilesWebHandler settingsListFilesWebHandler;
    private static StringWebHandler activeSettingsStringWebHandler;
    private static StringWebHandler metaSettingsStringWebHandler;

    public static void register() {
        // Any Url starting with "/settings/" will GET files from and PUT files to the ROBOT_SETTINGS directory.
        settingsFileWebHandler = new FileWebHandler("^/settings/", AppUtil.ROBOT_SETTINGS);
        RobotControllerWebHandlers.registerFilter("settings", settingsFileWebHandler);

        settingsListFilesWebHandler = new ListFilesWebHandler(AppUtil.ROBOT_SETTINGS);
        RobotControllerWebHandlers.register("/settings", settingsListFilesWebHandler);

        activeSettingsStringWebHandler = new StringWebHandler();
        RobotControllerWebHandlers.register("/settings/$activeSettings", activeSettingsStringWebHandler);

        metaSettingsStringWebHandler = new StringWebHandler();
        RobotControllerWebHandlers.register("/settings/$meta", metaSettingsStringWebHandler);
    }

    public static void registerActiveSettings(Settings settings) {
        if (activeSettingsStringWebHandler != null) {
            activeSettingsStringWebHandler.setValue(settings);
        }
    }

    public static void  registerMetaSettings(MetaSettings metaSettings) {
        if (metaSettingsStringWebHandler != null) {
            metaSettingsStringWebHandler.setValue(metaSettings);
        }
    }
}
