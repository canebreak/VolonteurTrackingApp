/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourceHelper {

    private ResourceHelper() {

    }

    public static String getResourceText(String resourceUrl) {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                ResourceHelper.class.getResourceAsStream(resourceUrl)));
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        String line;
        try {
            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false;
                } else {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("There is no resource file %s", resourceUrl));
        }
        return sb.toString();
    }

}
