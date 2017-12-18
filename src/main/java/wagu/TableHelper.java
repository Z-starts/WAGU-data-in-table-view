package wagu;

import java.util.List;

/**
 * 表格输出辅助工具
 * Created by xingxing.zhong on 2017/12/18
 *
 * @author xingxing.zhong
 */
public class TableHelper {
    private static TableHelper ourInstance = new TableHelper();

    public static TableHelper getInstance() {
        return ourInstance;
    }

    private TableHelper() {
    }

    public void print(List<String> headersList, List<List<String>> rowsList, int boardWidth, int tableWidth) {
        Board board = new Board(boardWidth);
        String tableString2 = board
                .setInitialBlock(new Table(board, tableWidth, headersList,
                        rowsList)
                        .tableToBlocks()).build()
                .getPreview();
        System.out.println(tableString2);
    }

    public void printObjOut(List<String> headersList, List<?> rowsList, int boardWidth, int tableWidth) {
        Board board = new Board(boardWidth);
        String tableString2 = board
                .setInitialBlock(new Table(board, tableWidth, headersList,
                        BeanConverter.CONVERTER.convert2TableLine(rowsList))
                        .tableToBlocks()).build()
                .getPreview();
        System.out.println(tableString2);
    }

}
