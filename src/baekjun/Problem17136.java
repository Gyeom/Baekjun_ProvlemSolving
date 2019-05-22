package baekjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Problem17136 {
	static int[][] map;
	static int count;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		count=0;
		for(int i=0; i<10; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<10; j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1) {
					count++;
				}
			}
		}
		ans=Integer.MAX_VALUE;
		visited = new boolean[10][10];
		dfs(0,0,5,0,0,0,0,0);
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
	static boolean[][] visited;
	static int ans;
	private static void dfs(int y, int x, int end, int one, int two, int three, int four, int five) {
		// TODO Auto-generated method stub
		if(one+two+three+four+five>=ans) {
			return;
		}
		if(one==end+1||two==end+1||three==end+1||four==end+1||five==end+1) {
			return;
		}
		if(count==0) {
			if(one+two+three+four+five<ans) {
				ans=one+two+three+four+five;
			}
			return;
		}
		if(x==10) {
			y++;
			x=0;	
		}
		for(int i=y; i<10; i++) {
			for(int j=x; j<10; j++) {
				if(map[i][j]!=1) continue;
				if(visited[i][j]) continue;
				outloof:
					for(int k=5; k>=0; k--) {
						if(k==0) {
							return;
						}
						if(i+k<0||j+k<0||i+k>10||j+k>10) continue;
						if(count-k*k<0) continue;
						for(int a=i; a<i+k; a++) {
							for(int b=j; b<j+k; b++) {
								if(visited[a][b]) continue outloof;
								if(map[a][b]!=1) continue outloof;
							}
						}
						for(int a=i; a<i+k; a++) {
							for(int b=j; b<j+k; b++) {
								visited[a][b]=true;
								count--;
							}
						}
						switch (k) {
						case 1: dfs(i,j+k,end,one+1,two,three,four,five);
						break;
						case 2: dfs(i,j+k,end,one,two+1,three,four,five);
						break;
						case 3: dfs(i,j+k,end,one,two,three+1,four,five);
						break;
						case 4: dfs(i,j+k,end,one,two,three,four+1,five);
						break;
						case 5: dfs(i,j+k,end,one,two,three,four,five+1);
						break;
						}
						for(int a=i; a<i+k; a++) {
							for(int b=j; b<j+k; b++) {
								visited[a][b]=false;
								count++;
							}
						}
					}
			}
			x=0;
		}
	}
}
