import java.io.*;
import java.util.*;

public class Bj_G3_16235_나무재테크 {

    static int N,M;
    static int[][] add,map;
    static List<Tree> tree;
    static ArrayDeque<Integer> dieTree;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        
        // 현재 땅의 양분과 추가되는 양분의 양 저장 
        map = new int[N][N];
        add = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j] = 5; // 초기 양분은 5 
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 나무 정보 저장
        tree = new ArrayList<>();
        dieTree = new ArrayDeque<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x,y,age));
        }
        
        
        Collections.sort(tree,(t1,t2)->t1.age-t2.age);
        // K년 동안 시행 
        while(K>0) {
        	spring();
        	summer();
        	autumn();
        	winter();
        	K--;
        }
        // 살아 있는 나무의 수 출력 
        System.out.println(tree.size());
        br.close();
    }
    static void spring() {
    	int size = tree.size();
    	for(int i=0;i<size;i++) {
    		Tree now = tree.get(i);
    		if(map[now.x][now.y]<now.age){
    			dieTree.add(i);
    			continue;
    		}
    		map[now.x][now.y] -= now.age;
    		now.age++;
    	}

    }
    static void summer() {
    	while(!dieTree.isEmpty()) {
    		int idx = dieTree.poll();
    		Tree now = tree.get(idx);
    		map[now.x][now.y] += now.age/2; 
    		now.die = true;
    	}
    }
    static void autumn() {
    	ArrayList<Tree> newTree = new ArrayList<>();
    	int[] di = {-1,-1,-1,0,0,1,1,1};
    	int[] dj = {-1,0,1,-1,1,-1,0,1};
    	
    	int size = tree.size();
    	for(int i=0;i<size;i++) {
    		Tree now = tree.get(i);
    		
    		if(now.die) continue;
    		if(now.age%5==0) {
    			for(int d=0;d<8;d++) {
    				int ni = now.x + di[d];
    				int nj = now.y + dj[d];
    				if(!isAvailable(ni,nj)) continue;
    				newTree.add(new Tree(ni,nj,1));
    			}
    		}
    	}
    	for(Tree t:tree) {
    		if(!t.die) newTree.add(t);
    	}
    	tree = newTree;
    }
    static void winter() {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			map[i][j] += add[i][j];
    		}
    	}
    }
    static boolean isAvailable(int x,int y) {
    	if(0<=x && x<N && 0<=y && y<N) return true;
    	return false;
    }
    
    static class Tree{
        int x,y;
        int age;
        boolean die;
        public Tree(int x,int y,int age) {
            this.x = x;
            this.y = y;
            this.age = age;
            this.die = false;
        }
    }
}