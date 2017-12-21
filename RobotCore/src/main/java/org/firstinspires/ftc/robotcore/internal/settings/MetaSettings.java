package org.firstinspires.ftc.robotcore.internal.settings;

import com.google.gson.annotations.Expose;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import org.firstinspires.ftc.robotcore.internal.settings.SettingsWebHandlers;

import java.io.File;

public class MetaSettings extends Settings {
    @Expose public String activeSettingsFileName = "settings";

    private static MetaSettings metaSettings;

    private Settings activeSettings;

    public static MetaSettings getMetaSettings() {
        if (metaSettings == null) {
            SettingsWebHandlers.register();

            metaSettings = fromFile();

            if (metaSettings == null) {
                metaSettings = new MetaSettings();
            }
        }

        SettingsWebHandlers.registerMetaSettings(metaSettings);

        return metaSettings;
    }

    public static MetaSettings fromFile() {
        return Settings.fromFile(new File(AppUtil.ROBOT_SETTINGS, "meta"));
    }

    public <T> T getActiveSettings() {
        if ((this.activeSettings == null) && (this.activeSettingsFileName != null)) {
            Settings settings = Settings.fromFile(this.activeSettingsFileName);

            setActiveSettings(settings);
        }
        return (T) this.activeSettings;
    }

    public void setActiveSettings(Settings settings) {
        this.activeSettings = settings;

        SettingsWebHandlers.registerActiveSettings(this.activeSettings);
    }
}

