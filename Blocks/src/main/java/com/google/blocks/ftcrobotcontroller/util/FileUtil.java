// Copyright 2016 Google Inc.

package com.google.blocks.ftcrobotcontroller.util;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * A class that provides utility methods for reading and writing files.
 *
 * @author lizlooney@google.com (Liz Looney)
 */
class FileUtil {
  static final File BLOCKS_DIR = AppUtil.BLOCK_OPMODES_DIR;

  // Prevent instantiation of utility class.
  private FileUtil() {
  }

  /**
   * Writes the given String to the given File.
   */
  static void writeFile(File file, String content) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    try {
      writer.write(content);
    } finally {
      writer.close();
    }
  }

  /**
   * Writes the given byte[] to the given File.
   */
  static void writeBinaryFile(File file, byte[] content) throws IOException {
    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
    try {
      outputStream.write(content, 0, content.length);
    } finally {
      outputStream.close();
    }
  }

  /**
   * Reads the given File and returns a String.
   */
  static String readFile(File file) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader reader = new BufferedReader(new FileReader(file));
    try {
      String line = null;
      while ((line = reader.readLine()) != null) {
        sb.append(line).append("\n");
      }
    } finally {
      reader.close();
    }
    return sb.toString();
  }

  /**
   * Reads the given File and returns a String.
   */
  static byte[] readBinaryFile(File file) throws IOException {
    byte[] content = new byte[(int) file.length()];
    StringBuilder sb = new StringBuilder();
    BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
    try {
      inputStream.read(content, 0, content.length);
    } finally {
      inputStream.close();
    }
    return content;
  }

  /**
   * Copies the given source File to the given dest File.
   */
  static void copyFile(File source, File dest) throws IOException {
    FileChannel sourceChannel = null;
    FileChannel destChannel = null;
    try {
      sourceChannel = new FileInputStream(source).getChannel();
      destChannel = new FileOutputStream(dest).getChannel();
      destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
    } finally {
      sourceChannel.close();
      destChannel.close();
    }
  }
}
