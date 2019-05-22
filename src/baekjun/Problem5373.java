package baekjun;

import java.util.Scanner;

public class Problem5373 {
	static char[][][] cube;
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int TC = sc.nextInt();


		for(int tc=0; tc<TC; tc++) {
			cube = new char[6][3][3];
			//À­¸é
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[0][i][j]='w';
				}
			}
			//¿ÞÂÊ¸é
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[1][i][j]='g';
				}
			}
			//¾Õ¸é
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[2][i][j]='r';
				}
			}
			//¿À¸¥ÂÊ¸é
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[3][i][j]='b';
				}
			}
			//¹Ø¸é
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[4][i][j]='y';
				}
			}
			//µÞ¸é
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[5][i][j]='o';
				}
			}
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				String s = sc.next();
				char alpha = s.charAt(0);
				char direct = s.charAt(1);
				rearray(alpha,direct);
			}
		}
	}

	private static void rearray(int alpha, char direct) {
		// TODO Auto-generated method stub
		if(alpha=='U') {
			int cnt = 0;
			if(direct=='+') {
				cnt = 1;
			}else {
				cnt = 3;
			}
			for(int i=0; i<cnt; i++) {
				char temp_0 = cube[1][0][0];
				char temp_1 = cube[1][0][1];
				char temp_2 = cube[1][0][2];

				cube[1][0][0] = cube[2][0][0];
				cube[1][0][1] = cube[2][0][1];
				cube[1][0][2] = cube[2][0][2];

				cube[2][0][0] = cube[3][0][0];
				cube[2][0][1] = cube[3][0][1];
				cube[2][0][2] = cube[3][0][2];

				cube[3][0][0] = cube[5][0][0];
				cube[3][0][1] = cube[5][0][1];
				cube[3][0][2] = cube[5][0][2];

				cube[5][0][0] = temp_0;
				cube[5][0][1] = temp_1;
				cube[5][0][2] = temp_2;
			}

			char[][] temp = new char[3][3];
			for(int k=0; k<cnt; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						temp[j][2-i]=cube[0][i][j];
					}
				}
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						cube[0][i][j]=temp[i][j];
					}
				}
			}
		}else if(alpha=='L') {
			int cnt = 0;
			if(direct=='+') {
				cnt = 1;
			}else {
				cnt = 3;
			}
			for(int i=0; i<cnt; i++) {
				char temp_0 = cube[1][0][0];
				char temp_1 = cube[1][0][1];
				char temp_2 = cube[1][0][2];

				cube[1][0][0] = cube[2][0][0];
				cube[1][0][1] = cube[2][0][1];
				cube[1][0][2] = cube[2][0][2];

				cube[2][0][0] = cube[3][0][0];
				cube[2][0][1] = cube[3][0][1];
				cube[2][0][2] = cube[3][0][2];

				cube[3][0][0] = cube[5][0][0];
				cube[3][0][1] = cube[5][0][1];
				cube[3][0][2] = cube[5][0][2];

				cube[5][0][0] = temp_0;
				cube[5][0][1] = temp_1;
				cube[5][0][2] = temp_2;
			}

			char[][] temp = new char[3][3];
			for(int k=0; k<cnt; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						temp[j][2-i]=cube[0][i][j];
					}
				}
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						cube[0][i][j]=temp[i][j];
					}
				}
			}
		}
	}

}
