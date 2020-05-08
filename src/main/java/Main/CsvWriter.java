package Main;

import Model.Symbol;
import Model.Token;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void writeTokens(String filename, List<Token> objects) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.write("Token Type,Lexeme,Line Number,Position\n");

        objects.forEach(symbol -> {
            try {
                writer.write(symbol.toString() + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();
    }

    public static void writeSymbols(String filename, List<Symbol> objects) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.write("Identifier,Type\n");

        objects.forEach(symbol -> {
            try {
                writer.write(symbol.toString() + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();
    }
}
