import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

 class Matrix{
	int x;
	int y;
	boolean visited = false;
	int value;
	int distance;
	public Matrix(int x, int y, boolean visited,int value, int distance) {
		this.x = x;
		this.y = y;
		this.visited = visited;
		this.value = value;
		this.distance = distance;
	}
}
public class Problem2178 {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int distance =1;
		
		boolean visited = false;
		
		Matrix[][] matrix = new Matrix[N+1][M+1];
		Queue<Matrix> q= new LinkedList<>();
		sc.nextLine();
		for(int i=1; i<=N; i++) {
			String s = sc.nextLine();
			for(int j=1; j<=M; j++) {	
				int value = s.charAt(j-1) - '0'; //char - char 의 결과 값은 int형으로 바뀌기 떄문.
				matrix[i][j]= new Matrix(j,i,visited,value,distance);
			}
		}
		
		q.add(matrix[1][1]);
		matrix[1][1].visited=true;
		
		while(!q.isEmpty()) {
			Matrix m = q.remove();
			int x = m.x;
			int y = m.y;
		for(int i=0; i<4; i++) {
			if((x+dx[i]>=1)&&(y+dy[i]>=1)&&(x+dx[i]<=M)&&(y+dy[i]<=N)) {
			
			if((matrix[y+dy[i]][x+dx[i]].visited==false)&&(matrix[y+dy[i]][x+dx[i]].value==1)) {
			q.add(matrix[y+dy[i]][x+dx[i]]);
			matrix[y+dy[i]][x+dx[i]].distance+=m.distance;
			matrix[y+dy[i]][x+dx[i]].visited=true;
			}
			}
		}
		}
		System.out.println(matrix[N][M].distance);
	}

}
