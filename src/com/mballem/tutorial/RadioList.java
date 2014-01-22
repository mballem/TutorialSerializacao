package com.mballem.tutorial;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 20/01/14
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class RadioList implements Serializable {

    private List<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();

    public List<JRadioButton> getRadioButtonList() {
        return radioButtonList;
    }

    public void setRadioButtonList(List<JRadioButton> radioButtonList) {
        this.radioButtonList = radioButtonList;
    }
}
