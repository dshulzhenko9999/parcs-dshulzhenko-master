import parcs.*;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp implements AM {
    public final static int d = 256;

    public Result search(String text, String pattern) {
                Result result = new Result();
        
                int q = 101;
                int M = pattern.length();
                int N = text.length();
                int i, j;
                int p = 0;
                int t = 0;
                int h = 1;

                for (i = 0; i < M - 1; i++)
                    h = (h * d) % q;

                for (i = 0; i < M; i++) {
                    p = (d * p + pattern.charAt(i)) % q;
                    t = (d * t + text.charAt(i)) % q;
                }

                for (i = 0; i <= N - M; i++) {


                    if (p == t) {

                        for (j = 0; j < M; j++) {
                            if (text.charAt(i + j) != pattern.charAt(j))
                                break;
                        }


                        if (j == M)
                            result.addIndex(i);
                            //System.out.println("Pattern found at index " + i);
                    }

                    if (i < N - M) {
                        t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;

                        if (t < 0)
                            t = (t + q);
                    }
                }
        return result;
    }
    

    public void run(AMInfo info) {
        Input input = (Input) info.parent.readObject();
        String text = input.getText();
        String pattern = input.getPattern();

        System.out.println("Input : text = " + text + ", pattern = " + pattern);

        info.parent.write(search(text, pattern));
    }
}
