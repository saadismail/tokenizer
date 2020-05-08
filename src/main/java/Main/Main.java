package Main;

import Model.Symbol;

import java.io.IOException;
import java.util.List;

import static Main.Helpers.getUniqueSymbols;

public class Main {

    public static void main(String[] args) throws IOException {

        String code = FileReader.read("code.txt");
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.tokenize(code);

        CsvWriter.writeTokens("token_list.csv", tokenizer.getTokenList());

        List<Symbol> symbolList = getUniqueSymbols(tokenizer.getSymbolTable());

        CsvWriter.writeSymbols("symbol_table.csv", symbolList);
    }

}
