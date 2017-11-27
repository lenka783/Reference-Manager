package cz.muni.fi.pa165.referenceManager.utils;

import cz.muni.fi.pa165.referenceManager.exceptions.ExportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * @author David Šarman
 */
public class CSVWriter {
    private static final char SEPARATOR = ',';
    private static final Logger log = LoggerFactory.getLogger(CSVWriter.class);

    private static String formatCSV(String value) {
        if (value.contains("\"")) {
            return value.replace("\"", "\"\"");
        }
        return value;
    }


    public static File writeFile(List<List<String>> data, File file) throws ExportException {
        try (Writer writer = new FileWriter(file)) {
            for (List<String> line : data) {
                writeLine(line, writer);
            }
        } catch (IOException e) {
            String errorMsg = "Exception " + e + " occurred while exporting references as CSV file";
            log.error(errorMsg);
            throw new ExportException(errorMsg, e);
        }
        return file;
    }

    private static void writeLine(List<String> items, Writer writer) throws IOException {
        boolean first = true;

        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            if (!first) {
                sb.append(SEPARATOR);
            }
            sb.append(formatCSV(item));
            first = false;
        }
        sb.append("\n");

        writer.append(sb.toString());
    }
}
