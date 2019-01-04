import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwExpert1868 {
	static class Matrix {
		int x;
		int y;
		public Matrix(int y, int x) {
			this.x=x;
			this.y=y;
		}
	}

	static int dx[] = {-1,0,1,-1,0,1,-1,0,1};
	static int dy[] = {1,1,1,0,0,0,-1,-1,-1};
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for(int t=1; t<=TC; t++) {
			int N = sc.nextInt();
			char[][] a = new char[N+1][N+1];





			sc.nextLine();
			for(int i=1; i<=N; i++) {
				String s = sc.nextLine();
				for(int j=1; j<=N; j++) {
					a[i][j]= s.charAt(j-1);
				}
			}

			boolean visited[][] = new boolean[N+1][N+1];

			Queue<Matrix> q = new LinkedList<>();
			int count=0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if((visited[i][j]==false)&&(a[i][j]=='.')){
						visited[i][j]=true;
						count++;
						boolean con = true;
						for(int k=0; k<8; k++) {
							int rx = dx[k]+j;
							int ry = dy[k]+i;
							if((rx>=0)&&(ry>=0)&&(rx<=N)&&(ry<=N)) {
								if((a[ry][rx]=='*')) {
									con = false;
									break;
								}

							}

						}
						if(!con) {
							continue;	
						}
						Matrix x = new Matrix(i,j);
						q.add(x);
					
						//						visited[i][j]=true;
						while(!q.isEmpty()) {
							x = q.remove();
							
						
							for(int k=0; k<8; k++) {
								int rx = dx[k]+j;
								int ry = dy[k]+i;

								if((rx>=0)&&(ry>=0)&&(rx<=N)&&(ry<=N)) {
									if((a[ry][rx]=='*')) {
										con = false;
										break;
									}
									
								}
							}
							
							for(int k=0; k<8; k++) {
								int rx = dx[k]+j;
								int ry = dy[k]+i;
								q.add(new Matrix(ry,rx));
								visited[ry][rx]=true;
							}
						

						}

					}

				}
			}

			System.out.println(count);
		}













	}
}


