package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractUi {
    protected String getInputedString() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            return input.readLine();
        }catch(IOException e){
            return "μμΈλ°μ";
        }
    }
    abstract public void show();
}
