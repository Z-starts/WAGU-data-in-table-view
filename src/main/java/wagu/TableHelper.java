package wagu;

import java.util.Arrays;
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

    /**
     * show table like this:
     * <Pre>
     * +--------------+--------------+--------------+--------------+-------------+
     * |     NAME     |    GENDER    |    MARRIED   |      AGE     |  SALARY($)  |
     * +--------------+--------------+--------------+--------------+-------------+
     * |     Eddy     |     Male     |      No      |      23      |   1200.27   |
     * |     Libby    |     Male     |      No      |      17      |    800.50   |
     * |      Rea     |    Female    |      No      |      30      |   10000.00  |
     * |    Deandre   |    Female    |      No      |      19      |   18000.50  |
     * |     Alice    |     Male     |      Yes     |      29      |    580.40   |
     * |     Alyse    |    Female    |      No      |      26      |   7000.89   |
     * |    Venessa   |    Female    |      No      |      22      |  100700.50  |
     * +--------------+--------------+--------------+--------------+-------------+
     * </Pre>
     *
     * @param headersList
     * @param rowsList
     * @param boardWidth
     * @param tableWidth
     */
    public void print(List<String> headersList, List<List<String>> rowsList, int boardWidth, int tableWidth) {
        Board board = new Board(boardWidth);
        Table table = new Table(board, tableWidth, headersList,
                rowsList);
//        table.setGridMode(Table.GRID_COLUMN);
        List<Integer> colAlignList = Arrays
                .asList(Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER);
        table.setColAlignsList(colAlignList);
        String tableString2 = board
                .setInitialBlock(table.tableToBlocks()).build()
                .getPreview();
        System.out.println(tableString2);
    }

    public void printObjList(List<String> headersList, List<?> rowsList, int boardWidth, int tableWidth) {
        print(headersList, BeanConverter.CONVERTER.convert2TableLine(rowsList), boardWidth, tableWidth);
    }

}
