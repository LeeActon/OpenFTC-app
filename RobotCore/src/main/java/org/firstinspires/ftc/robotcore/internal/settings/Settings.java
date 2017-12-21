package org.firstinspires.ftc.robotcore.internal.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class Settings {
    private static Gson gson;
    protected File file;

    public static File fullPath(String fileName) {
        return new File(AppUtil.ROBOT_SETTINGS, fileName);
    }

    private static Gson getGson()
    {
        if (gson == null)
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        return gson;
    }

    @Override
    public String toString() {
        String className = this.getClass().toString().substring(6); // remove "class " from the front (six chars)
        String json = toJson(this);

        return className + "\n" + json + "\n";
    }

    public static <T> T fromJson(String json, Class<T> classOfT)
    {
        return getGson().fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT)
    {
        return getGson().fromJson(json, typeOfT);
    }

    public static <T> String toJson(T value)
    {
        return getGson().toJson(value);
    }

    public static <T> T fromFile(String fileName)
    {
        File file = new File(AppUtil.ROBOT_SETTINGS, fileName);

        return fromFile(file);
    }

    public static <T> T fromFile(File file)
    {
        try
        {
            if (!file.exists() || !file.canRead())
                return null;

            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            // The first line of the file is the name of the class that holds the settings
            String className = reader.readLine();
            Type type = null;
            try {
                type = Class.forName(className);
            }
            catch (ClassNotFoundException e) {
                return null;
            }

            // The second line contains the JSON with the settings values.
            String json = reader.readLine();

            reader.close();
            fileReader.close();

            T object = fromJson(json, type);

            // If it is a Settings object, remember the file name
            if ((object != null) && (object instanceof Settings)) {
                ((Settings)object).file = file;
            }

            return object;
        }
        catch (IOException exception)
        {
            String s = exception.getMessage();
        }

        return null;
    }

    public void save() {
        toFile(this.file);
    }


    public void toFile(File file)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String text = this.toString();

            writer.write(text);
            writer.close();

            fileWriter.close();
        }
        catch (IOException exception)
        {
            String s = exception.getMessage();
        }
    }
}
