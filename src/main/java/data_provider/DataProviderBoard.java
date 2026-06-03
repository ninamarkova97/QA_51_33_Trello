package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoard {
    @DataProvider
    public Board[] newBoardDP(){
        Board board1 = Board.builder()
                .boardTitle("dfgh45")
                .build();
        Board board2 = Board.builder()
                .boardTitle("dffdg5")
                .build();
        Board board3 = Board.builder()
                .boardTitle("ddfgh5226")
                .build();
        return new Board[]{board1,board2,board3};
    }
    @DataProvider
    public Iterator<Board> newBoardDPFromFile(){
        List<Board> listBoards = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/boards.csv"))){
        String line = bufferedReader.readLine();
        while (line != null){
            listBoards.add(Board.builder().boardTitle(line).build());
            line = bufferedReader.readLine();
        }
        } catch (IOException e) {
           e.printStackTrace();
            System.out.println("created exception");
        }
        return listBoards.listIterator();
    }
}
