/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.json;

import com.lnu.agile.model.mapped.TrackInfoArray;

/**
 *
 * @author olefir
 */
public interface FileParser {

    public TrackInfoArray parseFile(String path);

    public String getFilePath();

}
