package com.mballem.tutorial;

import javax.swing.*;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 20/01/14
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class SerializeService {

    public void toSerialize(RadioList radioList) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(null);

            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(radioList);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public RadioList toDeserialize() {
        RadioList radioList = null;
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);

            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(fis);

            radioList = (RadioList) is.readObject();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return radioList;
    }
}
