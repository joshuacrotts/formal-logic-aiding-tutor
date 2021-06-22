package com.flat.tools;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ThreadLocalRandom;

public class FLATUtils {

    /**
     * Returns a random integer between min and max.
     *
     * @param min
     * @param max
     * @return random integer
     */
    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(" Max must be smaller than min.");
        }

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Returns a random integer between 0 and max.
     *
     * @param max
     * @return random integer
     */
    public static int randomInt(int max) {
        return randomInt(0, max);
    }

    /**
     * Determines if there is a connection to the internet (as the name implies!).
     * Sends a connection request to google.com (which we assume is always online :D)
     * and if it finds the connection, we return true and false otherwise.
     *
     * @return
     */
    public static boolean connectedToNet() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
     * 
     * @param _n
     * @param _str
     * @return 
     */
    public static String repeatString(int _n, String _str) {
      StringBuilder b = new StringBuilder(_n * _str.length());
        for (int i = 0; i < _n; ++i) {
            b.append(_str);
        }
        return b.toString();
    }
    
    /**
     * 
     * @param _s1
     * @param _s2
     * @return 
     */
    public static int sbCompareTo(StringBuilder _s1, StringBuilder _s2) {
      if (_s1.length() > _s2.length()) return 1;
      else if (_s1.length() < _s2.length()) return -1;
      else {
        for (int i = 0; i < _s1.length(); i++) {
          if (_s1.charAt(i) < _s2.charAt(i)) 
            return -1;
          else if (_s1.charAt(i) > _s2.charAt(i)) 
            return 1;
        }
        
        return 0;
      }
    }
}
