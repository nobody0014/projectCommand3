/**
 * Created by Wit on 11/24/2016 AD.
 */
import java.io.*;
import java.net.*;

import com.sanityinc.jargs.CmdLineParser;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

public class Main {

    public static void main(String[] args)
            throws UnknownHostException, MalformedURLException, IOException, URISyntaxException{
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option fileName = parser.addStringOption('f', "fileName");
        try {
            parser.parse(args);
        } catch (Exception oe) {
            System.err.println(oe.getMessage());
            System.exit(1);
        }


        HttpPost post = new HttpPost();
        post.setURI(new URI("http://" + InetAddress.getLocalHost().getHostAddress() + ":19999/upload"));
        HttpClient client =  HttpClients.createDefault();
        post.setHeader("fileName",(String) parser.getOptionValue(fileName));
        client.execute(post);
    }
}
