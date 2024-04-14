package com.example.mvphr.SysHelper;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class Helper {
    private static String mailerExec = "C:\\Users\\dm1try\\Desktop\\mailer\\mailer.exe";
    private static String mailerLink = "C:\\Users\\dm1try\\Desktop\\mailer\\mailer.exe";
    private static String mailerContent = "C:\\Users\\dm1try\\Desktop\\mailer\\mailer.exe";

    private static String parserExec = "C:\\Users\\dm1try\\Desktop\\web_to_pdf.exe";

    private static String parserInput = "C:\\Users\\dm1try\\Desktop\\parser\\input.txt";
    private static String parserLink = "C:\\Users\\dm1try\\Desktop\\parser\\output.txt";
    private static String parserRes = "C:\\Users\\dm1try\\Desktop\\parser\\pdf";

    private static void setParse(String s) {
        try (FileWriter writer = new FileWriter(parserInput, false)) {
            writer.write(s);
            writer.flush();
            log.info("SetParse: {}", s);
        } catch (IOException ex) {
            log.info("Catched: {}", ex.getMessage());
        }
    }

    private static String getParseResult() {
        String link = "";
        try (FileReader reader = new FileReader(parserLink)) {
            int c;
            while ((c = reader.read()) != -1) {
                link += ((char) c);
            }
            log.info("Parse result: {}", link);
        } catch (IOException ex) {
            log.info("Catched: {}", ex.getMessage());
        }
        return link;
    }

    public static String parse(String hhLink) {
        setParse(hhLink);
        run(parserExec);
        return getParseResult();
    }

    private static void run(String exe) {
        Process process = null;
        try {
            process = new ProcessBuilder(exe).start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
