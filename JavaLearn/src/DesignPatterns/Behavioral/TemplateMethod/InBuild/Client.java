package DesignPatterns.Behavioral.TemplateMethod.InBuild;

import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractSet;
import java.util.Iterator;

public class Client {


    public static void main(String[] args) {


        InputStream stream  = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };


        AbstractSet set = new AbstractSet() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }
}
