// Copyright (c) 2015 D1SM.net

package net.fs.client;

import org.apache.commons.cli.*;

public class FSClient {

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("b", "back", false, "CLI Mode Enabled");
        options.addOption("min", "minimize",false, "Minimized");
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("java -jar finalspeed.jar [-b/--back]", options);
            System.exit(0);
        }

        boolean visible=!commandLine.hasOption("b");
        boolean min=commandLine.hasOption("min");
        
        
        new ClientUI(visible,min);
    }
}
