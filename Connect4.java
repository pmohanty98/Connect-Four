import java.util.Scanner;

public class Connect4 {
    Scanner sc = new Scanner(System.in);
    private char board[][];
    private char red, yellow, empty, deadend;
    private int a = 6, b = 6, c = 6, d = 6, e = 6, f = 6, g = 6;


    public Connect4() {
        board = new char[6][7];

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                board[i][j] = ' ';
            }
        }

        red = 'O';
        yellow = 'X';
        empty = ' ';
        deadend = 'S';
    }

    // Connect4 object = new Connect4();

    public char[][] getBoard() {
        char r[][] = new char[6][7];
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                r[i][j] = board[i][j];
            }
        }
        return r;
    }

    public int putPiece(int column, char color)

    {
        int temp = 0;


        if (column == 0)

        {
            --a;
            if (a <= 5 && a >= 0) {
                board[a][column] = color;
            }
            temp = a;
        } else if (column == 1)

        {
            --b;
            if (b <= 5 && b >= 0) {
                board[b][column] = color;
            }
            temp = b;
        } else if (column == 2)

        {
            --c;
            if (c <= 5 && c >= 0) {
                board[c][column] = color;
            }
            temp = c;
        } else if (column == 3)

        {
            --d;
            if (d <= 5 && d >= 0) {
                board[d][column] = color;
            }
            temp = d;
        } else if (column == 4)

        {
            --e;
            if (e <= 5 && e >= 0) {
                board[e][column] = color;
            }
            temp = e;
        } else if (column == 5)

        {
            --f;
            if (f <= 5 && f >= 0) {
                board[f][column] = color;
            }
            temp = f;
        } else if (column == 6)

        {
            --g;
            if (g <= 5 && g >= 0) {
                board[g][column] = color;
            }
            temp = g;
        }


        return temp;

    }

    public char checkAlignment(int row, int column) {
        int i, j, k = 0;
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 3; j++) {
                if (board[i][j] != empty) {
                    if (board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] &&
                            board[i + 2][j + 2] == board[i + 3][j + 3]) {
                        return board[i][j];
                    }

                }
            }
        }

        for (i = 3; i <= 5; i++) {
            for (j = 0; j <= 3; j++) {
                if (board[i][j] != empty) {
                    if (board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2] &&
                            board[i - 2][j + 2] == board[i - 3][j + 3]) {
                        return board[i][j];
                    }

                }
            }
        }
//row
        for (i = 0; i <= 5; i++) {
            for (j = 0; j <= 3; j++) {
                if (board[i][j] != empty && board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] &&
                        board[i][j + 2] == board[i][j + 3])

                {
                    return board[i][j];
                }


            }
        }
//column
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 6; j++) {
                if (board[i][j] != empty && board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j] &&
                        board[i + 2][j] == board[i + 3][j])

                {
                    return board[i][j];
                }


            }
        }

       /*for(i=0;i<=5;i++)
        { for(j=0;j<=6;j++)
        {
            if(board[i][j]==empty)
            {break;
            }

            else if( board[i][j]==red || board[i][j]==yellow)
        { continue;
        }
        return 'S';


        }}*/

        for (i = 0; i <= 5; i++) {
            for (j = 0; j <= 6; j++) {
                if (board[i][j] == empty) {
                    return empty;
                } else if (board[i][j] == 'X' || board[i][j] == 'O') {
                    if (i == 5 && j == 6) {
                        return 'S';
                    }
                }


            }
        }


        return empty;


    }


    public void printScreen() {
        int i, j;


        System.out.print("\t");
        for (i = 0; i <= 6; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (i = 0; i <= 5; i++) {
            System.out.print(i + "\t");
            for (j = 0; j <= 6; j++) {
                System.out.print(board[i][j] + "\t");

            }
            System.out.println();
        }


    }

    public void play() {
        int row1, column1, row2, column2;
        int flag = 0;
        int flag1;
        int flag2;


        do {

            do {
                flag1 = 0;

                printScreen();


                System.out.println("Current Player: " + red);
                System.out.println("Choose a column: ");
                int column = sc.nextInt();
                int row = putPiece(column, red);
                row1 = row;
                column1 = column;
                if (column < 0 || column > 6 || row < 0) {
                    System.out.println("Please try again");
                    flag1 = 1;
                } else {
                    board[row][column] = red;
                }
            } while (flag1 == 1);


            char wincol = checkAlignment(row1, column1);
            if (wincol == red) {
                System.out.println("!!!Winner is Player " + red + "!!!");
                break;
            } else if (wincol == deadend) {
                System.out.println("DEADEND...That is a tie!");
                break;
            }


            do {
                flag2 = 0;

                printScreen();


                System.out.println("Current Player: " + yellow);
                System.out.println("Choose a column: ");
                int column = sc.nextInt();
                int row = putPiece(column, yellow);
                row2 = row;
                column2 = column;
                if (column < 0 || column > 6 || row < 0) {
                    System.out.println("Please try again");
                    flag2 = 1;
                } else {
                    board[row][column] = yellow;
                }
            } while (flag2 == 1);


            wincol = checkAlignment(row2, column2);
            if (wincol == yellow) {
                System.out.println("!!!Winner is Player " + yellow + "!!!");
                break;
            } else if (wincol == deadend) {
                System.out.println("DEADEND...That is a tie!");
                break;
            }


        } while (flag == 0);

    }


}

